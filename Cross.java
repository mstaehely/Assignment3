import java.awt.*;
import javax.swing.*;
/**
 * Constructs "cross" shaped objects.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class Cross extends AbstractShape implements Shape{
    private int height; //maximum height of cross
    
    /**
     * Constructor of class Cross.
     * 
     * @param corner the upper left corner of the bounding box.
     * @param height the maximum height of the object.
     * 
     * @throws IllegalArgumentException if either coordinate of the corner is less 
     * than 0 or the height is zero. Also thrown if the height is not divisible by 5.
     */
    public Cross(Point corner, int height){
        if(height <= 0 || height %5 > 0 || corner.getX() < 0 || corner.getY() < 0)
        throw new IllegalArgumentException();
        this.height = height;
        setColor(Color.BLACK);
        setSelected(false);
        setLocation(new Point((int)corner.getX(), (int)corner.getY()));
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
        return((x > location.getX() + this.height*2/5 &&
                x < location.getX() + this.height*3/5 &&
                y >= location.getY() && y <= location.getY() + this.height) ||
               (x >= location.getX() && x <= location.getX() + this.height &&
                y > location.getY() + this.height*2/5 &&
                y < location.getY() + this.height*3/5));
    }
    
    
    /**
     * String representation of a cross shape.
     * 
     * @returns string describing the cross.
     */
    public String toString(){
        return super.toString() + " Shape: Cross Height: " + this.height;
    }
    
    /**
     * Paints the shape for a GUI.
     * 
     * @param g the Graphics object used to paint the shape.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.getColor());
        g.fillRect((int)this.location.getX() + this.height*2/5, (int)this.location.getY(),
                   this.height/5, this.height);
        g.fillRect((int)this.location.getX(), (int)this.location.getY() + this.height*2/5,
                   this.height, this.height/5);
        if(isSelected()){
            g.setColor(Color.BLACK);
            Polygon shape = new Polygon();
            shape.addPoint((int)this.location.getX() + this.height*2/5-1, 
                           (int)this.location.getY());
            shape.addPoint((int)this.location.getX() + this.height*3/5,
                           (int)this.location.getY());
            shape.addPoint((int)this.location.getX() + this.height*3/5,
                           (int)this.location.getY() + this.height*2/5-1);
            shape.addPoint((int)this.location.getX() + this.height,
                           (int)this.location.getY() + this.height*2/5-1);
            shape.addPoint((int)this.location.getX() + this.height,
                           (int)this.location.getY() + this.height*3/5);
            shape.addPoint((int)this.location.getX() + this.height*3/5,
                           (int)this.location.getY() + this.height*3/5);
            shape.addPoint((int)this.location.getX() + this.height*3/5,
                           (int)this.location.getY() + this.height);
            shape.addPoint((int)this.location.getX() + this.height*2/5-1, 
                           (int)this.location.getY() + this.height);
            shape.addPoint((int)this.location.getX() + this.height*2/5-1,
                           (int)this.location.getY() + this.height*3/5);
            shape.addPoint((int)this.location.getX(), 
                           (int)this.location.getY() + this.height*3/5);
            shape.addPoint((int)this.location.getX(),
                           (int)this.location.getY() + this.height*2/5-1);
            shape.addPoint((int)this.location.getX() + this.height*2/5-1,
                           (int)this.location.getY() + this.height*2/5-1);
            g.drawPolygon(shape);
        }
    }
}