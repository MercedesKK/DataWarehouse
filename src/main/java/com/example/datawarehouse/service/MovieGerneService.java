package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.GenresMovieMapper;
//import com.example.datawarehouse.dto.GenreMovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGerneService {
    @Autowired
    private GenresMovieMapper genresMovieMapper;

    public int getMovieCountByGenre(String genreName) {
        return genresMovieMapper.countMoviesByGenre(genreName);
    }
}
