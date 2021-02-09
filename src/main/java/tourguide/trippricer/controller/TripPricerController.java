package tourguide.trippricer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tourguide.trippricer.model.PriceDto;
import tourguide.trippricer.service.ITripPricerService;
import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

@RestController
public class TripPricerController {

    private static final Logger logger = LogManager.getLogger(TripPricerController.class);

    @Autowired
    private ITripPricerService tripPricerService;

    /**
     * GetPrice for specific user preferences stored in priceDto object
     * @param priceDto pricing variables
     * @return list of provider
     */
    @GetMapping("/price")
    public List<Provider> getPrice(@RequestBody PriceDto priceDto)
    {
        logger.debug("Call to TripPricerController.getPrice ");

        return tripPricerService.getPrice(priceDto.getApiKey(),priceDto.getAttractionId(),priceDto.getAdults(),priceDto.getChildren(),priceDto.getNightsStay(),priceDto.getRewardsPoints());
    }

    /**
     * Return provider nam for specific apikey and number of adults
     * @param apiKey api key
     * @param adults number of adults
     * @return provider name
     */
    @GetMapping("/providerName")
    public String getProviderName(@RequestParam String apiKey, @RequestParam int adults)
    {
        logger.debug("Call to TripPricerController.getProviderName");
        return  tripPricerService.getProviderName(apiKey,adults);
    }

}
