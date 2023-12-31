package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.CollaVo;
import com.example.datawarehouse.dto.CollaborationQueryDto;
import com.example.datawarehouse.dto.NewCollborationDto;
import com.example.datawarehouse.service.CollaborationMovieService;
import com.example.datawarehouse.service.NewCollborationService;
import com.example.datawarehouse.utils.ComResponse;
import com.example.datawarehouse.utils.Result;
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
    @Autowired
    private NewCollborationService newCollborationService;

    public static class CollaborationQueryVo {
        private int limit;
        private int genreId;
        private String genreName;
        private int peopleNum;

        public int getPeopleNum() {
            return peopleNum;
        }
        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
        }
        public int getGenreId() {
            return genreId;
        }

        public void setGenreId(int genreId) {
            this.genreId = genreId;
        }
        public String getGenreName() {
            return genreName;
        }

        public void setGenreName(String genreName) {
            this.genreName = genreName;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

//    @GetMapping("/actorandactor")
//    public Result<CollaborationQueryDto> getFrequentActorCollaborations(@RequestBody CollaborationQueryVo collaborationQueryVo) {
//        long startTime = System.currentTimeMillis();
//        List<CollaborationQueryDto> response = collaborationMovieService.getFrequentActorCollaborations(collaborationQueryVo.getLimit());
//        long endTime = System.currentTimeMillis();
//        return Result.success(response, "查询成功", endTime - startTime, 1);
//    }
//
//    @GetMapping("/directorandactor")
//    public ComResponse<CollaborationQueryDto> getFrequentDirectorActorCollaborations(@RequestBody CollaborationQueryVo collaborationQueryVo) {
//        long startTime = System.currentTimeMillis();
//        List<CollaborationQueryDto> response = collaborationMovieService.getFrequentDirectorActorCollaborations(collaborationQueryVo.getLimit());
//        long endTime = System.currentTimeMillis();
//        return ComResponse.success(response, endTime - startTime);
//    }
//
//    @GetMapping("/mostpopular")
//    public ComResponse<Map<String, Objects>> getMostPopularActorPairByGenre(@RequestBody CollaborationQueryVo collaborationQueryVo) {
//        long startTime = System.currentTimeMillis();
//        Map<String, Object> response = collaborationMovieService.getMostPopularActorPairByGenre(collaborationQueryVo.getGenreId());
//        long endTime = System.currentTimeMillis();
//        return ComResponse.success(response, endTime - startTime);
//
//    }
//
    @GetMapping("/cooperateSearch")
    public Result<List<CollaVo>> getCooperateSearch(@RequestBody NewCollborationDto newCollborationDto) {
        try {
            long startTime = System.currentTimeMillis();
            List<CollaVo> response = newCollborationService.findNewCollaboration(newCollborationDto);
            long endTime = System.currentTimeMillis();
            return Result.success(response, "查询成功", endTime - startTime, response.size());
        }
        catch (Exception e) {
            return Result.fail("查询失败");
        }
    }

    @GetMapping("/newmostpopular")
    public Result<List<String>> getNewMostPopularActorPairByGenre(@RequestBody CollaborationQueryVo collaborationQueryVo) {
        long startTime = System.currentTimeMillis();
        try {
            List<String> response = collaborationMovieService.getTopActorsForTopMovieByGenre(collaborationQueryVo.getGenreName(), collaborationQueryVo.getPeopleNum());
            long endTime = System.currentTimeMillis();
            return Result.success(response, "查询成功", endTime - startTime, response.size());
        }
        catch (Exception e) {
            return Result.fail("查询失败");
        }
    }
}
