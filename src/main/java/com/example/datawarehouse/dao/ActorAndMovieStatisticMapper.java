package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.MovieVo;
import com.example.datawarehouse.dto.MultiQueryDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActorAndMovieStatisticMapper {
    // 统计特定演员主演的电影数量
    @Select("SELECT COUNT(*) FROM movies m " +
            "INNER JOIN starring_relation sr ON m.movie_id = sr.movie_id " +
            "INNER JOIN actors a ON sr.actor_id = a.actor_id " +
            "WHERE a.actor_name LIKE CONCAT('%', #{actorName}, '%')")
    int countMoviesByActor(@Param("actorName") String actorName);

    @Select("SELECT COUNT(*) FROM movies m " +
            "INNER JOIN supporting_relation sr ON m.movie_id = sr.movie_id " +
            "INNER JOIN actors a ON sr.actor_id = a.actor_id " +
            "WHERE a.actor_name LIKE CONCAT('%', #{actorName}, '%')")
    int countMoviesByActorSupporting(@Param("actorName") String actorName);

    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin" +
            " FROM movies m " +
            "INNER JOIN starring_relation sr ON m.movie_id = sr.movie_id " +
            "INNER JOIN actors a ON sr.actor_id = a.actor_id " +
            "WHERE a.actor_name LIKE CONCAT('%', #{actorName}, '%')")
    List<MovieVo> multiCountMoviesByActor(@Param("actorName") String actorName);

    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin" +
            " FROM movies m " +
            "INNER JOIN supporting_relation sr ON m.movie_id = sr.movie_id " +
            "INNER JOIN actors a ON sr.actor_id = a.actor_id " +
            "WHERE a.actor_name LIKE CONCAT('%', #{actorSupportingName}, '%')")
    List<MovieVo> multiCountMoviesByActorsupport(@Param("actorSupportingName") String actorSupportingName);

    @Select("SELECT m.movie_id AS movieId, m.title AS movieName, m.run_time AS runTime, m.score AS score" +
            ", m.ispositive AS ispositive, m.comment_num AS commentNum, m.asin AS asin" +
            " FROM movies m " +
            "INNER JOIN starring_relation sr ON m.movie_id = sr.movie_id " +
            "INNER JOIN actors a ON sr.actor_id = a.actor_id " +
            "WHERE a.actor_name LIKE CONCAT('%', #{actorStarringName}, '%')")
    List<MovieVo> multiCountMoviesByActorstarring(@Param("actorStarringName") String actorStarringName);
}
