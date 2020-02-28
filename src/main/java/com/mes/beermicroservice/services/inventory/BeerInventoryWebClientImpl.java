package com.mes.beermicroservice.services.inventory;

import brewery.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by mesar on 2/17/2020
 */
@Slf4j
@ConfigurationProperties(prefix = "com.mes", ignoreUnknownFields = false)
@Service
public class BeerInventoryWebClientImpl implements BeerInventoryService {

    private final String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";
    private final RestTemplate restTemplate;
    private String beerInventoryServiceHost;

    public void setBeerInventoryServiceHost(String beerInventoryServiceHost){
        this.beerInventoryServiceHost = beerInventoryServiceHost;
    }

    public BeerInventoryWebClientImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public int getOnHandInventory(UUID beerId) {

        log.debug("Calling Inventory Service" + beerInventoryServiceHost + INVENTORY_PATH);
        ResponseEntity<List<BeerInventoryDto>> responseEntity = restTemplate
                .exchange(beerInventoryServiceHost + INVENTORY_PATH, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BeerInventoryDto>>(){}, (Object) beerId);
        int onHand = Objects.requireNonNull(responseEntity.getBody()).stream()
                                                                      .mapToInt(BeerInventoryDto::getQuantityOnHand)
                                                                      .sum();
        return onHand;
    }
}
