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

    @GetMapping
    public ComResponse<MovieAndTimeStatistics> getMoiveStatistics(@RequestBody MovieAndTimeStatistics movieAndTimeStatistics) {
        int result = movieAndTimeStatisticsService.getMovieStatistics(movieAndTimeStatistics);
        if (result == -1) {
            return ComResponse.error("Invalid arguments for statistics.");
        } else {
            return ComResponse.success(result);
        }
    }
}