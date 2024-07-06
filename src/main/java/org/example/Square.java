package org.example;

public class Square extends Shape {
    private final double x;
    private final double y;
    private final double side;
    public Square(double x, double y, double side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }
    @Override
    public boolean isInside(double x, double y) {
            if (x >= this.x && x <= (this.x + side) && y >= (this.y - side) && y <= this.y) {
                return true;
            }
        return false;
    }
}
