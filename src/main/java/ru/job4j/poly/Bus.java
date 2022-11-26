package ru.job4j.poly;

public class Bus implements Transport {

    int passengerCount = 0;
    boolean isDriving = false;

    @Override
    public void drive() {
        boolean isDriving = true;
    }

    @Override
    public void passenger(int count) {
        passengerCount += count;
    }

    @Override
    public int refuelPrice(int fuelLiters) {
        return fuelLiters * 40;
    }
}
