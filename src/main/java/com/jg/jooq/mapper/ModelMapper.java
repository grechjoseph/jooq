package com.jg.jooq.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class ModelMapper extends ConfigurableMapper {

    @Override
    public void configure(MapperFactory mapperFactory){
        super.configure(mapperFactory);
    }
}
