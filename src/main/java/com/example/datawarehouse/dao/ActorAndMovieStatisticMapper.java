package com.example.datawarehouse.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ActorAndMovieStatisticMapper {
    // 统计特定演员主演的电影数量
    @Select("SELECT COUNT(*) FROM movies m " +
            "INNER JOIN starring_relation sr ON m.movie_id = sr.movie_id " +
            "INNER JOIN actors a ON sr.actor_id = a.actor_id " +
            "WHERE a.actor_name LIKE CONCAT('%', #{actorName}, '%')")
    int countMoviesByActor(@Param("actorName") String actorName);
}
