package ru.job4j.poly;

public class Bus implements Transport {

    private int passengerCount = 0;
    private boolean isDriving = false;

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
