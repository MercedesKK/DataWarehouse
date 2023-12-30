package com.example.datawarehouse.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MovieFormatsMapper {
    @Select("SELECT COUNT(DISTINCT fr.format_id) " +
            "FROM movies m " +
            "JOIN formats_relation fr ON m.movie_id = fr.movie_id " +
            "JOIN formats f ON fr.format_id = f.format_id " +
            "WHERE f.format_name LIKE CONCAT('%', #{formatName}, '%')")
    int countMovieFormatsByTitle(@Param("formatName") String formatName);
}
