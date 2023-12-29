package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieAndTimeStatistics {
    Integer year;
    Integer month;
    Integer season;
    Integer weekday;
}
