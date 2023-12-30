package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("<script>" +
            "SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m INNER JOIN movie_release_time_relation mrt ON m.movie_id = mrt.movie_id " +
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
    List<MovieVo> multiCountMovies(@Param("year") Integer year,
                                   @Param("month") Integer month,
                                   @Param("season") Integer season,
                                   @Param("weekday") Integer weekday);

    @Select("<script>" +
            "SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m INNER JOIN movie_release_time_relation mrt ON m.movie_id = mrt.movie_id " +
            "INNER JOIN times t ON mrt.time_id = t.time_id " +
            "<where>" +
            "<if test='minYear != null'>" +
            "AND t.year &gt;= #{minYear} " +
            "</if>" +
            "<if test='maxYear != null'>" +
            "AND t.year &lt;= #{maxYear} " +
            "</if>" +
            "<if test='minMonth != null'>" +
            "AND t.month &gt;= #{minMonth} " +
            "</if>" +
            "<if test='maxMonth != null'>" +
            "AND t.month &lt;= #{maxMonth} " +
            "</if>" +
            "<if test='minWeekday != null'>" +
            "AND t.weekday &gt;= #{minWeekday} " +
            "</if>" +
            "<if test='maxWeekday != null'>" +
            "AND t.weekday &lt;= #{maxWeekday} " +
            "</if>" +
            "</where>" +
            "</script>")
    List<MovieVo> countMoviesByTimeRange(@Param("minYear") Integer minYear,
                                         @Param("maxYear") Integer maxYear,
                                         @Param("minMonth") Integer minMonth,
                                         @Param("maxMonth") Integer maxMonth,
                                         @Param("minWeekday") Integer minWeekday,
                                         @Param("maxWeekday") Integer maxWeekday);
}
