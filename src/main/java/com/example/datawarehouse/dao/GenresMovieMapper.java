package com.example.datawarehouse.dao;

//import com.example.datawarehouse.dto.GenreMovieDto;
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
}
