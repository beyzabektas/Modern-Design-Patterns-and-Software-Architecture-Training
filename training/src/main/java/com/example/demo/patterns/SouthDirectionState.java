package com.example.demo.patterns;

public class SouthDirectionState implements DirectionState {

    @Override
    public void move(Rover rover) {
        rover.y = rover.y - rover.strategy.getUnit();
    }

    @Override
    public void turnRight(Rover rover) {
        rover.direction = Direction.WEST;
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.direction = Direction.EAST;
    }

    @Override
    public void backward(Rover rover) {
        rover.y = rover.y + rover.strategy.getUnit();
    }

}
