package com.example.dummyclient.products.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private Float price;
    private Integer existence;
    private Date manufacturDate;
}
