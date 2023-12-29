package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.ActorAndMovieStatisticMapper;
import com.example.datawarehouse.dto.ActorQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorAndMovieStatisticsService {
    @Autowired
    private ActorAndMovieStatisticMapper actorAndMovieStatisticMapper;

    public int countMoviesByActor(ActorQueryDto queryDTO) {
        System.out.println(queryDTO.getActorName());
        return actorAndMovieStatisticMapper.countMoviesByActor(queryDTO.getActorName());
    }
}
