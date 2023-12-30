package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieVo {
    private int movieId;
    private String movieName;
    private int runTime;
    private float score;
    private int ispositive;
    private int commentNum;
    private String asin;
}
