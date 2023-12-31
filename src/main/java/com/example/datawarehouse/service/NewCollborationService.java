package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.CollaborationMovieMapper;
import com.example.datawarehouse.dto.CollaVo;
import com.example.datawarehouse.dto.NewCollborationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewCollborationService {
    @Autowired
    private CollaborationMovieMapper collaborationMovieMapper;

    public List<CollaVo> findNewCollaboration(NewCollborationDto newCollborationDto) {
        if (newCollborationDto.getCooperateLeftName() != null) {
            return collaborationMovieMapper.findSpecificCollaborations(newCollborationDto.getCooperateLeftType(),
                    newCollborationDto.getCooperateRightType(), newCollborationDto.getMinCooperationTimes(),
                    newCollborationDto.getCooperateLeftName());
        } else {
            return collaborationMovieMapper.nextfindSpecificCollaborations(newCollborationDto.getMinCooperationTimes());
        }
    }
}
