import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }

    @Test
    void testCashToMilesConversion() {
        double cashAmount = 200.0; // $200
        double milesRate = 0.0035;
        int expectedMiles = (int) (cashAmount / milesRate);
    
        RewardValue rewardValue = new RewardValue(cashAmount);
    
        assertEquals(expectedMiles, rewardValue.getMilesValue(), "Conversion from cash to miles is incorrect");
    }

    @Test
    void testMilesToCashConversion() {
        int milesAmount = 15000; // 15,000 miles
        double expectedCash = milesAmount * RewardValue.MILES_TO_CASH_RATE;

        RewardValue rewardValue = new RewardValue(milesAmount, true);
    
        assertEquals(expectedCash, rewardValue.getCashValue(), "Conversion from miles to cash is incorrect");
    }
}
