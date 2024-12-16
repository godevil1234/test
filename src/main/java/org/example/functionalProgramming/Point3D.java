package org.example.functionalProgramming;

public class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public double getDistance(Point2D other) {
        if (other instanceof Point3D other3d) {
            return Math.sqrt(
                    Math.pow(this.getX() - other.getX(), 2) +
                            Math.pow(this.getY() - other.getY(), 2) +
                            Math.pow(this.z - other3d.z, 2)
            );
        }

        return super.getDistance(other);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static void main(String[] args) {
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(5, 5);

        System.out.println(p1.getDistance(p2));

        Point3D p3 = new Point3D(5, 5, 5);

        System.out.println(p1.getDistance(p3));
    }
}
