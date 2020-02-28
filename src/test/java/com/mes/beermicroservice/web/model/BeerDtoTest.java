package com.mes.beermicroservice.web.model;

import brewery.model.events.BeerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BeerTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        BeerDto dto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println(dto);
    }

}