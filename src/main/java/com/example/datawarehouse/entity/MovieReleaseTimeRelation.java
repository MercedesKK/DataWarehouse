package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("movie_release_time_relation")
public class MovieReleaseTimeRelation {
    private int movieId;
    private int timeId;
}
