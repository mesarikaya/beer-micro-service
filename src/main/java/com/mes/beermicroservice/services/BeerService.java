package com.mes.beermicroservice.services;

import brewery.model.events.BeerDto;
import brewery.model.BeerPagedList;
import brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * Created by mesar on 2/14/2020
 */
public interface BeerService {
    BeerDto getById(UUID beerId, boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, boolean showInventoryOnHand);

    BeerDto getBeerByUpc(long upc);
}
