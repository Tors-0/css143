import java.awt.*;
import java.util.Random;

public class Cube extends Square {

    public Cube(int x, int y, int length) {
        super(x, y, length);
    }

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
        int offset2d = getOffset2d();
        g.drawRect(
                this.getX() + offset2d,
                this.getY() + offset2d,
                this.getLength(),
                this.getLength()
        );
        for (int iX : x0) {
            for (int iY : y0) {
                g.drawLine(iX, iY, iX + offset2d, iY + offset2d);
            }
        }
    }

    // computes the offset needed to draw a second square
    // and make it look like an isometric cube
    private int getOffset2d() {
        return (int) Math.round(
                Math.sqrt((double) (this.getLength() * this.getLength()) / 2)
        );
    }

    // creates a second bounding rectangle, offset by the offset amount from
    // getOffset2d, then conjoins them to get an accurate bounding box
    @Override
    public Rectangle getBoundingRect() {
        int offset = this.getOffset2d();
        Rectangle offsetRect = super.getBoundingRect();
        offsetRect.translate(offset, offset);
        return super.getBoundingRect().union(offsetRect);
    }

    public static Cube getRandomCube() {
        Random randy = new Random();

        int length = randy.nextInt(10, 30);
        int maxX = Main.WIDTH - length;
        int maxY = MyPanel.FLOOR - length;

        return new Cube(
                randy.nextInt(0, maxX),
                randy.nextInt(0, maxY),
                length
        );
    }
}
