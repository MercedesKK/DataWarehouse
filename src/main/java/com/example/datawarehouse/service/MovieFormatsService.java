package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.MovieFormatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieFormatsService {
    @Autowired
    private MovieFormatsMapper movieFormatsMapper;

    public int getMovieFormatCountByTitle(String formatName) {
        return movieFormatsMapper.countMovieFormatsByTitle(formatName);
    }
}
