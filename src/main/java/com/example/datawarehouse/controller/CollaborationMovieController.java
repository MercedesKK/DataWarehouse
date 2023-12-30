package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.CollaborationQueryDto;
import com.example.datawarehouse.service.CollaborationMovieService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collaborationmovies")
public class CollaborationMovieController {
    @Autowired
    private CollaborationMovieService collaborationMovieService;

    public static class CollaborationQueryVo {
        private int limit;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    @GetMapping("/actorandactor")
    public ComResponse<CollaborationQueryDto> getFrequentActorCollaborations(@RequestBody CollaborationQueryVo collaborationQueryVo) {
        return ComResponse.success(collaborationMovieService.getFrequentActorCollaborations(collaborationQueryVo.getLimit()));
    }

    @GetMapping("/directorandactor")
    public ComResponse<CollaborationQueryDto> getFrequentDirectorActorCollaborations(@RequestBody CollaborationQueryVo collaborationQueryVo) {
        return ComResponse.success(collaborationMovieService.getFrequentDirectorActorCollaborations(collaborationQueryVo.getLimit()));
    }
}