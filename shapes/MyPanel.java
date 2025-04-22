import java.lang.reflect.Method;

public class MyPanel extends AnimatedPanel {
    @Override
    public Shape getRandomShape() {
        double rand = Math.random();
        if (rand < 0.25) {
            return Square.getRandomSquare();
        } else if (rand < 0.5) {
            return Oval.getRandomOval();
        } else if (rand < 0.75) {
            return Square3d.getRandomSquare3d();
        } else {
            return Circle.getRandomCircle();
        }
    }

    @Override
    public String[] getShapeClassNames() {
        return new String[]{"Square", "Circle", "Oval", "Square3d"};
    }
}
