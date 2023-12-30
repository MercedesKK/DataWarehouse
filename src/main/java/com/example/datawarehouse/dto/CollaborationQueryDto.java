package com.example.datawarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaborationQueryDto {
    private String directorName;
    private String actorName1;
    private String actorName2;
    private int collaborationCount;
}
