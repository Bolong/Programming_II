package square_balloon;
/**
 * This class computes the area,average,perimeter and diagonal of a square .
 */
public class Balloon {
	private double volume;
	

	/**
	 * 
	 * Constructs a Balloon wiht volume of 0.
	 */
	public Balloon() {
		volume = 0;
	}

	/**
	 * Add air to Balloon.
	 * 
	 * @param amount the air amount added to Balloon
	 */
	public void addAir(double amount) {
		volume = volume + amount;
	}
	
	
	/**
	 * Caculates volume of Balloon.
	 * 
	 * @return volume
	 */
	public double getVolume() {
		return volume;
	}


	/**
	 * Caculates SurfaceArea of Balloon.
	 * 
	 * @return area
	 */
	public double getSurfaceArea() {
		double area = 4*Math.PI*(getRadius()*getRadius());
		return area;
	}
	
	/**
	 * Caculates radius of Balloon.
	 * 
	 * @return radius
	 */
	public double getRadius() {
		double radius = Math.pow(volume*3/4*Math.PI, 1.0/3);
		return radius;
	}

	
}
