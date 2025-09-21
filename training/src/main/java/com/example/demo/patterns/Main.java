package com.example.demo.patterns;

import org.springframework.boot.jackson.JsonObjectSerializer;

import com.example.demo.patterns.command.CommandAdapter;
import com.example.demo.patterns.command.JSONCommandAdapter;
import com.example.demo.patterns.command.StringCommandAdapter;

public class Main {
    public static void main(String[] args) {
        String local = args[0];
        CommandAdapter commandAdapter;
        if (local.charAt(0) == '{') {
            commandAdapter = new JSONCommandAdapter();
        } else {
            commandAdapter = new StringCommandAdapter();
        }
    }
}
