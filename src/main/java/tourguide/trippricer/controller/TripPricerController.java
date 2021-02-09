package tourguide.trippricer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
     * get provider list of trips with calculated price for given parameters
     *
     * @param apiKey        apiKey
     * @param attractionId  attraction id
     * @param adults        number of adults
     * @param children      number of children
     * @param nightsStay    number of nights stayed
     * @param rewardsPoints number of rewardsPoints
     * @return provider list
     */
    @GetMapping("/price")
    public List<Provider> getPrice(@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints) {
        logger.debug("Call to TripPricerController.getPrice ");

        return tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }

    /**
     * Return provider nam for specific apikey and number of adults
     *
     * @param apiKey api key
     * @param adults number of adults
     * @return provider name
     */
    @GetMapping("/providerName")
    public String getProviderName(@RequestParam String apiKey, @RequestParam int adults) {
        logger.debug("Call to TripPricerController.getProviderName");
        return tripPricerService.getProviderName(apiKey, adults);
    }

}
