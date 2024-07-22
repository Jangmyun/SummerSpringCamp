package com.example.smspr.service;

import com.example.smspr.dto.TbpostDto;

public interface TbpostService {
    TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param);

    TbpostDto.CreateResDto update(TbpostDto.UpdateReqDto param);
}
