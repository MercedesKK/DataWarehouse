package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.MovieAndTimeStatisticsMapper;
import com.example.datawarehouse.dto.MovieAndTimeStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAndTimeStatisticsService {
    @Autowired
    private MovieAndTimeStatisticsMapper movieAndTimeStatisticsMapper;

    public int countMovies(MovieAndTimeStatistics movieAndTimeStatistics) {
        return movieAndTimeStatisticsMapper.countMovies(movieAndTimeStatistics.getYear(), movieAndTimeStatistics.getMonth(), movieAndTimeStatistics.getSeason(), movieAndTimeStatistics.getWeekday());
    }
}

