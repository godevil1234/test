package org.example;

public class Circle extends Shape {

    private final double radius;
    private final double x;
    private final double y;

    public Circle(double x, double y, double Radius) {
        this.x = x;
        this.y = y;
        this.radius = Radius;
    }
    @Override
    public boolean isInside(double x, double y) {
        if(Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) <= radius) {
            return true;
        } else {
            return false;
        }
    }
}
