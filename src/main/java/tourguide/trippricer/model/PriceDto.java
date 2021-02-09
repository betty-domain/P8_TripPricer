package tourguide.trippricer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PriceDto {
    private String apiKey;

    private UUID attractionId;

    private int adults;

    private int children;

    private int nightsStay;

    private int rewardsPoints;

    public PriceDto()
    {

    }

    public PriceDto(String apiKey, int adults, int children, int nightsStay, int rewardsPoints, UUID attractionId)
    {
        this.apiKey = apiKey;
        this.adults = adults;
        this.children = children;
        this.attractionId = attractionId;
        this.nightsStay = nightsStay;
        this.rewardsPoints = rewardsPoints;
    }
}
