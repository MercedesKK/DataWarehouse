package com.example.datawarehouse.dao;

//import com.example.datawarehouse.dto.GenreMovieDto;
import com.example.datawarehouse.dto.MovieVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GenresMovieMapper {
    // 查询每个类别的电影数量
    @Select("SELECT COUNT(*) " +
            "FROM movies m " +
            "JOIN genres_relation gr ON m.movie_id = gr.movie_id " +
            "JOIN genres g ON gr.genre_id = g.genre_id " +
            "WHERE g.genre_name LIKE CONCAT('%', #{genreName}, '%')")
    int countMoviesByGenre(@Param("genreName") String genreName);

    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin " +
            "FROM movies m " +
            "JOIN genres_relation gr ON m.movie_id = gr.movie_id " +
            "JOIN genres g ON gr.genre_id = g.genre_id " +
            "WHERE g.genre_name = #{genreName}" +
            "LIMIT 20")
    List<MovieVo> multiCountMoviesByGenre(@Param("genreName") String genreName);
}
