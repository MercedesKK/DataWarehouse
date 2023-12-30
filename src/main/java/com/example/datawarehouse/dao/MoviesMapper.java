package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoviesMapper {
    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m ")
    List<MovieVo> selectMovies();

    @Select("<script>" +
            "SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m " +
            "<where>" +
            "<if test='runTime != null'>" +
            "AND m.run_time = #{runTime} " +
            "</if>" +
            "<if test='score != null'>" +
            "AND m.score = #{score} " +
            "</if>" +
            "<if test='ispositive != null'>" +
            "AND m.ispositive = #{ispositive} " +
            "</if>" +
            "<if test='commentNum != null'>" +
            "AND m.comment_num = #{commentNum} " +
            "</if>" +
            "<if test='asin != null'>" +
            "AND m.asin LIKE CONCAT('%', #{asin}, '%') " +
            "</if>" +
            "</where>" +
            "</script>")
    List<MovieVo> concreteSelectMovies(
            @Param("score") Float score,
            @Param("runTime") Integer runTime,
            @Param("ispositive") Integer ispositive,
            @Param("commentNum") Integer commentNum,
            @Param("asin") String asin
    );

    @Select("<script>" +
            "SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m " +
            "<where>" +
            "<if test='minScore != null'>" +
            "AND m.score &gt;= #{minScore} " +
            "</if>" +
            "<if test='maxScore != null'>" +
            "AND m.score &lt;= #{maxScore} " +
            "</if>" +
            "</where>" +
            "</script>")
    List<MovieVo> getMoviesScore(
            @Param("maxScore") Float maxScore,
            @Param("minScore") Float minScore
    );
}
