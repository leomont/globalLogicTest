package com.lmontes.globallogictest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ErrorResponse {

    Timestamp timestamp;
    private int codigo;
    private String detail;
}
