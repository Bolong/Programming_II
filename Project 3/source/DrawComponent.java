import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * This component displays a circle that can be moved.
 */
public class DrawComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BasicStroke bs;
	private Ellipse2D circle;
	
	public DrawComponent() {
		// The rectangle that the paint method draws
		bs = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND); // set line bold
		circle = new Ellipse2D.Double(); // draw circle
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		setBackground(Color.white); // set background	
		g2.setStroke(bs);
		g2.draw(circle);
	}
	

	
	 /**
	 Move the circle to point with coordinate x,y .
	 @param x the x coordinate of point to move to
	 @param y the y coordinate of point to move to
	 @param r the radius of circle	 
	 */
	public void moveTo(float x,float y,float r) {
		x= x-r;
		y= y-r;
		circle.setFrame(x, y, r*2, r*2);
		
		repaint();
	}	
	
}