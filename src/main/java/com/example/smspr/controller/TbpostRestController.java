package com.example.smspr.controller;

import com.example.smspr.dto.TbpostDto;
import com.example.smspr.service.TbpostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Tag와 Operation Annotation을 사용해서 API 문서 정의
@Tag(name = "1-1 게시글 API",
        description = "게시글 관련 기능 정의한 RestController") //
@RequestMapping("/api/tbpost")
@RestController
public class TbpostRestController {
    private TbpostService tbpostService;

    public TbpostRestController(TbpostService tbpostService) {
        this.tbpostService = tbpostService;
    }

    @PostMapping("")
    public ResponseEntity<TbpostDto.CreateResDto> create(@Valid @RequestBody TbpostDto.CreateReqDto param) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tbpostService.create(param));
    }
}
