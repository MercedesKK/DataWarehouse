package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("formats_relation")
public class FormatsRelation {
    private int movieId;
    private int formatId;
}
