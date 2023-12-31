package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCollborationDto {
        private Integer cooperateLeftType;
        private Integer cooperateRightType;
        private Integer minCooperationTimes;
        private String cooperateLeftName;
}
