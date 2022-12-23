package com.example.demomapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class Car {

    private UUID id;
    private String name;
    private int price;
    private Long power;
}
