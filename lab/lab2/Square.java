public class Square {
    private int x;
    private int y;
    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setWidth(double width) {
        this.sideLength = width;
    }

    public void setHeight(double length) {
        this.sideLength = length;
    }

    private static String shapeString = "[]";

    public Square() {}

    public Square(int nx, int ny) {
        this.x = nx;
        this.y = ny;
    }

    public Square(int x, int y, double length) {
        this.x = x;
        this.y = y;
        this.sideLength = length;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return shapeString;
    }

    public void draw() {
        System.out.println(shapeString);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square squ) {
            return this.x == squ.x && this.y == squ.y && this.sideLength == squ.sideLength;
        }
        return false;
    }
}
