package vehicles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * This component displays a car that can be moved.
 */
public class Car extends JComponent {

	private BasicStroke bs;
	private int xpos;
	private int ypos;
	private boolean flag;
	/**
	 * Constructs a car with given top-left corner.
	 * 
	 * @param x
	 *            the x-coordinate of the top-left corner
	 * @param y
	 *            the y coordinate of the top-left corner
	 */
	public Car(int x, int y) {
		xpos = x;
		ypos = y;
		flag = true;
	}

	/**
     * Draws the car.
     * @param g the graphics context
     */	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.white); // set background
		bs = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND); // set
																					// line
																					// bold
		
		g2.setStroke(bs);
		// The rectangle that the paint method draws
		Rectangle body = new Rectangle(xpos, ypos + 10, 60, 10);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(xpos + 10, ypos + 20,
				10, 10);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(xpos + 40, ypos + 20,
				10, 10);
		Point2D.Double r1 = new Point2D.Double(xpos + 10, ypos + 10);
		Point2D.Double r2 = new Point2D.Double(xpos + 20, ypos);
		Point2D.Double r3 = new Point2D.Double(xpos + 40, ypos);
		Point2D.Double r4 = new Point2D.Double(xpos + 50, ypos + 10);
		Line2D.Double frontW = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearW = new Line2D.Double(r3, r4);

		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontW);
		g2.draw(rearW);
		g2.draw(roofTop);
	}

	/**
	 * Moves the components by a given amount.
	 * 
	 * @param dx
	 *            the amount to move in the x-direction
	 */
	public void moveBy(int dx) {
		xpos = xpos + dx;
		repaint();
	}

	
	/**
	 * Get the x-coordinate of the top-left corner.
	 * 
	 * @return xpos
	 *            the x-coordinate of the top-left corner
	 */	
	public int getXpos() {
		return xpos;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}	
	
	
}