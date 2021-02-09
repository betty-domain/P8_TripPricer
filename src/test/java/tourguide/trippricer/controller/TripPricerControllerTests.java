package tourguide.trippricer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tourguide.trippricer.service.ITripPricerService;
import tripPricer.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TripPricerController.class)
class TripPricerControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ITripPricerService tripPricerService;

    @Test
    void getPriceTest() throws Exception
    {
        List<Provider> providerList = new ArrayList<>();
        providerList.add(new Provider(UUID.randomUUID(),"Provider A",25.2));
        providerList.add(new Provider(UUID.randomUUID(),"Provider B",5.8));

        when(tripPricerService.getPrice(anyString(),any(),anyInt(),anyInt(),anyInt(),anyInt())).thenReturn(providerList);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/price").
                contentType(MediaType.APPLICATION_JSON)
                .param("apiKey","apiKey")
                .param("attractionId",UUID.randomUUID().toString())
                .param("adults","1")
                .param("children","2").param("nightsStay","3")
                .param("rewardsPoints","300");

        mockMvc.perform(builder).
                andExpect(status().isOk()).
                andExpect(jsonPath("$").isArray());
    }

    @Test
    void getProviderNameTest() throws Exception
    {
        when(tripPricerService.getProviderName(anyString(),anyInt())).thenReturn("Provider Name");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/providerName").
                contentType(MediaType.APPLICATION_JSON).
                param("apiKey","apiKey").
                param("adults","20");

        mockMvc.perform(builder).
                andExpect(status().isOk()).
                andExpect(jsonPath("$").value("Provider Name"));
    }
}
