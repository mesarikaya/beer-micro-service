package com.mes.beermicroservice.web.mappers;

import brewery.model.events.BeerDto;
import com.mes.beermicroservice.domain.Beer;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-28T14:20:49+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (AdoptOpenJDK)"
)
@Component
@Qualifier("delegate")
public class BeerMapperImpl_ implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        beerDto.setId( beer.getId() );
        beerDto.setVersion( beer.getVersion() );
        beerDto.setCreatedDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.setBeerName( beer.getBeerName() );
        beerDto.setUpc( beer.getUpc() );
        beerDto.setPrice( beer.getPrice() );

        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setId( beerDto.getId() );
        beer.setVersion( beerDto.getVersion() );
        beer.setCreatedDate( dateMapper.asTimestamp( beerDto.getCreatedDate() ) );
        beer.setLastModifiedDate( dateMapper.asTimestamp( beerDto.getLastModifiedDate() ) );
        beer.setBeerName( beerDto.getBeerName() );
        beer.setUpc( beerDto.getUpc() );
        beer.setPrice( beerDto.getPrice() );

        return beer;
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        beerDto.setId( beer.getId() );
        beerDto.setVersion( beer.getVersion() );
        beerDto.setCreatedDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.setBeerName( beer.getBeerName() );
        beerDto.setUpc( beer.getUpc() );
        beerDto.setPrice( beer.getPrice() );

        return beerDto;
    }
}
