package com.bddinaction.flyinghigh.junit;

import static com.bddinaction.flyinghigh.model.Status.*;
import static org.fest.assertions.Assertions.assertThat;

import com.bddinaction.flyinghigh.model.FrequentFlyer;
import com.bddinaction.flyinghigh.model.Status;
import com.google.common.collect.ImmutableList;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class WhenEarningStatus {

    @Parameters(name = "{index}: {0} initially had {1} points, earns {2} points, should become {3} ")
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Bronze, 0,    100,  Bronze},
                {Bronze, 0,    300,  Silver},
                {Bronze, 100,  200,  Silver},
                {Bronze, 0,    700,  Gold},
                {Bronze, 0,    1500, Platinum},
        });
    }

    private Status initialStatus;
    private int initialPoints;
    private int earnedPoints;
    private Status finalStatus;

    public WhenEarningStatus(Status initialStatus, int initialPoints, int earnedPoints, Status finalStatus) {
        this.initialStatus = initialStatus;
        this.initialPoints = initialPoints;
        this.earnedPoints = earnedPoints;
        this.finalStatus = finalStatus;
    }

    @Test
    public void shouldUpgradeStatusBasedOnPointsEarned() {
        FrequentFlyer member = FrequentFlyer.withFrequentFlyerNumber("12345678")
                                            .named("Joe", "Jones")
                                            .withStatusPoints(initialPoints)
                                            .withStatus(initialStatus);

        member.earns(earnedPoints).statusPoints();

        assertThat(member.getStatus()).isEqualTo(finalStatus);
    }
}
