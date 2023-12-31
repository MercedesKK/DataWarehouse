package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.CollaborationMovieMapper;
import com.example.datawarehouse.dao.MoviesMapper;
import com.example.datawarehouse.dto.CollaborationQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollaborationMovieService {
    @Autowired
    private CollaborationMovieMapper collaborationMovieMapper;
    @Autowired
    private MoviesMapper moviesMapper;

    public List<CollaborationQueryDto> getFrequentActorCollaborations(int limit) {
        return collaborationMovieMapper.findFrequentActorCollaborations(limit);
    }

    public List<CollaborationQueryDto> getFrequentDirectorActorCollaborations(int limit) {
        return collaborationMovieMapper.findFrequentDirectorActorCollaborations(limit);
    }

    public Map<String, Object> getMostPopularActorPairByGenre(int genreId) {
        return collaborationMovieMapper.findMostPopularActorPairByGenre(genreId);
    }


    public List<String> getTopActorsForTopMovieByGenre(String genreName, int peopleNum) {
        Integer topMovieId = moviesMapper.findTopMovieByGenre(genreName);
        System.out.println(topMovieId);
        if (topMovieId == null) {
            throw new RuntimeException("No movies found for the given genre.");
        }
        return moviesMapper.findTopActorsByMovie(topMovieId, peopleNum);
    }
}
