package com.example.smspr.service.impl;

import com.example.smspr.domain.Tbpost;
import com.example.smspr.dto.TbpostDto;
import com.example.smspr.repository.TbpostRepository;
import com.example.smspr.service.TbpostService;
import org.springframework.stereotype.Service;

@Service
public class TbpostServiceImpl implements TbpostService {
    private TbpostRepository tbpostRepository;

    public TbpostServiceImpl(TbpostRepository tbpostRepository) {
        this.tbpostRepository = tbpostRepository;
    }

    @Override
    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param) {
        return tbpostRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public TbpostDto.CreateResDto update(TbpostDto.UpdateReqDto param) {
        Tbpost tbpost = tbpostRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if (param.getTitle() != null) {
            tbpost.setTitle(param.getTitle());
        }
        if (param.getAuthor() != null) {
            tbpost.setAuthor(param.getAuthor());
        }
        if (param.getContent() != null) {
            tbpost.setContent(param.getContent());
        }
        tbpostRepository.save(tbpost);
        return tbpost.toCreateResDto();
    }
}
