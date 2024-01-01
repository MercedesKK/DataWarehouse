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
            "AND m.asin = #{asin} " +
            "</if>" +
            "<if test='movieName != null'>" +
            "AND m.title LIKE CONCAT('%', #{movieName}, '%') " +
            "</if>" +
            "</where>" +
            "</script>")
    List<MovieVo> concreteSelectMovies(
            @Param("score") Float score,
            @Param("runTime") Integer runTime,
            @Param("ispositive") Integer ispositive,
            @Param("commentNum") Integer commentNum,
            @Param("asin") String asin,
            @Param("movieName") String movieName
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
            "<if test='minRunTime != null'>" +
            "AND m.run_time &gt;= #{minRunTime} " +
            "</if>" +
            "<if test='maxRunTime != null'>" +
            "AND m.run_time &lt;= #{maxRunTime} " +
            "</if>" +
            "<if test='minCommentNum != null'>" +
            "AND m.comment_num &gt;= #{minCommentNum} " +
            "</if>" +
            "<if test='maxCommentNum != null'>" +
            "AND m.comment_num &lt;= #{maxCommentNum} " +
            "</if>" +
            "</where>" +
            "</script>")
    List<MovieVo> getMoviesScore(
            @Param("maxScore") Float maxScore,
            @Param("minScore") Float minScore,
            @Param("minRunTime") Integer minRunTime,
            @Param("maxRunTime") Integer maxRunTime,
            @Param("minCommentNum") Integer minCommentNum,
            @Param("maxCommentNum") Integer maxCommentNum
    );

    @Select("SELECT m.movie_id " +
            "FROM movies m " +
            "JOIN genres_relation gr ON m.movie_id = gr.movie_id " +
            "JOIN genres g ON gr.genre_id = g.genre_id " +
            "WHERE g.genre_name = #{genreName} " +
            "ORDER BY m.comment_num DESC " +
            "LIMIT 1")
    Integer findTopMovieByGenre(@Param("genreName") String genreName);

    @Select("SELECT a.actor_name " +
            "FROM (" +
            "    SELECT actor_id FROM starring_relation WHERE movie_id = #{movieId} " +
            "    UNION " +
            "    SELECT actor_id FROM supporting_relation WHERE movie_id = #{movieId} " +
            ") AS combined_actors " +
            "JOIN actors a ON combined_actors.actor_id = a.actor_id " +
            "ORDER BY a.actor_id " +
            "LIMIT #{peopleNum}")
    List<String> findTopActorsByMovie(@Param("movieId") Integer movieId, @Param("peopleNum") int peopleNum);

}
