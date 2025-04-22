import java.awt.*;
import java.util.Random;

public class Square3d extends Square {
    public Square3d(int x, int y, int length) {
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

    private int getOffset2d() {
        return (int) Math.round(
                Math.sqrt((double) (this.getLength() * this.getLength()) / 2)
        );
    }

    @Override
    public Rectangle getBoundingRect() {
        int offset = this.getOffset2d();
        Rectangle offsetRect = super.getBoundingRect();
        offsetRect.translate(offset, offset);
        return super.getBoundingRect().union(offsetRect);
    }

    public static Square3d getRandomSquare3d() {
        Random randy = new Random();

        int length = randy.nextInt(10, 30);
        int maxX = Main.WIDTH - length;
        int maxY = MyPanel.FLOOR - length;

        return new Square3d(
                randy.nextInt(0, maxX),
                randy.nextInt(0, maxY),
                length
        );
    }
}
