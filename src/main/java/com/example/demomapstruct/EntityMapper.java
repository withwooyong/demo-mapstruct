package com.example.demomapstruct;

import java.util.List;

public interface EntityMapper<D, E> {

    E toEntity(final D dto);

    List<E> toEntitys(final List<D> dtos);

    D toDto(final E entity);

    List<D> toDtos(final List<E> entitys);
}
