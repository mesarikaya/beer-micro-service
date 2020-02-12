package com.mes.beermicroservice.web.mappers;

import com.mes.beermicroservice.domain.Beer;
import com.mes.beermicroservice.web.model.BeerDto;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-12T22:26:45+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (AdoptOpenJDK)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        beerDto.setUuid( beer.getUuid() );
        beerDto.setVersion( beer.getVersion() );
        beerDto.setCreatedDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.setBeerName( beer.getBeerName() );
        beerDto.setUpc( beer.getUpc() );

        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setUuid( beerDto.getUuid() );
        beer.setVersion( beerDto.getVersion() );
        beer.setCreatedDate( dateMapper.asTimestamp( beerDto.getCreatedDate() ) );
        beer.setLastModifiedDate( dateMapper.asTimestamp( beerDto.getLastModifiedDate() ) );
        beer.setBeerName( beerDto.getBeerName() );
        beer.setUpc( beerDto.getUpc() );

        return beer;
    }
}
