package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.MovieAndDirectorStatisticsMapper;
import com.example.datawarehouse.dto.MovieAndDirectorStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAndDirectorStatisticsService {
    @Autowired
    private  MovieAndDirectorStatisticsMapper movieAndDirectorStatisticsMapper;

    // 其他方法...

    public int countMoviesByDirector(MovieAndDirectorStatistics movieAndDirectorStatistics) {
        return movieAndDirectorStatisticsMapper.countMoviesByDirector(movieAndDirectorStatistics.getDirectorName());
    }
}
