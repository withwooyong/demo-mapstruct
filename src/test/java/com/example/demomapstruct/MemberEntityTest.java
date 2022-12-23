package com.example.demomapstruct;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// https://unluckyjung.github.io/dev/2021/11/20/Dto-Entity-Mapper/
class MemberEntityTest {

    @Test
    void userBodyTest() {
        UserBodyImperialValuesDTO dto = new UserBodyImperialValuesDTO();
        dto.setInch(10);
        dto.setPound(10);

        UserBodyValues obj = UserBodyValuesMapper.INSTANCE.userBodyValuesMapper(dto);

        System.out.println(obj);
        assertNotNull(obj);
        assertEquals(25.4, obj.getKilogram(), 0);
        assertEquals(1000, obj.getCentimeter(), 0);
    }

    @Test
    void toCarTest() {
        // 2b413a00-8d70-4fca-b92d-d62563ac165f
        //        00000000-0000-0000-0000-000000000010
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        CarDTO carDto = CarDTO.builder()
                .id(2147483647L).name("name").price(1000).power(10000L).build();
        Car car = CarMapper.MAPPER.toCar(carDto);
        System.out.println(car);
    }

    @Test
    void toCarListTest() {
        List<CarDTO> carDTOList = new ArrayList<>();
        IntStream.rangeClosed(1, 3).forEach(value -> {
            CarDTO build = CarDTO.builder().id((long) value).name("name" + value).price(value).power(value * 100L).build();
            carDTOList.add(build);
            System.out.println(build);
        });

        //when
        List<Car> carList = CarMapper.MAPPER.toCars(carDTOList);
        carList.forEach(System.out::println);

        //then
//        MemberEntity expectedEntity = new MemberEntity(777L, "yoonsung", 29);
//        assertThat(memberEntity).usingRecursiveComparison().isEqualTo(expectedEntity);
    }


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