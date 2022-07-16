package com.designpattern.uditagarwal.commanddesignpattern.other;

import java.util.List;

public class Command {

    String name;
    List<String> params;

    public Command(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }
}
