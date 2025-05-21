package org.scoula.jdbc_ex.dao;

import lombok.AllArgsConstructor
        ;

import lombok.Data
        ;

import lombok.NoArgsConstructor
        ;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO
{
    private String id;
    private String password;
    private String name;
    private String role;
}
