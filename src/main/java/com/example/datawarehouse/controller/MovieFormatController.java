package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.MovieFormatsService;
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
    public int getMovieCountByFormat(@RequestBody FormatVo formatVo) {
        return movieFormatsService.getMovieFormatCountByTitle(formatVo.getFormatName());
    }

}
