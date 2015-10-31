import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Text listener.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class ShapeTextDisplay extends JPanel implements ShapeListener{
    private DrawingBoard dboard;

    /**
     * Constructor for objects of class ShapeTextDisplay
     */
    public ShapeTextDisplay(DrawingBoard db){
        dboard = db;
        dboard.addListener(this);
        System.out.println("Welcome.\nSelect a shape to get started."); 
    }

    /**
     * Notifies the output that textual information has changed and needs to be
     * updated.
     */
    public void shapeChanged(){
        // If there are shapes, updates the textual representation of the topmost
        // one in the ArrayList. 
        if(dboard.listShapes().size() > 0){
            if(dboard.getNextShape() == ""){
                if(dboard.referShape() != null){
                    System.out.println(dboard.referShape());
                }
            } else {
                System.out.println(dboard.referShape());
            }
        }
        System.out.println("Total number of shapes: " + dboard.listShapes().size());
    }
}
