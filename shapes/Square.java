import java.awt.*;
import java.util.Random;

public class Square extends Shape {
    protected int getLength() {
        return length;
    }

    private int length;
    public Square(int x, int y, int length) {
        super(x, y);
        this.length = length;
    }

    @Override
    public double getArea() {
        return Math.pow(length, 2);
    }

    @Override
    public void draw(Graphics g) {
        // assumes x and y are the bottom left corner
        g.drawRect(
                this.getX(),
                this.getY(),
                length,
                length
        );
    }

    @Override
    public Rectangle getBoundingRect() {
        // bounding rectangle assumes x and y are at upper left corner
        return new Rectangle(
                this.getX(),
                this.getY(),
                length,
                length
        );
    }

    public static Square getRandomSquare() {
        Random randy = new Random();

        int length = randy.nextInt(10, 30);
        int maxX = Main.WIDTH - length;
        int maxY = MyPanel.FLOOR - length;

        return new Square(
                randy.nextInt(0, maxX),
                randy.nextInt(0, maxY),
                length
        );
    }

}
