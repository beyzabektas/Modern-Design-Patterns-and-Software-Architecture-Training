package com.example.demo.rover;

public class NorthDirectionState implements DirectionState {

    @Override
    public void moveForward(Rover rover) {
        Integer y = rover.getY();
        if (y == 10) {
            throw new IllegalArgumentException();
        }
        rover.setY(y++);
    }

    @Override
    public void moveBackward(Rover rover) {
        Integer y = rover.getY();
        if (y == 0) {
            throw new IllegalArgumentException();
        }
        rover.setY(y--);
    }

    @Override
    public void turnRight(Rover rover) {
        rover.setState(new EastDirectionState());
    }

    @Override
    public void turnLeft(Rover rover) {
        rover.setState(new WestDirectionState());
    }

}
