package com.example.daggerglobantsamples.firstsample.oldschool;

public class Engine {

    public String engineKind;

    public Engine(String engineKind) {
        this.engineKind = engineKind;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineKind='" + engineKind + '\'' +
                '}';
    }
}
