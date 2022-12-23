package com.example.demomapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserBodyValuesMapper {

    UserBodyValuesMapper INSTANCE = Mappers.getMapper(UserBodyValuesMapper.class);

    @Mappings({
            @Mapping(source = "inch", target = "kilogram", qualifiedByName = "inchToKilogram"),
            @Mapping(source = "pound", target = "centimeter", qualifiedByName = "poundToCentimeter")
    })
    UserBodyValues userBodyValuesMapper(UserBodyImperialValuesDTO dto);

    @Named("inchToKilogram")
    static double inchToKilogram(int inch) {
        return inch * 2.54;
    }

    @Named("poundToCentimeter")
    static double poundToCentimeter(int pound) {
        return pound * 100;
    }
}
