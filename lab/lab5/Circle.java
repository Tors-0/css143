import java.awt.*;

public class Circle extends Shape {
    private int length;

    public Circle(int a, int b, int length) {
        super(a, b);
        this.length = length;
    }

    @Override
    public double getArea() {
        return Math.PI * length * length;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int x = this.getX();
        int y = this.getY();
        g2d.setPaint( new GradientPaint( x, y, Color.GREEN, x + length/6, y + length/6, Color.BLACK, true) );

        g.drawOval(this.getX(), this.getY(), length, length);
    }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }
}
