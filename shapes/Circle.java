import java.awt.*;
import java.util.Random;

public class Circle extends Square {
    // length is used as the diameter here
    public Circle(int x, int y, int length) {
        super(x, y, length);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(
                this.getX(),
                this.getY(),
                this.getLength(),
                this.getLength()
        );
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow((double) this.getLength() / 2, 2);
    }

    public static Circle getRandomCircle() {
        Random randy = new Random();

        int length = randy.nextInt(10, 30);
        int maxX = Main.WIDTH - length;
        int maxY = MyPanel.FLOOR - length;

        return new Circle(
                randy.nextInt(0, maxX),
                randy.nextInt(0, maxY),
                length
        );
    }
}
