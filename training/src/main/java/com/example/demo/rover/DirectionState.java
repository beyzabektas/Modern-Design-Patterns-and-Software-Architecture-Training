package com.example.demo.rover;

public interface DirectionState {

    public void moveForward(Rover rover);

    public void moveBackward(Rover rover);

    public void turnRight(Rover rover);

    public void turnLeft(Rover rover);
}
