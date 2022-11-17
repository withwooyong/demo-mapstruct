package com.example.demomapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class MemberEntity {

    private Long id;
    private String name;
    private int age;
}