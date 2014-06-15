package vehicles;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class moves the vehicles.
 */
public class AnimateComponents  extends   JFrame{
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 600;
	JPanel   contentPane;
	boolean way = true;
	int dx = 0;	
	public   AnimateComponents()
	{
	contentPane=(JPanel)this.getContentPane();

	setSize(FRAME_WIDTH,FRAME_HEIGHT);
	setDefaultCloseOperation(2);

	GridLayout   gridLayout=   new   GridLayout();
	gridLayout.setColumns(1);
	gridLayout.setRows(3);
	contentPane.setLayout(gridLayout);
	final Car car = new Car(20,30);
	final Truck truck = new Truck(20,80);
	final Sailboat sailboat = new Sailboat(20,130);
	contentPane.add(car,null);
	contentPane.add(truck,null);
	contentPane.add(sailboat,null);	
	setVisible(true);
	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(way&&dx<FRAME_WIDTH){
			dx++;	
			car.moveBy(1);
			truck.moveBy(1);
			sailboat.moveBy(1);
			}else if(way){
			 way = false;
			 truck.setFlag(false);
			 sailboat.setFlag(false);
			 dx = 0;
			}
			if(!way&&dx<FRAME_WIDTH){
				dx++;	
				car.moveBy(-1);
				truck.moveBy(-1);
				sailboat.moveBy(-1);
				}else if(!way){
				 way = true;
				 truck.setFlag(true);
				 sailboat.setFlag(true);				 
				 dx=0;
				}			
		}
	}

	ActionListener listener = new TimerListener();

	final int DELAY = 5; // Milliseconds between timer ticks

	Timer t = new Timer(DELAY, listener);
	t.start();	
	} 
	public static void main(String[] args) {

		new AnimateComponents();


	}
}