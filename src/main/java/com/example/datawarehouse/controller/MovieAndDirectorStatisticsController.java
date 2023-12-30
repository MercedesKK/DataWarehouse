package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieAndDirectorStatistics;
import com.example.datawarehouse.service.MovieAndDirectorStatisticsService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies/directorstats")
public class MovieAndDirectorStatisticsController {
    @Autowired
    private MovieAndDirectorStatisticsService movieAndDirectorStatisticsService;

    @GetMapping
    public ComResponse<Integer> getMovieCountByDirector(@RequestBody MovieAndDirectorStatistics movieAndDirectorStatistics) {
        long startTime = System.currentTimeMillis();
        int result = movieAndDirectorStatisticsService.countMoviesByDirector(movieAndDirectorStatistics);
        long endTime = System.currentTimeMillis();
        return ComResponse.success(result, endTime - startTime);
    }
}
