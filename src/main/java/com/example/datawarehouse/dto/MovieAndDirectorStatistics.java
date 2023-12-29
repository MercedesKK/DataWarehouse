package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieAndDirectorStatistics {
    String movieName;
    String directorName;
}
