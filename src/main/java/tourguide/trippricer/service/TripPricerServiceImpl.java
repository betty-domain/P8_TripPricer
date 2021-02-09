package tourguide.trippricer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

/**
 * TripPricer service to interact with external lib TripPricer
 */
@Service
public class TripPricerServiceImpl implements ITripPricerService{

    private final Logger logger = LoggerFactory.getLogger(TripPricerServiceImpl.class);

    @Autowired
    private TripPricer tripPricer;

    /**
     * Constructor of TripPricerImpl Service
     */
    public TripPricerServiceImpl()
    {

    }

    /**
     * get provider list of trips with calculated price for given parameters
     * @param apiKey apiKey
     * @param attractionId attraction id
     * @param adults number of adults
     * @param children number of children
     * @param nightsStay number of nights stayed
     * @param rewardsPoints number of rewardsPoints
     * @return provider list
     */
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints)
    {
        logger.debug("Call to TripPricerServiceImpl.getPrice");
        return  tripPricer.getPrice(apiKey,attractionId,adults, children, nightsStay, rewardsPoints);
    }

    /**
     * getProvider name
     * @param apiKey apiKey
     * @param adults number of Adults
     * @return provider name
     */
    public String getProviderName(String apiKey, int adults)
    {
        logger.debug("Call to TripPricerServiceImpl.getProviderName");
        return tripPricer.getProviderName(apiKey,adults);
    }
}
