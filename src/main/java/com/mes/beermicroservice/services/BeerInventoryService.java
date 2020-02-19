package com.mes.beermicroservice.services;

import java.util.UUID;

/**
 * Created by mesar on 2/17/2020
 */
public interface BeerInventoryService {

    int getOnHandInventory(UUID id);
}
