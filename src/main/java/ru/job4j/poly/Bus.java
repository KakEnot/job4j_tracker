package ru.job4j.poly;

public class Bus implements Transport {

    int passengerCount = 0;
    boolean isDriving = false;

    @Override
    public void Drive() {
        isDriving = true;
    }

    @Override
    public void Passenger(int count) {
        passengerCount += count;
    }

    @Override
    public int refuelPrice(int fuelLiters) {
        return fuelLiters * 40;
    }
}
