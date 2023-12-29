package com.example.datawarehouse.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MovieAndTimeStatisticsMapper {
    // 统计某一年的电影数量
    @Select("SELECT COUNT(*) FROM movie_release_time_relation mrt " +
            "INNER JOIN times t ON mrt.time_id = t.time_id " +
            "WHERE t.year = #{year}")
    int countMoviesByYear(@Param("year") int year);

    // 统计某一年某一月的电影数量
    @Select("SELECT COUNT(*) FROM movie_release_time_relation mrt " +
            "INNER JOIN times t ON mrt.time_id = t.time_id " +
            "WHERE t.year = #{year} AND t.month = #{month}")
    int countMoviesByYearAndMonth(@Param("year") int year, @Param("month") int month);

    // 统计某一年某一季度的电影数量
    @Select("SELECT COUNT(*) FROM movie_release_time_relation mrt " +
            "INNER JOIN times t ON mrt.time_id = t.time_id " +
            "WHERE t.year = #{year} AND t.season = #{season}")
    int countMoviesByYearAndSeason(@Param("year") int year, @Param("season") int season);

    // 统计特定星期几的新增电影数量
    @Select("SELECT COUNT(*) FROM movie_release_time_relation mrt " +
            "INNER JOIN times t ON mrt.time_id = t.time_id " +
            "WHERE t.weekday = #{weekday}")
    int countMoviesByWeekday(@Param("weekday") int weekday);
}
