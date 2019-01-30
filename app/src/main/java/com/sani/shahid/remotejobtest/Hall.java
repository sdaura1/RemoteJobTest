package com.sani.shahid.remotejobtest;

public class Hall{

    int numOfScreen;
    String capacity;
    String name;

    public String getScreenLayout() {
        return screenLayout;
    }

    public void setScreenLayout(String screenLayout) {
        this.screenLayout = screenLayout;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    String screenLayout;
    String time;
    String cinemaId;

    public Hall(int numOfScreen, String capacity, String name, String screenLayout, String time, String cinemaId) {
        this.numOfScreen = numOfScreen;
        this.capacity = capacity;
        this.name = name;
        this.screenLayout = screenLayout;
        this.time = time;
        this.cinemaId = cinemaId;
    }

    public int getNumOfScreen() {
        return numOfScreen;
    }

    public void setNumOfScreen(int numOfScreen) {
        this.numOfScreen = numOfScreen;
    }

    public Hall() {
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
