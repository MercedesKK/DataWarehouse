package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.CollaborationMovieMapper;
import com.example.datawarehouse.dto.CollaborationQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborationMovieService {
    @Autowired
    private CollaborationMovieMapper collaborationMovieMapper;

    public List<CollaborationQueryDto> getFrequentActorCollaborations(int limit) {
        return collaborationMovieMapper.findFrequentActorCollaborations(limit);
    }

    public List<CollaborationQueryDto> getFrequentDirectorActorCollaborations(int limit) {
        return collaborationMovieMapper.findFrequentDirectorActorCollaborations(limit);
    }
}
