package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("supporting_relation")
public class SupportingRelation {
    private int movieId;
    private int actorId;
}
