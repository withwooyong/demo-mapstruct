package com.example.demomapstruct;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// https://unluckyjung.github.io/dev/2021/11/20/Dto-Entity-Mapper/
class MemberEntityTest {

    @Test
    void toEntityListTest() {
        //given
        MemberDTO memberDTO = new MemberDTO(1L, "yoonsung", 29);
        MemberDTO memberDTO2 = new MemberDTO(2L, "yoonsung", 29);
        MemberDTO memberDTO3 = new MemberDTO(3L, "yoonsung", 29);
        List<MemberDTO> memberDTOList = Arrays.asList(memberDTO, memberDTO2, memberDTO3);
        for (MemberDTO dto : memberDTOList) {
            System.out.println(dto);
        }
        //when
        List<MemberEntity> memberEntities = MemberMapper.MAPPER.toEntitys(memberDTOList);
        for (MemberEntity memberEntity : memberEntities) {
            System.out.println(memberEntity);
        }

        //then
//        MemberEntity expectedEntity = new MemberEntity(777L, "yoonsung", 29);
//        assertThat(memberEntity).usingRecursiveComparison().isEqualTo(expectedEntity);
    }

    @Test
    void toEntityTest() {
        //given
        MemberDTO memberDTO = new MemberDTO(1L, "yoonsung", 29);
        System.out.println(memberDTO);
        //when
        MemberEntity memberEntity = MemberMapper.MAPPER.toEntity(memberDTO);
        System.out.println(memberEntity);

        //then
        MemberEntity expectedEntity = new MemberEntity(777L, "yoonsung", 29);
//        assertThat(memberEntity).usingRecursiveComparison().isEqualTo(expectedEntity);
    }

    @Test
    void toDtoTest() {
        //given
        MemberEntity memberEntity = new MemberEntity(1L, "yoonsung", 30);
        System.out.println(memberEntity);
        //when
        MemberDTO memberDTO = MemberMapper.MAPPER.toDto(memberEntity);
        System.out.println(memberDTO);

        //then
        MemberDTO expectedDTO = new MemberDTO(1L, "yoonsung", 30);
        //assertThat(memberDTO).usingRecursiveComparison().isEqualTo(expectedDTO);
    }

}