package com.company.plans;

public class Client {
    private Plan activatedPlan;
    private String clientName;
    private int clientNumber;


    public Client(Plan activatedPlan, String clientName, int clientNumber) {
        this.activatedPlan = activatedPlan;
        this.clientName = clientName;
        this.clientNumber = clientNumber;
    }

    @Override
    public String toString() {
        return "Client: " +
                "activated_plan: " + activatedPlan +
                ", client_name: " + clientName +
                ", client_number: " + clientNumber;
    }

    public Plan getActivatedPlan() {
        return activatedPlan;
    }

    public void setActivatedPlan(Plan activatedPlan) {
        this.activatedPlan = activatedPlan;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }


}
