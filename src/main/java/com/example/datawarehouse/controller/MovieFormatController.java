package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.MovieFormatsService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies/format")
public class MovieFormatController {
    @Autowired
    private MovieFormatsService movieFormatsService;

    private static class FormatVo {
        private String formatName;

        public String getFormatName() {
            return formatName;
        }

        public void setFormatName(String format) {
            this.formatName = format;
        }
    }

    @GetMapping
    public ComResponse<Integer> getMovieCountByFormat(@RequestBody FormatVo formatVo) {
        long startTime = System.currentTimeMillis();
        int result = movieFormatsService.getMovieFormatCountByTitle(formatVo.getFormatName());
        long endTime = System.currentTimeMillis();
        return ComResponse.success(result, endTime - startTime);
    }

}
