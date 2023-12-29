package com.example.datawarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("times")
public class Times {
    @TableId
    private int timeId;
    private String time;
    private int year;
    private int month;
    private int day;
    private int weekday;
    private int season;
}
