package brewery.model.events;

import lombok.NoArgsConstructor;

/**
 * Created by mesar on 2/27/2020
 */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}