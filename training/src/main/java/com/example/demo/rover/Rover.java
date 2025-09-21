package com.example.demo.rover;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rover {

    private Integer x;
    private Integer y;
    private DirectionState state;

    public Rover(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        if (direction == Direction.EAST) {
            this.state = new EastDirectionState();
        } else if (direction == Direction.WEST) {
            this.state = new WestDirectionState();
        } else if (direction == Direction.SOUTH) {
            this.state = new SouthDirectionState();
        } else if (direction == Direction.NORTH) {
            this.state = new NorthDirectionState();
        }
    }

    public void moveForward() {
        this.state.moveForward(this);


        //MMRRLLMM

        // x, y = 1, 0 ->saveDatabase
        // x, y = 2, 0 ->saveDatabase
        // x, y = 2, 0 ->saveDatabase

        // RoverMoved (direction: W) -> store events
        // RoverMoved (direction: W) -> store events
        // RoverTurnedRight (direction: E) -> store events
        // x, y = 1, 0 -> snapshot
        // RoverMoved (direction: W) -> store events
        // RoverMoved (direction: W) -> store events

    }

    public void moveBackward() {
        this.state.moveBackward(this);
    }

    public void turnRight() {
        this.state.turnRight(this);
    }

    public void turnLeft() {
        this.state.turnLeft(this);
    }

}
