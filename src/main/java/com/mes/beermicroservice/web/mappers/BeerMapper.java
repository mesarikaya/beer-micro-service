package com.mes.beermicroservice.web.mappers;

import com.mes.beermicroservice.domain.Beer;
import com.mes.beermicroservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by mesar on 2/12/2020
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
