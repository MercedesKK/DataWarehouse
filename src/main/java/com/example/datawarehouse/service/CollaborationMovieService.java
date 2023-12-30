package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.CollaborationMovieMapper;
import com.example.datawarehouse.dto.CollaborationQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public Map<String, Object> getMostPopularActorPairByGenre(int genreId) {
        return collaborationMovieMapper.findMostPopularActorPairByGenre(genreId);
    }
}
