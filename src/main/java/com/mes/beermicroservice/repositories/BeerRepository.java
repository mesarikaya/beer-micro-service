package com.mes.beermicroservice.repositories;

import com.mes.beermicroservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by mesar on 2/12/2020
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {



}
