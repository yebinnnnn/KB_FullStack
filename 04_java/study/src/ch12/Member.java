package ch12;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Member {
    private String id;
    private String name;
    private int age;
}
