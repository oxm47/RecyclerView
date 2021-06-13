package com.yorbax.a170311usaammc;

public class DaysModel {
    String daysName;
    String description;

    public DaysModel(String daysName, String description) {
        this.daysName = daysName;
        this.description = description;
    }

    public String getDaysName() {
        return daysName;
    }

    public void setDaysName(String daysName) {
        this.daysName = daysName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
