class Circle {
    private int x;
    private int y;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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

    private static String shapeString = "O";

    public Circle() {}

    public Circle(int nx, int ny) {
        this.x = nx;
        this.y = ny;
    }

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return shapeString;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle cir) {
            return this.x == cir.x && this.y == cir.y && this.radius == cir.radius;
        }
        return false;
    }
}
