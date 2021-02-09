package tourguide.trippricer.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TripPricerServiceTest {

    @Autowired
    ITripPricerService tripPricerService;

    @MockBean
    TripPricer tripPricerMock;

    @Test
    void getPriceTest()
    {
        List<Provider> providerList = new ArrayList<>();
        providerList.add(new Provider(UUID.randomUUID(),"Provider A",25.2));
        providerList.add(new Provider(UUID.randomUUID(),"Provider B",5.8));

        when(tripPricerMock.getPrice(anyString(),any(),anyInt(),anyInt(),anyInt(),anyInt())).thenReturn(providerList);

        assertThat(tripPricerService.getPrice("",UUID.randomUUID(),1,1,1,1).size()).isEqualTo(2);
    }

    @Test
    void getProviderNameTest()
    {
        when(tripPricerMock.getProviderName(anyString(),anyInt())).thenReturn("Provider Name");

        assertThat(tripPricerService.getProviderName("apiKey",1)).isNotBlank();
    }
}
