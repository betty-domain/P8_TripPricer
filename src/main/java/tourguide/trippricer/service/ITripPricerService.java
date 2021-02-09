package tourguide.trippricer.service;

import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

public interface ITripPricerService {

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
    List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints);

    /**
     * getProvider name
     * @param apiKey apiKey
     * @param adults number of Adults
     * @return provider name
     */
    String getProviderName(String apiKey, int adults);

}
