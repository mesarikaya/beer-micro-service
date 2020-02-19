package com.mes.beermicroservice.repositories;

import com.mes.beermicroservice.domain.Beer;
import com.mes.beermicroservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by mesar on 2/12/2020
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {


    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    Page<Beer> findAllByBeerName(String beerName, PageRequest pageRequest);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, PageRequest pageRequest);

    Beer findByUpc(Long upc);
}
