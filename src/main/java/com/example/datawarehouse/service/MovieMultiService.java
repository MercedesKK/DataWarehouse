package com.example.datawarehouse.service;

import com.example.datawarehouse.dao.*;
import com.example.datawarehouse.dto.MovieVo;
import com.example.datawarehouse.dto.MultiQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieMultiService {
    @Autowired
    private ActorAndMovieStatisticMapper actorAndMovieStatisticMapper;
    @Autowired
    private GenresMovieMapper genresMovieMapper;
    @Autowired
    private MoviesMapper moviesMapper;
    @Autowired
    private MovieAndDirectorStatisticsMapper movieAndDirectorStatisticsMapper;
    @Autowired
    private MovieFormatsMapper movieFormatsMapper;
    @Autowired
    private MovieAndTimeStatisticsMapper movieAndTimeStatisticsMapper;

    public List<MovieVo> getMultiQueryResult(MultiQueryDto multiQueryDto) {
        int paramNum = 0;

        List<MovieVo> resultMovies = new ArrayList<>();


        if (multiQueryDto.getActorName() != null) {
            List<MovieVo> moviesActor = actorAndMovieStatisticMapper.multiCountMoviesByActor(multiQueryDto.getActorName());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesActor;
            } else {
                resultMovies.retainAll(moviesActor);
            }
        }

        if (multiQueryDto.getGenreName() != null) {
            List<MovieVo> moviesGenre = genresMovieMapper.multiCountMoviesByGenre(multiQueryDto.getGenreName());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesGenre;
            } else {
                resultMovies.retainAll(moviesGenre);
            }
        }

        if (multiQueryDto.getDirectorName() != null) {
            List<MovieVo> moviesDirector = movieAndDirectorStatisticsMapper.multiCountMoviesByDirector(multiQueryDto.getDirectorName());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesDirector;
            } else {
                resultMovies.retainAll(moviesDirector);
            }
        }

        if (multiQueryDto.getFormatName() != null) {
            List<MovieVo> moviesFormat = movieFormatsMapper.multiCountMovieFormatsByTitle(multiQueryDto.getFormatName());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesFormat;
            } else {
                resultMovies.retainAll(moviesFormat);
            }
        }

        if (multiQueryDto.getScore() != null || multiQueryDto.getRunTime() != null || multiQueryDto.getCommentNum() != null || multiQueryDto.getIspositive() != null || multiQueryDto.getAsin() != null) {
            List<MovieVo> movies = moviesMapper.concreteSelectMovies(multiQueryDto.getScore(), multiQueryDto.getRunTime(), multiQueryDto.getIspositive(), multiQueryDto.getCommentNum(), multiQueryDto.getAsin());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = movies;
            } else {
                resultMovies.retainAll(movies);
            }
        }

        if (multiQueryDto.getYear() != null || multiQueryDto.getMonth() != null || multiQueryDto.getSeason() != null || multiQueryDto.getWeekday() != null) {
            List<MovieVo> moviesTime = movieAndTimeStatisticsMapper.multiCountMovies(multiQueryDto.getYear(), multiQueryDto.getMonth(), multiQueryDto.getSeason(), multiQueryDto.getWeekday());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesTime;
            } else {
                resultMovies.retainAll(moviesTime);
            }
        }

        if (multiQueryDto.getMaxYear() != null || multiQueryDto.getMinYear() != null || multiQueryDto.getMaxMonth() != null || multiQueryDto.getMinMonth() != null || multiQueryDto.getMaxWeekday() != null || multiQueryDto.getMinWeekday() != null) {
            if (multiQueryDto.getMaxYear() == null) {
                multiQueryDto.setMaxYear(2023);
            }
            if (multiQueryDto.getMinYear() == null) {
                multiQueryDto.setMinYear(1900);
            }
            if (multiQueryDto.getMaxMonth() == null) {
                multiQueryDto.setMaxMonth(12);
            }
            if (multiQueryDto.getMinMonth() == null) {
                multiQueryDto.setMinMonth(1);
            }
            if (multiQueryDto.getMaxWeekday() == null) {
                multiQueryDto.setMaxWeekday(7);
            }
            if (multiQueryDto.getMinWeekday() == null) {
                multiQueryDto.setMinWeekday(1);
            }
            List<MovieVo> moviesTime = movieAndTimeStatisticsMapper.countMoviesByTimeRange(multiQueryDto.getMinYear(), multiQueryDto.getMaxYear(), multiQueryDto.getMinMonth(), multiQueryDto.getMaxMonth(), multiQueryDto.getMinWeekday(), multiQueryDto.getMaxWeekday());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesTime;
            } else {
                resultMovies.retainAll(moviesTime);
            }
        }

        if (multiQueryDto.getMinScore() != null || multiQueryDto.getMaxScore() != null || multiQueryDto.getMinRunTime() != null || multiQueryDto.getMaxRunTime() != null || multiQueryDto.getMinCommentNum() != null || multiQueryDto.getMaxCommentNum() != null) {
            if (multiQueryDto.getMinScore() == null) {
                multiQueryDto.setMinScore(0.0f);
            }
            if (multiQueryDto.getMaxScore() == null) {
                multiQueryDto.setMaxScore(5.0f);
            }
            if (multiQueryDto.getMinRunTime() == null) {
                multiQueryDto.setMinRunTime(0);
            }
            if (multiQueryDto.getMaxRunTime() == null) {
                multiQueryDto.setMaxRunTime(1000);
            }
            if (multiQueryDto.getMinCommentNum() == null) {
                multiQueryDto.setMinCommentNum(0);
            }
            if (multiQueryDto.getMaxCommentNum() == null) {
                multiQueryDto.setMaxCommentNum(1000000);
            }
            List<MovieVo> moviesScore = moviesMapper.getMoviesScore(multiQueryDto.getMaxScore(), multiQueryDto.getMinScore(), multiQueryDto.getMinRunTime(), multiQueryDto.getMaxRunTime(), multiQueryDto.getMinCommentNum(), multiQueryDto.getMaxCommentNum());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesScore;
            } else {
                resultMovies.retainAll(moviesScore);
            }
        }

        if (multiQueryDto.getActorSupportingName() != null) {
            List<MovieVo> moviesActorSupporting = actorAndMovieStatisticMapper.multiCountMoviesByActorsupport(multiQueryDto.getActorSupportingName());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesActorSupporting;
            } else {
                resultMovies.retainAll(moviesActorSupporting);
            }
        }

        if (multiQueryDto.getActorStarringName() != null) {
            List<MovieVo> moviesActorStarring = actorAndMovieStatisticMapper.multiCountMoviesByActorstarring(multiQueryDto.getActorStarringName());
            paramNum += 1;
            if (paramNum == 1) {
                resultMovies = moviesActorStarring;
            } else {
                resultMovies.retainAll(moviesActorStarring);
            }
        }

        if (paramNum == 0) {
            resultMovies = moviesMapper.selectMovies();
        }


        return resultMovies;
    }

}
