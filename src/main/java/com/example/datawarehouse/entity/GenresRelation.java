package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("genres_relation")
public class GenresRelation {
    private int movieId;
    private int genreId;
}
