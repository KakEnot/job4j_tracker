package ru.job4j.poly;

public interface Transport {
    void Drive();

    void Passenger(int count);

    int refuelPrice(int fuelLiters);
}
