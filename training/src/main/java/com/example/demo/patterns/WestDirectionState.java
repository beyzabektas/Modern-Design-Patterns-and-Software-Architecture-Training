package com.example.demo.patterns;

public class WestDirectionState implements DirectionState {

    @Override
    public void move(Rover rover) {
        rover.x = rover.x - rover.strategy.getUnit();
    }

    @Override
    public void turnRight(Rover rover) {
        rover.direction = Direction.NORTH;
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.direction = Direction.SOUTH;
    }

    @Override
    public void backward(Rover rover) {
        rover.x = rover.x + rover.strategy.getUnit();
    }
}
