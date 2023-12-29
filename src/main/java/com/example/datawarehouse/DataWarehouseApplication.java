package com.example.datawarehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.datawarehouse.dao")
public class DataWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataWarehouseApplication.class, args);
    }

}
