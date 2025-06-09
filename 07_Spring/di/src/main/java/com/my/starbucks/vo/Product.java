package com.my.starbucks.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data  //@Getter, @Setter,@ToString, equals(), hashCode(),
@NoArgsConstructor
@AllArgsConstructor
@Component("p")
public class Product {
    private String prodNo;
    private String prodName;
    private int prodPrice;
}
