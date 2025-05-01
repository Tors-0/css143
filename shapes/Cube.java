import java.awt.*;
import java.util.Random;

public class Cube extends Square {

    public Cube(int x, int y, int length) {
        super(x, y, length);
        this.offsetDist = getOffset3d();
    }
    private int offsetDist;

    @Override
    public void draw(Graphics g) {
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

    // creates a second bounding rectangle, offset by the offset amount from
    // getOffset2d, then conjoins them to get an accurate bounding box
    @Override
    public Rectangle getBoundingRect() {
        Rectangle offsetRect = super.getBoundingRect();
        offsetRect.translate(offsetDist, offsetDist);
        return super.getBoundingRect().union(offsetRect);
    }

    public static Cube getRandomCube() {
        Random randy = new Random();

        int length = randy.nextInt(5, 60);
        int maxX = Main.WIDTH - length;
        int maxY = MyPanel.FLOOR - length;

        return new Cube(
                randy.nextInt(0, maxX),
                randy.nextInt(0, maxY),
                length
        );
    }

    @Override
    public double getArea() {
        return super.getArea() * 6;
    }
}
