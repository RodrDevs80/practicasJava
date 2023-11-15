package com.sertec.api_crud.mapper;

public interface IMapper<I,O> {
    public O map(I in);
}
