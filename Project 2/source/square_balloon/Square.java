package square_balloon;
/**
 * This class computes the area,average,perimeter and diagonal of a square .
 */
public class Square {
	private double width;
	private double height;	
	

	/**
	 * @param w inputed width of square
	 * @param h inputed height of square
	 * 
	 * Constructs a Square with inputed width and height.
	 */
	public Square(double w,double h) {
		width = w;
		height = h;		
	}

	/**
	 * Caculates area of square.
	 * 
	 * @return area
	 */
	public double calArea() {
		double area = width * height;;
		return area;
	}


	/**
	 * Caculates perimeter of square.
	 * 
	 * @return perimeter
	 */
	public double calPerimeter() {
		double perimeter = (width + height)*2;
		return perimeter;
	}
	
	/**
	 * Caculates diagonal of square.
	 * 
	 * @return diagonal
	 */
	public double calDiagonal() {
		double diagonal = Math.sqrt(width * width + height * height);
		return diagonal;
	}

	
}
