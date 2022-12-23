package com.example.demomapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-23T10:17:17+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public List<MemberEntity> toEntitys(List<MemberDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<MemberEntity> list = new ArrayList<MemberEntity>( dtos.size() );
        for ( MemberDTO memberDTO : dtos ) {
            list.add( toEntity( memberDTO ) );
        }

        return list;
    }

    @Override
    public MemberDTO toDto(MemberEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MemberDTO.MemberDTOBuilder memberDTO = MemberDTO.builder();

        memberDTO.id( entity.getId() );
        memberDTO.name( entity.getName() );
        memberDTO.age( entity.getAge() );

        return memberDTO.build();
    }

    @Override
    public List<MemberDTO> toDtos(List<MemberEntity> entitys) {
        if ( entitys == null ) {
            return null;
        }

        List<MemberDTO> list = new ArrayList<MemberDTO>( entitys.size() );
        for ( MemberEntity memberEntity : entitys ) {
            list.add( toDto( memberEntity ) );
        }

        return list;
    }

    @Override
    public MemberEntity toEntity(MemberDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MemberEntity.MemberEntityBuilder memberEntity = MemberEntity.builder();

        memberEntity.id( dto.getId() );
        memberEntity.name( dto.getName() );
        memberEntity.age( dto.getAge() );

        return memberEntity.build();
    }
}
