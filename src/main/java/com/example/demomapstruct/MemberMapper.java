package com.example.demomapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MemberMapper extends EntityMapper<MemberDTO, MemberEntity> {

    MemberMapper MAPPER = Mappers.getMapper(MemberMapper.class);

    @Override
    List<MemberEntity> toEntitys(final List<MemberDTO> dtos);

    @Override
    MemberDTO toDto(final MemberEntity entity);

    @Override
    List<MemberDTO> toDtos(final List<MemberEntity> entitys);

    @Override
    MemberEntity toEntity(final MemberDTO dto);
}