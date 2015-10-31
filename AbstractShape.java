import java.awt.*;
import javax.swing.*;

/**
 * Abstract class AbstractShape - provides common methods for Shape objects to 
 * manipulate their Color, location, selection, and testing of their location 
 * against arbitrary, user-defined points.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public abstract class AbstractShape extends JPanel implements Shape{
    protected Point location; //upper-left corner of bounding box
    private Color color; //color of object
    private boolean selected; // whether or not Shape has been selected by user

    /**
     * Tests to see if a point is located on the Shape.
     * 
     * @param x the x-coordinate of the point to be tested.
     * @param y the y-coordinate of the point to be tested.
     * 
     * @return true if the given x,y coordinates are on the Shape.
     */
    public abstract boolean isOn(int x, int y);
    
    /**
     * Sets the location of the Shape. This is indicated by the upper-left point
     * of the Shape's bounding box.
     * 
     * @param p the upper-left corner of the bounding box.
     */
    public void setLocation(Point p)    {
        this.location = p;
    }
    
    /**
     * Tests to see if a Shape is currently 'selected'.
     * 
     * @returns true if this Shape is selected.
     */
    public boolean isSelected(){
        return selected;
    }
    
    /**
     * Sets a Shape's selected status.
     * 
     * @param b the true/false selected status the Shape will be set to.
     */
    public void setSelected(boolean b)    {
        this.selected = b;
    }
    
    /**
     * Returns the specific Color object of the selected Shape.
     * 
     * @returns Color of the selected shape.
     */
    public Color getColor(){
        return this.color;
    }
    
    /**
     * Sets the color of the selected Shape.
     * 
     * @param c Color object the Shape will be set to.
     */
    public void setColor(Color c){
        this.color = c;
    }
    
    /**
     * Translates the upper left corner of the bounding box of the Shape. This does
     * not set a new location but rather moves the Shape along the x-y axes.
     * 
     * @param deltaX shifts the Shape x number of pixels right
     * @param deltaY shifts the Shape y number of pixels down 
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY){
        location.setLocation(location.getX() + deltaX, location.getY() + deltaY);
    }
        
    /**
     * Moves the upper left corner of the bounding box of the Shape. This does not
     * deform the Shape.
     * 
     * @param newX new x-coordinate of the bounding box of the Shape.
     * @param newY new y-coordinate of the bounding box of the Shape.
     */
    public void moveUpperLeftTo(int newX, int newY){
        location.setLocation(newX, newY);
    }
    
    /**
     * Provides a String representation of the Shape. Intended for testing purposes.
     * 
     * @return String representation of this Shape.
     */
    public String toString(){
        return "Top left corner: (" + location.getX() +", " + location.getY() +")";
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}