package com.mes.beermicroservice.web.mappers;

import com.mes.beermicroservice.domain.Beer;
import brewery.model.events.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * Created by mesar on 2/12/2020
 */
@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
