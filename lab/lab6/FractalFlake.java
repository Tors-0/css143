import java.awt.*;

public class FractalFlake extends Shape {

    private final int limit;
    private final int branches;

    public FractalFlake(int a, int b, int limit, int branches) {
        super(a, b);
        this.limit = Math.clamp(limit, 1, 50);
        this.branches = Math.clamp(branches, 5, 12);
    }

    @Override
    public void draw(Graphics g) {
        draw(g, getX(), getY(), limit);
    }

    private void draw(Graphics g, int startX, int startY, int limit) {
        if (limit >= 3) {
            for (int i = 0; i < branches; i++) {
                int x2 = startX + (int) (limit * Math.cos((2 * Math.PI / branches) * i));
                int y2 = startY + (int) (limit * Math.sin((2 * Math.PI / branches) * i));
                g.drawLine(startX, startY, x2, y2);
                draw(g, x2, y2, limit/3);
            }
        }
    }
}
