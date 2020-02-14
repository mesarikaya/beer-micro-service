package com.mes.beermicroservice.services;

import com.mes.beermicroservice.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by mesar on 2/14/2020
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
