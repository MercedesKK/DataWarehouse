package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieAndDirectorStatisticsMapper {
    @Select("SELECT COUNT(*) FROM movies m " +
            "INNER JOIN directors_relation dr ON m.movie_id = dr.movie_id " +
            "INNER JOIN directors d ON dr.director_id = d.director_id " +
            "WHERE d.director_name LIKE CONCAT('%', #{directorName}, '%')")
    int countMoviesByDirector(@Param("directorName") String directorName);

    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m " +
            "INNER JOIN directors_relation dr ON m.movie_id = dr.movie_id " +
            "INNER JOIN directors d ON dr.director_id = d.director_id " +
            "WHERE d.director_name LIKE CONCAT('%', #{directorName}, '%')")
    List<MovieVo> multiCountMoviesByDirector(@Param("directorName") String directorName);
}
