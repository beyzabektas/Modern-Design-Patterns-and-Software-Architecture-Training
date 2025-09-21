package com.example.demo.patterns;

public class LowModeStrategy implements ModeStrategy {
    @Override
    public Integer getUnit() {
        return 1;
    }
}
