package com.example.datawarehouse.dao;

import com.example.datawarehouse.dto.CollaborationQueryDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

}
