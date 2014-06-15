import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * A class to draw hanio tower.
 */
public class Hanio extends JFrame implements ActionListener, Runnable {

	private int diskNum ;  //number of disk to draw 
	private int diskNo ;   //current disk number to draw
	private int x ;        
	private int y ;
	private int width;
	private int dx ;
	private int height ;
	private JButton begin;
	JPanel pane;
	private Thread animate;

	public void init() {
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		begin = new JButton("draw");
		begin.addActionListener(this);
		pane = new JPanel();
		pane.setLayout(new FlowLayout());
		pane.add(begin);
		content.add(pane, BorderLayout.SOUTH);
	}

	/**
	 * init value;
	 */	
	public void initValue() {
		diskNum = 4;
		diskNo = 0;
		x = 200;
		y = 200;
		dx = 50;
		height = 30;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(getBackground());
		if(diskNo == diskNum){
			g2D.clearRect(0, 0, this.getWidth(), this.getHeight() );				
			}			
		if(diskNo>0){
		drawPane(g, diskNo);
		}
		pane.repaint();
	}

	 
	/**
	 * draw pane with y=200 + i * height
	 */
	public void drawPane(Graphics g, int i) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.gray);
		x = x + dx / 2;
		y = 200 + i * height;
		width = i * dx;
		g2D.draw(new Rectangle(x, y, width, height));
	}

	/**
	 *begin the thread when button draw is pressed
	 */	
	public void actionPerformed(ActionEvent e) {
		initValue();
		if (animate == null || !animate.isAlive())
		{
			animate = new Thread(this);
			animate.start();
		}

	}

	public void run() {
		hanio(diskNum);
	}

	/**
	 * recursion to set diskNo to n
 	 @param n 
	 */
	public void hanio(int n) {
		if (n > 0) {
			pause();
			diskNo = n;
			repaint();
			hanio(n - 1);
		}
	}

	/**
	 *draw a pane every 500 ms
	 */
	public void pause() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
	}
	
    public static void main(String[] args) {  
        Hanio myJApplet = new Hanio();
        myJApplet.setSize(500, 500);
        myJApplet.init();  
        myJApplet.setVisible(true);
    }  	
}