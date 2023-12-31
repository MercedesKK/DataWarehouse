package com.example.datawarehouse.controller;

import com.example.datawarehouse.dto.MovieVo;
import com.example.datawarehouse.dto.MultiQueryDto;
import com.example.datawarehouse.service.MovieMultiService;
import com.example.datawarehouse.utils.ComResponse;
import com.example.datawarehouse.utils.Result;
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
    public Result<List<MovieVo>> getMultiQueryResult(@RequestBody MultiQueryDto multiQueryDto) {
        try {
            long startTime = System.currentTimeMillis();
            List<MovieVo> result = movieMultiService.getMultiQueryResult(multiQueryDto);
            long endTime = System.currentTimeMillis();
            return Result.success(result, "查询成功", endTime - startTime, result.size());
        }
        catch (Exception e) {
            return Result.fail("查询失败");
        }
    }
}
