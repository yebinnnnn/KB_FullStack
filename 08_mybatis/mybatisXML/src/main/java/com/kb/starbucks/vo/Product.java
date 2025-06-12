package com.kb.starbucks.vo;
import lombok.*;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String prodNo;
    private String prodName;
    private int prodPrice;
}