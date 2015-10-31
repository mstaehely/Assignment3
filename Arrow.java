import java.awt.*;
import javax.swing.*;
/**
 * Constructs triangular shaped objects which point to the right.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class Arrow extends AbstractShape implements Shape{
    private int height; // maximum height of object
    
    /**
     * Constructor of class Arrow
     * 
     * @param tip point at which the rightmost tip of the triangle is located.
     * @param height vertical representation of triangle's base.
     * 
     * @throws IllegalArgumentException if the height is 0 or either tip coordinate is
     * less than zero, or if the height is an odd number.
     */
    public Arrow(Point tip, int height) {
        if(height <= 0 || height%2 == 1 || tip.getX() < 0 || tip.getY() < 0)
        throw new IllegalArgumentException();
        this.height = height;   
        setColor(Color.BLACK);
        setSelected(false);
        setLocation(new Point((int)tip.getX()-height, (int)tip.getY()-(height/2)));
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
        if(x == this.location.getX()){
            return (y <= this.location.getY() + this.height &&
                    y >= this.location.getY());
        } else if(x > this.location.getX() && x <= this.location.getX() + height) {
            return ((y >= (this.location.getY() + (x-this.location.getX())/2))
            &&      (y <= ((this.location.getY() + this.height) - 
                    (x-this.location.getX())/2)));
        } else {
            return false;
        }
    }
    
    /**
     * Provides a String representation of the Shape.
     * 
     * @return String representation of this Shape.
     */
    public String toString(){
        return super.toString() + " Shape: Arrow Height: " + this.height;
    }
    
    /**
     * Paints the shape for a GUI.
     * 
     * @param g the Graphics object used to paint the shape.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Polygon shape = new Polygon();
        shape.addPoint((int)this.location.getX(), (int)this.location.getY());
        shape.addPoint((int)this.location.getX(), (int)this.location.getY() + this.height);
        shape.addPoint((int)this.location.getX() + this.height, 
                       (int)this.location.getY() + this.height/2);
        g.setColor(getColor());
        g.fillPolygon(shape);
        if(isSelected()){
            g.setColor(Color.BLACK);
            shape = new Polygon();
            shape.addPoint((int)this.location.getX(), (int)this.location.getY());
            shape.addPoint((int)this.location.getX(), (int)this.location.getY() + this.height);
            shape.addPoint((int)this.location.getX() + this.height, 
                           (int)this.location.getY() + this.height/2);
            g.drawPolygon(shape);
        }
    }
}