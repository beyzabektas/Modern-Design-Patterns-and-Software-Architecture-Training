package com.example.demo.patterns;

public interface DirectionState {
    public void move(Rover rover);

    public void turnRight(Rover rover);

    public void turnLeft(Rover rover);
    
    public void backward(Rover rover);
}
