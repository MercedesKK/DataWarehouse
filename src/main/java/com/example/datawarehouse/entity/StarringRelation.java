package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("starring_relation")
public class StarringRelation {
    private int movieId;
    private int actorId;
}
