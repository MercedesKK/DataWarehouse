package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.MovieAndTimeStatisticsMapper;
import com.example.datawarehouse.dto.MovieAndTimeStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAndTimeStatisticsService {
    @Autowired
    private MovieAndTimeStatisticsMapper movieAndTimeStatisticsMapper;

    public int getMovieStatistics(MovieAndTimeStatistics movieAndTimeStatistics) {
        if (movieAndTimeStatistics.getYear() != null && movieAndTimeStatistics.getMonth() != null) {
            // 统计某一年某月的电影数量
            return movieAndTimeStatisticsMapper.countMoviesByYearAndMonth(movieAndTimeStatistics.getYear(), movieAndTimeStatistics.getMonth());
        } else if (movieAndTimeStatistics.getYear() != null && movieAndTimeStatistics.getSeason() != null) {
            // 统计某一年某季度的电影数量
            return movieAndTimeStatisticsMapper.countMoviesByYearAndSeason(movieAndTimeStatistics.getYear(), movieAndTimeStatistics.getSeason());
        } else if (movieAndTimeStatistics.getWeekday() != null) {
            // 统计特定星期的新增电影数量
            return movieAndTimeStatisticsMapper.countMoviesByWeekday(movieAndTimeStatistics.getWeekday());
        } else if (movieAndTimeStatistics.getYear() != null) {
            // 统计某一年的电影数量
            return movieAndTimeStatisticsMapper.countMoviesByYear(movieAndTimeStatistics.getYear());
        } else {
            return -1;
        }
    }

//    public int countMoviesByYear(int year) {
//        return movieStatisticsMapper.countMoviesByYear(year);
//    }
//
//    public int countMoviesByYearAndMonth(int year, int month) {
//        return movieStatisticsMapper.countMoviesByYearAndMonth(year, month);
//    }
//
//    public int countMoviesByYearAndSeason(int year, int season) {
//        return movieStatisticsMapper.countMoviesByYearAndSeason(year, season);
//    }
//
//    public int countMoviesByWeekday(int weekday) {
//        return movieStatisticsMapper.countMoviesByWeekday(weekday);
//    }


//        if (year != null && month != null) {
//            // 统计某一年某月的电影数量
//            return movieStatisticsService.countMoviesByYearAndMonth(year, month);
//        } else if (year != null && season != null) {
//            // 统计某一年某季度的电影数量
//            return movieStatisticsService.countMoviesByYearAndSeason(year, season);
//        } else if (weekday != null) {
//            // 统计特定星期的新增电影数量
//            return movieStatisticsService.countMoviesByWeekday(weekday);
//        } else if (year != null) {
//            // 统计某一年的电影数量
//            return movieStatisticsService.countMoviesByYear(year);
//        } else {
//            return ComResponse.error("Invalid arguments for statistics.");
//            // 如果没有提供参数，或提供的参数不满足上述任何条件，可以返回错误信息或默认值
//        }
}

