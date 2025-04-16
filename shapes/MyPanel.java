import java.lang.reflect.Method;

public class MyPanel extends AnimatedPanel {
    @Override
    public Shape getRandomShape() {
        Class classname = null;
        try {
            classname = Class.forName(
                    getShapeClassNames()[(int) (getShapeClassNames().length * Math.random())]
            );
            Method getrandommethod = classname.getDeclaredMethod("getRandom" + classname, (Class<?>) null);

        } catch (ClassNotFoundException | NoSuchMethodException ex) {
            System.out.println("Class not found");
        }
    }

    @Override
    public String[] getShapeClassNames() {
        return new String[]{"Square"};
    }
}
