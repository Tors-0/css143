import java.awt.*;
import java.util.Random;

public class Cube extends Shape {
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int length;

    public Cube(int x, int y, int length) {
        super(x, y);
        this.length = length;
        this.offsetDist = getOffset3d();
    }
    private int offsetDist;

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int x = this.getX();
        int y = this.getY();
        g2d.setPaint( new GradientPaint( x, y, Color.RED, x + length/3, y + length/3, Color.BLACK, true) );

        int[] x0 = {this.getX(), this.getX() + this.getLength()};
        int[] y0 = {this.getY(), this.getY() + this.getLength()};
        g.drawRect(
                this.getX(),
                this.getY(),
                this.getLength(),
                this.getLength()
        );
        g.drawRect(
                this.getX() + offsetDist,
                this.getY() + offsetDist,
                this.getLength(),
                this.getLength()
        );
        for (int iX : x0) {
            for (int iY : y0) {
                g.drawLine(iX, iY, iX + offsetDist, iY + offsetDist);
            }
        }
    }

    // computes the offset needed to draw a second square
    // and make it look like an isometric cube
    private int getOffset3d() {
        return (int) Math.round(
                Math.sqrt(this.getLength() * this.getLength() * 3) / 3
        );
    }

    @Override
    public double getArea() {
        return length * length * 6;
    }
}
