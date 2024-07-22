package com.example.smspr.domain;


import com.example.smspr.dto.TbpostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Table(indexes = {
        @Index(columnList = "deleted"),
        @Index(columnList = "process"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "modifiedAt")
})
@Entity
public class Tbpost extends AuditingFields {
    // 엔티티별로 공통부분은 AuditingFields에 선언하고 상속해서 적용하기
     /*@Id private String id;
    @Setter private String deleted;
    @Setter private String createdAt;
    @Setter private String modifiedAt;*/

    @Setter
    @Column(nullable = false, length = 400)
    private String title;

    @Setter
    @Column(nullable = false, length = 400)
    private String author;

    @Setter
    @Column(length = 10000) // default nullable = true  -> 생략 가능
    @Lob
    private String content;

    protected Tbpost() {
    }


    // 생성자 private 으로 설정하고 static 메서드인 of 에서만 Tbpost.of로 Tbpost 객체 전달할 수 있도록 함
    private Tbpost(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public static Tbpost of(String title, String author, String content) {
        return new Tbpost(title, author, content);
    }

    public TbpostDto.CreateResDto toCreateResDto() {
        return TbpostDto.CreateResDto.builder().id(this.getId()).build();
    }
}
