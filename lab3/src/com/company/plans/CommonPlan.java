package com.company.plans;

import java.io.Serializable;

public class CommonPlan extends Plan implements Serializable {
    public CommonPlan(double pricing, int minutes, int dataTraffic) {
        super(pricing, minutes, dataTraffic);
    }

    @Override
    public String toString() {
        return "CommonPlan: " +
                "pricing: " + pricing +
                ", minutes: " + minutes +
                ", data_traffic: " + dataTraffic;
    }
}
