package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieAndTimeStatistics;
import com.example.datawarehouse.service.MovieAndTimeStatisticsService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies/timestats")
public class MovieAndTimeStatisticsController {
    @Autowired
    private MovieAndTimeStatisticsService movieAndTimeStatisticsService;

    @GetMapping("/count")
    public ComResponse<MovieAndTimeStatistics> countMovies(@RequestBody MovieAndTimeStatistics movieAndTimeStatistics) {
        long startTime = System.currentTimeMillis();
        int result = movieAndTimeStatisticsService.countMovies(movieAndTimeStatistics);
        long endTime = System.currentTimeMillis();
        return ComResponse.success(result, endTime - startTime);
    }
}