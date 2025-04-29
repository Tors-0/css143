import java.awt.*;
import java.util.Random;

public class Oval extends Circle {
    private int width;

    public Oval(int x, int y, int length, int width) {
        super(x, y, length);
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(
                this.getX(),
                this.getY(),
                this.width,
                this.getLength()
        );
    }

    @Override
    public Rectangle getBoundingRect() {
        // bounding rectangle assumes x and y are at upper left corner
        return new Rectangle(
                this.getX(),
                this.getY(),
                this.width,
                this.getLength()
        );
    }

    @Override
    public double getArea() {
        return Math.PI * this.getLength() * this.width;
    }

    public static Oval getRandomOval() {
        Random randy = new Random();

        int length = randy.nextInt(10, 30);
        int width = randy.nextInt(10, 30);
        int maxX = Main.WIDTH - length;
        int maxY = MyPanel.FLOOR - length;

        return new Oval(
                randy.nextInt(0, maxX),
                randy.nextInt(0, maxY),
                length,
                width
        );
    }
}
