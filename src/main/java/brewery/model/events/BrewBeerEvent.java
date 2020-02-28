package brewery.model.events;

import lombok.NoArgsConstructor;

/**
 * Created by mesar on 2/27/2020
 */
@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
