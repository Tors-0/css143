import java.awt.*;

class Shape {
     /**
      * constraint 1: must be non-negative <br>
      * constraint 2: must be smaller than display width
      */
    private int x;
    /**
     * constraint 1: must be non-negative <br>
     * constraint 2: must be smaller than display height
     */
    private int y;
    private Color color;

    public Shape() {
        x = 0;
        y = 0;
        this.color = Color.BLACK;
    }
    public Shape(int x, int y, Color color) {
        // limit x and y to greater than 0
        this.x = Math.max(x, 0);
        this.y = Math.max(y, 0);

        this.color = new Color(color.getRGB());
    }
    public Shape(Shape other) {
        this.x = other.x;
        this.y = other.y;
        this.color = new Color(other.color.getRGB());
    }

    @Override
    public String toString() {
        return "Shape(" + this.x + ", " + this.y + ") " + this.color.toString();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = Math.max(x, 0);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = Math.max(y, 0);
    }

    public double getArea() {
        return -1;
    }

    public void draw(Graphics g) {

    }
}
