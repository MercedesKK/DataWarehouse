package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieFormatsMapper {
    @Select("SELECT COUNT(DISTINCT fr.format_id) " +
            "FROM movies m " +
            "JOIN formats_relation fr ON m.movie_id = fr.movie_id " +
            "JOIN formats f ON fr.format_id = f.format_id " +
            "WHERE f.format_name LIKE CONCAT('%', #{formatName}, '%')")
    int countMovieFormatsByTitle(@Param("formatName") String formatName);

    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m " +
            "JOIN formats_relation fr ON m.movie_id = fr.movie_id " +
            "JOIN formats f ON fr.format_id = f.format_id " +
            "WHERE f.format_name LIKE CONCAT('%', #{formatName}, '%')")
    List<MovieVo> multiCountMovieFormatsByTitle(@Param("formatName") String formatName);
}
