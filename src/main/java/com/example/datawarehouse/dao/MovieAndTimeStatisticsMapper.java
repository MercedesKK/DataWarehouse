package com.example.datawarehouse.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MovieAndTimeStatisticsMapper {
    // 统计某一年的电影数量
    @Select("<script>" +
                "SELECT COUNT(*) FROM movie_release_time_relation mrt " +
                "INNER JOIN times t ON mrt.time_id = t.time_id " +
                "<where>" +
                    "<if test='year != null'>" +
                    "AND t.year = #{year} " +
                    "</if>" +
                    "<if test='month != null'>" +
                    "AND t.month = #{month} " +
                    "</if>" +
                    "<if test='season != null'>" +
                    "AND t.season = #{season} " +
                    "</if>" +
                    "<if test='weekday != null'>" +
                    "AND t.weekday = #{weekday} " +
                    "</if>" +
                "</where>" +
            "</script>")
    int countMovies(@Param("year") Integer year,
                    @Param("month") Integer month,
                    @Param("season") Integer season,
                    @Param("weekday") Integer weekday);
}
