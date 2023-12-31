package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.CollaVo;
import com.example.datawarehouse.dto.CollaborationQueryDto;
import com.example.datawarehouse.dto.NewCollborationDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CollaborationMovieMapper {
    @Select("SELECT a1.actor_name AS actorName1, a2.actor_name AS actorName2, COUNT(*) AS collaborationCount " +
            "FROM starring_relation sr1 " +
            "JOIN starring_relation sr2 ON sr1.movie_id = sr2.movie_id AND sr1.actor_id < sr2.actor_id " +
            "JOIN actors a1 ON sr1.actor_id = a1.actor_id " +
            "JOIN actors a2 ON sr2.actor_id = a2.actor_id " +
            "GROUP BY sr1.actor_id, sr2.actor_id " +
            "ORDER BY collaborationCount DESC " +
            "LIMIT #{limit}")
    List<CollaborationQueryDto> findFrequentActorCollaborations(@Param("limit") int limit);

    @Select("SELECT d.director_name AS directorName, a.actor_name AS actorName1, COUNT(*) AS collaborationCount " +
            "FROM directors_relation dr " +
            "JOIN starring_relation sr ON dr.movie_id = sr.movie_id " +
            "JOIN directors d ON dr.director_id = d.director_id " +
            "JOIN actors a ON sr.actor_id = a.actor_id " +
            "GROUP BY dr.director_id, sr.actor_id " +
            "ORDER BY collaborationCount DESC " +
            "LIMIT #{limit}")
    List<CollaborationQueryDto> findFrequentDirectorActorCollaborations(@Param("limit") int limit);

    @Select("SELECT a1.actor_name AS actor1, a2.actor_name AS actor2, " +
            "COUNT(*) AS movie_count, AVG(m.score) AS avg_score, SUM(m.comment_num) AS total_comments " +
            "FROM starring_relation sr1 " +
            "JOIN starring_relation sr2 ON sr1.movie_id = sr2.movie_id AND sr1.actor_id < sr2.actor_id " +
            "JOIN actors a1 ON sr1.actor_id = a1.actor_id " +
            "JOIN actors a2 ON sr2.actor_id = a2.actor_id " +
            "JOIN movies m ON sr1.movie_id = m.movie_id " +
            "JOIN genres_relation gr ON m.movie_id = gr.movie_id " +
            "WHERE gr.genre_id = #{genreId} " +
            "GROUP BY a1.actor_name, a2.actor_name " +
            "ORDER BY movie_count DESC, avg_score DESC, total_comments DESC " +
            "LIMIT 1")
    Map<String, Object> findMostPopularActorPairByGenre(@Param("genreId") int genreId);

    @Select("SELECT " +
            " leftCooperationName, " +
            " rightCooperationName, " +
            " COUNT(*) AS cooperationTime " +
            "FROM ( " +
            " SELECT " +
            " m.movie_id, " +
            " CASE " +
            " WHEN #{cooperateLeftType} = 0 THEN a.actor_name " +
            " ELSE d.director_name " +
            " END AS leftCooperationName, " +
            " CASE " +
            " WHEN #{cooperateRightType} = 0 THEN a2.actor_name " +
            " ELSE d2.director_name " +
            " END AS rightCooperationName " +
            " FROM " +
            " movies m " +
            " LEFT JOIN " +
            " starring_relation sr ON m.movie_id = sr.movie_id " +
            " LEFT JOIN " +
            " actors a ON sr.actor_id = a.actor_id AND #{cooperateLeftType} = 0 " +
            " LEFT JOIN " +
            " directors_relation dr ON m.movie_id = dr.movie_id " +
            " LEFT JOIN " +
            " directors d ON dr.director_id = d.director_id AND #{cooperateLeftType} = 1 " +
            " LEFT JOIN " +
            " starring_relation sr2 ON m.movie_id = sr2.movie_id " +
            " LEFT JOIN " +
            " actors a2 ON sr2.actor_id = a2.actor_id AND #{cooperateRightType} = 0 " +
            " LEFT JOIN " +
            " directors_relation dr2 ON m.movie_id = dr2.movie_id " +
            " LEFT JOIN " +
            " directors d2 ON dr2.director_id = d2.director_id AND #{cooperateRightType} = 1 " +
            " WHERE " +
//            " (#{cooperateLeftType} = 0 AND a.actor_name LIKE CONCAT('%', #{cooperateLeftName}, '%')) " +
            " (#{cooperateLeftType} = 0 AND a.actor_name = #{cooperateLeftName}) " +
            " OR " +
//            " (#{cooperateLeftType} = 1 AND d.director_name LIKE CONCAT('%', #{cooperateLeftName}, '%')) " +
            " (#{cooperateLeftType} = 1 AND d.director_name = #{cooperateLeftName}) " +
            ") AS sub " + // 这里添加了缺失的闭合括号
            "GROUP BY " +
            " leftCooperationName, rightCooperationName " +
            "HAVING " +
            " COUNT(*) >= #{minCooperationTimes} ")
    List<CollaVo> findSpecificCollaborations(@Param("cooperateLeftType") int cooperateLeftType,
                                             @Param("cooperateRightType") int cooperateRightType,
                                             @Param("minCooperationTimes") int minCooperationTimes,
                                             @Param("cooperateLeftName") String cooperateLeftName);

    @Select("SELECT  " +
            "    a.actor_name AS leftCooperationName, " +
            "    a2.actor_name AS rightCooperationName, " +
            "    COUNT(*) AS cooperationTime " +
            "FROM  " +
            "    movies m " +
            "JOIN  " +
            "    starring_relation sr ON m.movie_id = sr.movie_id " +
            "JOIN  " +
            "    actors a ON sr.actor_id = a.actor_id " +
            "JOIN  " +
            "    starring_relation sr2 ON m.movie_id = sr2.movie_id " +
            "JOIN  " +
            "    actors a2 ON sr2.actor_id = a2.actor_id " +
            "WHERE  " +
            "    a.actor_id < a2.actor_id " +
            "GROUP BY  " +
            "    leftCooperationName, rightCooperationName " +
            "HAVING  " +
            "    cooperationTime >= #{minCooperationTimes} " +
            "ORDER BY  " +
            "    cooperationTime DESC " +
            "LIMIT 50 ")
    List<CollaVo> nextfindSpecificCollaborations(@Param("minCooperationTimes") int minCooperationTimes);
}
