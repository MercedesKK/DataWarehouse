package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.ActorQueryDto;
import com.example.datawarehouse.service.ActorAndMovieStatisticsService;
import com.example.datawarehouse.utils.ComResponse;
import com.example.datawarehouse.utils.Result;
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
    public Result<Integer> getMovieCountByActor(@RequestBody ActorQueryDto actorQueryDto) {
        long startTime = System.currentTimeMillis();
        int result = actorAndMovieStatisticsService.countMoviesByActor(actorQueryDto);
        long endTime = System.currentTimeMillis();
        return Result.success(result, "查询成功", endTime - startTime, 1);
    }

    @GetMapping("/supporting")
    public Result<Integer> getMovieCountByActorSupporting(@RequestBody ActorQueryDto actorQueryDto) {
        long startTime = System.currentTimeMillis();
        int result = actorAndMovieStatisticsService.countMoviesByActorSupporting(actorQueryDto);
        long endTime = System.currentTimeMillis();
        return Result.success(result, "查询成功", endTime - startTime, 1);
    }
}
