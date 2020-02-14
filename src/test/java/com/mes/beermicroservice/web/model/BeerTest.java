package com.mes.beermicroservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by mesar on 2/14/2020
 */
public class BeerTest {

    BeerDto getDto(){
        return BeerDto.builder()
                .beerName("Efes")
                .beerStyleEnum(BeerStyleEnum.REGULAR)
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.00"))
                .upc(1231231231L)
                .quantityOnHand(20)
                .build();
    }
}
