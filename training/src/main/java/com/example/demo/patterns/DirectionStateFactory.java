package com.example.demo.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DirectionStateFactory {

    private Map<Direction,Supplier<DirectionState>> stateMap;

    public DirectionStateFactory() {
        this.stateMap = new HashMap<>();
        stateMap.put(Direction.WEST, WestDirectionState::new);
        stateMap.put(Direction.EAST, EastDirectionState::new);
        stateMap.put(Direction.SOUTH, SouthDirectionState::new);
        stateMap.put(Direction.NORTH, NorthDirectionState::new);
    }

    public DirectionState create(Direction direction) {
        return stateMap.get(direction).get();
    }
}
