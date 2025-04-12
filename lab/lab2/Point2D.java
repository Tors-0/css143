/*

    What effect does “private” have for methods trying to use x or y inside this class file?
        private makes it so that only internal code from this class can modify
        these variables.
    What about methods trying to use x and y outside this class?
        they will show a compiler error, stating that these fields are private
        in their scope
    Can you use x and y without an associated object (or instance)?
        no, they are instance variables so they have to be accessed by an
        instance

 */
public class Point2D {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int nX) {
        this.x = nX;
    }
    public void setY(int nY) {
        this.y = nY;
    }
    public void resetToOrigin() {
        this.x = 0;
        this.y = 0;
    }
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point2D other) {
            return (this.x == other.x) && (this.y == other.y);
        }
        return false;
    }

    public static void main(String[] args) {
        Point2D a = new Point2D();
        a.setX(5);
        a.setY(2);
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        a.translate(-1,-1);
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        a.resetToOrigin();
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        Point2D b = new Point2D();
        Point2D c = new Point2D();
        System.out.println(b.toString());
        System.out.println(c);
        System.out.println("Are b and c equal:" + b.equals(c));
    }
}
