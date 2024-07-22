package com.example.smspr.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) // 엔티티 생성/수정 시 createdAt, modifiedAt 같은 필드를 자동 설정
@MappedSuperclass // 공통 필드를 상속할 수 있도록 함 해당 클래스 상속받는 클래스는 MappedSuperClass 로 정의된 필드를 컬럼으로 사용
public abstract class AuditingFields {
    @Id
    private String id;

    @Column(nullable = false)
    @Setter
    protected String deleted;

    @Column()
    @Setter
    protected String process;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate // 생성일시
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate // 수정일시 자동 기입
    @Column(nullable = false)
    protected LocalDateTime modifiedAt;

    // 엔티티가 데이터베이스에 저장되기 전 초기화 작업 (id 생성, deleted N 지정)
    @PrePersist
    public void onPrePersist() {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.deleted = "N";
    }
}
