package square_balloon;
/**
   A class to test the DataSet class.
*/
public class BalloonSquareTester
{
   public static void main(String[] args)
   {
      Square square = new Square(5,6);

      System.out.println("Square Area:"+square.calArea());      
      System.out.println("Square Perimeter:"+square.calPerimeter());  
      System.out.println("Square Diagonal:"+square.calDiagonal());        
 
      Balloon balloon = new Balloon();
      balloon.addAir(100);
      System.out.println("Balloon Volume:"+balloon.getVolume()+"cm^3");      
      System.out.println("Balloon SurfaceArea:"+balloon.getSurfaceArea()+"cm^2");  
      System.out.println("Balloon Radius:"+balloon.getRadius()+"cm");  

      balloon.addAir(100);
      System.out.println("Balloon Volume:"+balloon.getVolume()+"cm^3");      
      System.out.println("Balloon SurfaceArea:"+balloon.getSurfaceArea()+"cm^2");  
      System.out.println("Balloon Radius:"+balloon.getRadius()+"cm");        
   }
}
