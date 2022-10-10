package com.example.springcurrency.dto;

import lombok.Data;

@Data
public class Currency {

    private String success;
    private Query query;
    private Info info;
    private String date;
    private String result;
}
