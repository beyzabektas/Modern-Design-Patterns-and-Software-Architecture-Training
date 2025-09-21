package com.example.demo.patterns.command;

import java.util.List;

public interface CommandAdapter {

    public List<Command> toCommands(String string);
}
