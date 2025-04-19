import java.lang.reflect.Method;

public class MyPanel extends AnimatedPanel {
    @Override
    public Shape getRandomShape() {
        if (Math.random() < 0.5) {
            return Square.getRandomSquare();
        }
        return Square.getRandomSquare();
    }

    @Override
    public String[] getShapeClassNames() {
        return new String[]{"Square"};
    }
}
