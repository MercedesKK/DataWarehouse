package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("movies")
public class Movies {
    @TableId
    private int movieId;
    private String title;
    private int runTime;
    private float score;
    private int ispositive;
    private int commentNum;
    private String asin;
}
