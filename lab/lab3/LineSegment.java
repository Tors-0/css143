import javax.sound.sampled.Line;

public class LineSegment {
    private Point2D start;
    private Point2D end;

    public Point2D getStart() {
        return new Point2D(start);
    }

    public void setStartPoint(Point2D start) {
        this.start = new Point2D(start);
    }

    public Point2D getEnd() {
        return new Point2D(end);
    }

    public void setEndPoint(Point2D end) {
        this.end = new Point2D(end);
    }

    public LineSegment(Point2D start, Point2D end) {
        this.start = new Point2D(start);
        this.end = new Point2D(end);
        validate();
    }

    public LineSegment(int x1, int y1, int x2, int y2) {
        this.start = new Point2D(x1, y1);
        this.end = new Point2D(x2, y2);
        validate();
    }

    public LineSegment() {
        this(0, 0, 0, 0);
    }

    public LineSegment(LineSegment other) {
        this(other.start, other.end);
    }

    private void validate() {
        if (start.getX() < 0 || start.getY() < 0) {
            throw new IllegalArgumentException("Coordinates cannot be negative");
        }
        if (end.getX() < 0 || end.getY() < 0) {
            throw new IllegalArgumentException("Coordinates cannot be negative");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof LineSegment other) {
            return this.start.equals(other.start) && this.end.equals(other.end);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Line start: (%d, %d) end: (%d, %d)",
                start.getX(), start.getY(), end.getX(), end.getY());
    }

    public double distance() {
        return  Math.sqrt(Math.pow(this.end.getX() - this.start.getX(), 2) +
                Math.pow(this.end.getY() - this.start.getY(), 2));
    }

    // questions
    // 1. a privacy leak is when you allow external fields to access the memory of private fields
    // 2. no, my getters and setters do not have privacy leaks as they always copy their passed values
    // 3. in constructors that take an object is one example
}
