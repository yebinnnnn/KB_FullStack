package com.kb.starbucks.vo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("p")
public class Product {
    private String prodNo;
    private String prodName;
    private int prodPrice;
}
