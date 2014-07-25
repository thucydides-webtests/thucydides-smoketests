package com.bddinaction.flyinghigh.junit;

import com.bddinaction.flyinghigh.model.FrequentFlyer;
import com.bddinaction.flyinghigh.model.Status;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.bddinaction.flyinghigh.model.Status.*;

import static junitparams.JUnitParamsRunner.$;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class WhenEarningStatusWithJUnitParams {

    @Test
    @Parameters({
            "Bronze, 0,   100,  Bronze",
            "Bronze, 0,   300,  Silver",
            "Bronze, 100, 200,  Silver",
            "Bronze, 0,   700,  Gold",
            "Bronze, 0,   1500, Platinum"

    })
    public void shouldUpgradeStatusBasedOnPointsEarned(Status initialStatus, int initialPoints, int earnedPoints, Status finalStatus) {
        FrequentFlyer member = FrequentFlyer.withFrequentFlyerNumber("12345678")
                                            .named("Joe", "Jones")
                                            .withStatusPoints(initialPoints)
                                            .withStatus(initialStatus);

        member.earns(earnedPoints).statusPoints();

        assertThat(member.getStatus()).isEqualTo(finalStatus);
    }

    @Test
    @Parameters(method = "sampleData")
    public void shouldUpgradeStatusFromEarnedPoints(Status initialStatus, int initialPoints, int earnedPoints, Status finalStatus) {
        FrequentFlyer member = FrequentFlyer.withFrequentFlyerNumber("12345678")
                .named("Joe", "Jones")
                .withStatusPoints(initialPoints)
                .withStatus(initialStatus);

        member.earns(earnedPoints).statusPoints();

        assertThat(member.getStatus()).isEqualTo(finalStatus);
    }

    private Object[] sampleData() {
        return $(
                $(Bronze, 0,   100, Bronze),
                $(Bronze, 0,   300, Silver),
                $(Bronze, 100, 200, Silver)
        );
    }


    @Test
    @Parameters(source=StatusTestData.class)
    public void shouldUpgradeStatusFromEarnedPoints2(Status initialStatus, int initialPoints, int earnedPoints, Status finalStatus) {
        FrequentFlyer member = FrequentFlyer.withFrequentFlyerNumber("12345678")
                .named("Joe", "Jones")
                .withStatusPoints(initialPoints)
                .withStatus(initialStatus);

        member.earns(earnedPoints).statusPoints();

        assertThat(member.getStatus()).isEqualTo(finalStatus);
    }

    public static final class StatusTestData {
        public static Object[] provideEarnedPointsTable() {
            return $(
                    $(Bronze, 0,   100, Bronze),
                    $(Bronze, 0,   300, Silver),
                    $(Bronze, 100, 200, Silver)
            );
        }
    }

}
