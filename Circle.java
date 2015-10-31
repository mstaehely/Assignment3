import java.awt.*;
import javax.swing.*;

/**
 * Constructs circular Shape objects
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class Circle extends AbstractShape implements Shape{
    int radius; // radius of Circle. Useful for isOn method of this class.   
    /**
     * Constructor of class Circle.
     * 
     * @param center the point at which the center of the circle is located.
     * @param radius the radius of the circle.
     * 
     * @throws IllegalArgumentExcpetion if the radius is 0 or less, or either 
     * coordinate of the center is less than 0.
     */
    public Circle(Point center, int radius){
       if(center.getX() < 0 || center.getY() < 0 || radius <= 0)
       throw new IllegalArgumentException();
       this.radius = radius;
       setColor(Color.BLACK);
       setSelected(false);
       setLocation(new Point((int)center.getX()-radius, (int)center.getY()-radius));
    }
    
    /**
     * Tests to see if a point is located on the Shape.
     * 
     * @param x the x-coordinate of the point to be tested.
     * @param y the y-coordinate of the point to be tested.
     * 
     * @return true if the given x,y coordinates are on the Shape.
     */
    public boolean isOn(int x, int y){
        Point center = new Point((int)this.location.getX() + radius, 
                                 (int)this.location.getY() + radius);
        Point test = new Point(x, y); // useful for distance method of Point class.
        return(test.distance(center) <= radius);
    }
    
    /**
     * Provides a String representation of the Shape.
     * 
     * @return String representation of this Shape.
     */
    public String toString(){
        return super.toString() + " Shape: Circle Radius: " + this.radius;
    }
    
    /**
     * Paints the shape for a GUI.
     * 
     * @param g the Graphics object used to paint the shape.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.getColor());
        g.fillOval((int)this.location.getX(), (int)this.location.getY(), 
                   this.radius*2, this.radius*2);
        if(isSelected()){
            g.setColor(Color.BLACK);
            g.drawOval((int)this.location.getX(), (int)this.location.getY(), 
                       this.radius*2, this.radius*2);
        }
    }
}