package com.company.plans;

import java.io.Serializable;

public class Plan implements Serializable {
    protected double  pricing;
    protected int minutes;
    protected int dataTraffic;


    public Plan(double pricing, int minutes, int data_traffic) {
        this.pricing = pricing;
        this.minutes = minutes;
        this.dataTraffic = data_traffic;
    }

    @Override
    public String toString() {
        return "Plan: " +
                "pricing: " + pricing +
                ", minutes: " + minutes +
                ", data traffic: " + dataTraffic;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getDataTraffic() {
        return dataTraffic;
    }

    public void setDataTraffic(int data_traffic) {
        this.dataTraffic = data_traffic;
    }


}
