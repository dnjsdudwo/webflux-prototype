package com.example.webfluxprototype.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private Date birthDay;
    private String address;
    private String phone;

}
