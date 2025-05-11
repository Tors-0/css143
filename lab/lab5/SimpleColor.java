
public class SimpleColor {
	private int r;
	private int g;
	private int b;


	public int getR() {
		return r;
	}

	public void setR(int r) {
		// TODO: check if range is between [0, 255], if not throw ColorException
		this.r = r;
		checkColorVal(r);
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		// TODO: check if range is between [0, 255], if not throw ColorException
		this.g = g;
		checkColorVal(g);
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		// TODO: check if range is between [0, 255], if not throw ColorException
		this.b = b;
		checkColorVal(b);
	}

	public void setColor(int a, int b, int c) {
		setR(a);
		setG(b);
		setB(c);
	}
	public SimpleColor() {}

	public SimpleColor(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}

	public SimpleColor(SimpleColor b) {
		this(b.r,b.g,b.b);
	}

	public String toString()
	{
		// TODO: return the string representation of r,g,b values.
		//(Ex. " R: 200, G: 190, B:240 ")
		return String.format("(R: %d, G: %d, B: %d)", r, g, b);
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof SimpleColor)){
			return false;
		}
		SimpleColor that = (SimpleColor) o;
		return this.r == that.r && this.g == that.g && this.b == that.b;
	}

	public static void checkColorVal(int value) {
		if (value < 0 || value > 255) {
			throw new ColorException();
		}
	}

}
