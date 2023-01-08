package com.shubhamrawat.parkingSystem.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Command {
    private String commandName;
    private List<String> params = new ArrayList<>();
}
