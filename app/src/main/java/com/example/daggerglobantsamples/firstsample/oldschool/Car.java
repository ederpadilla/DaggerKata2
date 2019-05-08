package com.example.daggerglobantsamples.firstsample.oldschool;

public class Car {

    public Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine.engineKind +
                '}';
    }
}
