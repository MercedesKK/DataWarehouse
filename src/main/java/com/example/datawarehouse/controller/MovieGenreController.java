package com.example.datawarehouse.controller;

//import com.example.datawarehouse.dto.GenreMovieDto;
import com.example.datawarehouse.service.MovieGerneService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies/genre")
public class MovieGenreController {
    @Autowired
    private MovieGerneService movieGerneService;

    private static class GenreMovieVo {
        private String genreName;

        public String getGenreName() {
            return genreName;
        }

        public void setGenreName(String genreName) {
            this.genreName = genreName;
        }
    }

    @GetMapping
    public ComResponse<Integer> getMovieCountByGenre(@RequestBody GenreMovieVo genreMovieVo) {
        long startTime = System.currentTimeMillis();
        int result = movieGerneService.getMovieCountByGenre(genreMovieVo.getGenreName());
        long endTime = System.currentTimeMillis();
        return ComResponse.success(result, endTime - startTime);
    }
}
