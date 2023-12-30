package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.CollaborationQueryDto;
import com.example.datawarehouse.service.CollaborationMovieService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/collaborationmovies")
public class CollaborationMovieController {
    @Autowired
    private CollaborationMovieService collaborationMovieService;

    public static class CollaborationQueryVo {
        private int limit;
        private int genreId;

        public int getGenreId() {
            return genreId;
        }

        public void setGenreId(int genreId) {
            this.genreId = genreId;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    @GetMapping("/actorandactor")
    public ComResponse<CollaborationQueryDto> getFrequentActorCollaborations(@RequestBody CollaborationQueryVo collaborationQueryVo) {
        long startTime = System.currentTimeMillis();
        List<CollaborationQueryDto> response = collaborationMovieService.getFrequentActorCollaborations(collaborationQueryVo.getLimit());
        long endTime = System.currentTimeMillis();
        return ComResponse.success(response, endTime - startTime);
    }

    @GetMapping("/directorandactor")
    public ComResponse<CollaborationQueryDto> getFrequentDirectorActorCollaborations(@RequestBody CollaborationQueryVo collaborationQueryVo) {
        long startTime = System.currentTimeMillis();
        List<CollaborationQueryDto> response = collaborationMovieService.getFrequentDirectorActorCollaborations(collaborationQueryVo.getLimit());
        long endTime = System.currentTimeMillis();
        return ComResponse.success(response, endTime - startTime);
    }

    @GetMapping("/mostpopular")
    public ComResponse<Map<String, Objects>> getMostPopularActorPairByGenre(@RequestBody CollaborationQueryVo collaborationQueryVo) {
        long startTime = System.currentTimeMillis();
        Map<String, Object> response = collaborationMovieService.getMostPopularActorPairByGenre(collaborationQueryVo.getGenreId());
        long endTime = System.currentTimeMillis();
        return ComResponse.success(response, endTime - startTime);

    }
}
