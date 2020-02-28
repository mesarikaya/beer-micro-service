package com.mes.beermicroservice.web.mappers;

import com.mes.beermicroservice.domain.Beer;
import com.mes.beermicroservice.services.inventory.BeerInventoryService;
import brewery.model.events.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mesar on 2/18/2020
 */
@Slf4j
public abstract class BeerMapperDecorator implements BeerMapper {
    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return mapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        log.debug("Converting to berDtoInventory");
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }
}
