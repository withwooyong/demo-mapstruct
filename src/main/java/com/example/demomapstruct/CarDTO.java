package com.example.demomapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class CarDTO {

    private Long id;
    private String name;
    private int price;
    private Long power;
}
