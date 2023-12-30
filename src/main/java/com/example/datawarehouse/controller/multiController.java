package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieVo;
import com.example.datawarehouse.dto.MultiQueryDto;
import com.example.datawarehouse.service.MovieMultiService;
import com.example.datawarehouse.utils.ComResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies/multisearch")
public class multiController {
    @Autowired
    private MovieMultiService movieMultiService;

    @GetMapping
    public ComResponse<List<MovieVo>> getMultiQueryResult(@RequestBody MultiQueryDto multiQueryDto) {
        return ComResponse.success(movieMultiService.getMultiQueryResult(multiQueryDto));
    }
}
