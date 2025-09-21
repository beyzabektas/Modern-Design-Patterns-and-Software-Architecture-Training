package com.example.demo.patterns.command;

import java.util.List;

public class StringCommandAdapter implements CommandAdapter {

    @Override
    public List<Command> toCommands(String string) {
        return null;
    }

}
