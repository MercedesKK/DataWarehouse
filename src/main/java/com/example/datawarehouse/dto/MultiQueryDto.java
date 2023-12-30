package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiQueryDto {
    private String movieName;
    private String directorName;
//    private String actorStarringName;
//    private String actorSupportingName;
    private String actorName;
    private String genreName;
    private String formatName;

    private String time;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer weekday;
    private Integer season;

    private Float score;
    private Float minScore;
    private Float maxScore;
    private Integer ispositive;
    private Integer commentNum;
    private Integer runTime;
    private String asin;

    private Integer minYear;
    private Integer maxYear;
    private Integer minMonth;
    private Integer maxMonth;
    private Integer minWeekday;
    private Integer maxWeekday;
}
