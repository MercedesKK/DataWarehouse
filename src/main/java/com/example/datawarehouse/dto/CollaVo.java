package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaVo {
    private String leftCooperationName;
    private String rightCooperationName;
    private Integer cooperationTime;
}
