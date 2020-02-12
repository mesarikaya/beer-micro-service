package com.mes.beermicroservice.bootstrap;

import com.mes.beermicroservice.domain.Beer;
import com.mes.beermicroservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by mesar on 2/12/2020
 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects(){
        if(beerRepository.count()==0){

            beerRepository.save(Beer.builder()
                    .beerName("Efes Pilsener")
                    .beerStyle("Regular")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(337010000001L)
                    .price(new BigDecimal("6.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Tuborg")
                    .beerStyle("Regular")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(337510000001L)
                    .price(new BigDecimal("7.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Leffe")
                    .beerStyle("Blonde")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(338010000001L)
                    .price(new BigDecimal("14.95"))
                    .build());
        }
    }
}
