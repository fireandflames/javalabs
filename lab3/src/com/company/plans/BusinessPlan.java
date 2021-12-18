package com.company.plans;

import java.io.Serializable;

public class BusinessPlan extends Plan implements Serializable {
    public BusinessPlan(double pricing, int minutes, int dataTraffic) {
        super(pricing, minutes, dataTraffic);
    }

    @Override
    public String toString() {
        return "BusinessPlan: " +
                "pricing: " + pricing +
                ", minutes: " + minutes +
                ", data_traffic: " + dataTraffic;
    }
}
