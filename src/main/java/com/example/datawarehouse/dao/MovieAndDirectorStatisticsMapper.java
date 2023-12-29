package com.example.datawarehouse.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MovieAndDirectorStatisticsMapper {
    @Select("SELECT COUNT(*) FROM movies m " +
            "INNER JOIN directors_relation dr ON m.movie_id = dr.movie_id " +
            "INNER JOIN directors d ON dr.director_id = d.director_id " +
            "WHERE d.director_name LIKE CONCAT('%', #{directorName}, '%')")
    int countMoviesByDirector(@Param("directorName") String directorName);

}
