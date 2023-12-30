package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.ActorQueryDto;
import com.example.datawarehouse.service.ActorAndMovieStatisticsService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actors/actormovies")
public class ActorAndMovieStatisticsController {
    @Autowired
    private ActorAndMovieStatisticsService actorAndMovieStatisticsService;

    @GetMapping("/starring")
    public ComResponse<Integer> getMovieCountByActor(@RequestBody ActorQueryDto actorQueryDto) {
        int result = actorAndMovieStatisticsService.countMoviesByActor(actorQueryDto);
        return ComResponse.success(result);
    }

    @GetMapping("/supporting")
    public ComResponse<Integer> getMovieCountByActorSupporting(@RequestBody ActorQueryDto actorQueryDto) {
        int result = actorAndMovieStatisticsService.countMoviesByActorSupporting(actorQueryDto);
        return ComResponse.success(result);
    }
}
