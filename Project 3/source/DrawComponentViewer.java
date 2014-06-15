import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
   This program displays a circle.
*/
public class DrawComponentViewer
{  
   private static final int FRAME_WIDTH = 600; 
   private static final int FRAME_HEIGHT = 600;
   private static int inx;
   private static float x,y,k,gx,gy,r;
   private static boolean flag = true;

   public static void main(String[] args)
   {  
	  init(); 
	  final DrawComponent dcomponent = new DrawComponent();
      ActionListener aListener = new ActionListener(){   	  
    	  public void actionPerformed(ActionEvent event){
     		 if(flag){    		  
    		 move();
     		 dcomponent.moveTo(x,y,r);
     		 }else {
         	 dcomponent.moveTo(gx,gy,r);
     		 }
    	  }
    	};
    	//
    	final Timer displayTimer = new Timer(10, aListener);
	  
      class MousePressListener implements MouseListener
      {  
         public void mousePressed(MouseEvent event)
         {  
         }

         // Do-nothing methods
         public void mouseReleased(MouseEvent event) {
        	 flag = true;
             gx = event.getX()-8; //adjust x position
             gy = event.getY()-28;//adjust y position
             k=(y-gy)/(x-gx);           
             System.out.println("gx="+gx+",gy="+gy+",k="+k);
         	displayTimer.start();             
         }
         public void mouseClicked(MouseEvent event) {
         }
         public void mouseEntered(MouseEvent event) {
       	 
         }
         public void mouseExited(MouseEvent event) {
       	 
         }
      } 
      MouseListener listener = new MousePressListener();


      JFrame frame = new JFrame();
      frame.setLocation(0, 0);
      frame.add(dcomponent);
      frame.addMouseListener(listener);      
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
	  JFrame input = new JFrame();
	  input.setSize(50, 60);
	  input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		//input field for class
		JTextField xField = new JTextField(5);
		JTextField yField = new JTextField(5);
		JTextField zField = new JTextField(5);		
		xField.setText("300");	
		yField.setText("300");
		zField.setText("30");		
		JPanel inputPanel = new JPanel();	
		inputPanel.add(new JLabel("x:"));
		inputPanel.add(xField);
		inputPanel.add(new JLabel("y:"));
		inputPanel.add(yField);
		inputPanel.add(new JLabel("r:"));
		inputPanel.add(zField);		
		int response = 0;
		UIManager.put("OptionPane.okButtonText", "draw");	//set the OK button to draw
		//always display Pane
			response = JOptionPane.showConfirmDialog(input, inputPanel,
					"Please Set the circle", JOptionPane.CLOSED_OPTION);
		System.out.println(response);
		if(response==0){
			x = Integer.parseInt(xField.getText());
			y = Integer.parseInt(yField.getText());
			r = Integer.parseInt(zField.getText());			
    		 dcomponent.moveTo(x,y,r);
		}
     
   }
	public static void init()
	{	
		x=300; //begin x coordinate of the smile
		y=300; //begin y coordinate of the smile
		inx=1;//set the direction of movement and initial velocity
		r=30;
		gx=300;
		gy=300;

	}
	
	public static void move()
	{		
		
        if(gx<x)      //if mouse click on the left, the direction is negative
        	inx = -1;
        else		  //if mouse click on the right, the direction is positive
        	inx = 1;
		
		x=x+inx;
		y=y+inx*k;
		
		if(inx==1&&gx<x)   //after movement, set flag=false to make it stop
			{flag = false;
		    System.out.println(x+","+y);}
		if(inx==-1&&gx>x)
			{flag = false;		
			System.out.println(x+","+y);}		
		
	}
	

   
} 
