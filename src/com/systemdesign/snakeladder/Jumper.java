package com.systemdesign.snakeladder;

import java.util.Objects;

public class Jumper {

    int startPoint;
    int endPoint;

    public Jumper(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jumper jumper = (Jumper) o;
        return startPoint == jumper.startPoint && endPoint == jumper.endPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }
}
