import java.awt.*;
import javax.swing.*;

/**
 * Provides a template to construct shapes of various sizes.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public interface Shape{
    /**
     * Tests to see if a point is located on the Shape.
     * 
     * @param x the x-coordinate of the point to be tested.
     * @param y the y-coordinate of the point to be tested.
     * @return true if the given x,y coordinates are on the Shape.
     */
    boolean isOn(int x, int y);
    
    /**
     * Tests to see if a Shape is currently 'selected'.
     * 
     * @return true if this Shape is selected.
     */
    boolean isSelected();
    
    /**
     * Sets a Shape's selected status.
     * 
     * @param b the true/false selected status the Shape will be set to.
     */
    void setSelected(boolean b);
    
    /**
     * Returns the specific Color object of the selected Shape.
     * 
     * @return Color of the selected shape.
     */
    Color getColor();
    
    /**
     * Sets the color of the selected Shape.
     * 
     * @param c Color object the Shape will be set to.
     */
    void setColor(Color c);
    
    /**
     * Translates the upper left corner of the bounding box of the Shape. This does
     * not set a new location but rather moves the Shape along the x-y axes.
     * 
     * @param deltaX shifts the Shape x number of pixels right
     * @param deltaY shifts the Shape y number of pixels down 
     */
    void shiftUpperLeftBy(int deltaX, int deltaY);
    
    /**
     * Moves the upper left corner of the bounding box of the Shape. This does not
     * deform the Shape.
     * 
     * @param newX new x-coordinate of the bounding box of the Shape.
     * @param newY new y-coordinate of the bounding box of the Shape.
     */
    void moveUpperLeftTo(int newX, int newY);
    
    /**
     * Provides a String representation of the Shape. Intended for testing purposes.
     * 
     * @return String representation of this Shape.
     */
    String toString();
    void paintComponent(Graphics g);
}
