import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
/**
 * Handles user actions in the GUI.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */

public class ShapeMouseListener implements MouseListener, MouseMotionListener{
    private DrawingBoard dboard;
    private Random rng;
    private int oldX, oldY, newX, newY;
    private boolean dragging;
    /**
     * Constructor for objects of class ShapeMouseListener
     * 
     * @param dboard the model object containing the state of the system.
     */
    public ShapeMouseListener(DrawingBoard dboard){
        super();
        this.dboard = dboard;
        dragging = false;
        oldX = oldY = newX = newY = 0;
        rng = new Random();
    }

    /**
     * Processes mouse clicks by determining if a shape is to be selected or added. 
     * If a shape is to be added, calls different method.
     * 
     * @param e mouse click event.
     */
    public void mouseClicked(MouseEvent e){
        Shape oldshape = dboard.referShape();
        dboard.selectShape(e.getX(), e.getY());
        // Makes sure to update if new object is selected.
        if(oldshape != dboard.referShape()){
            dboard.notifyAllListeners();
        }
    }
    
    /**
     * Controls what happens when a mouse is pressed contextually. If a Shape has been
     * selected, will produce a new Shape of that type and register it with the model.
     * Otherwise, can be used to select Shape under pointer if one exists.
     * 
     * @param e mouse pressed event.
     */
    public void mousePressed(MouseEvent e){
        // Initializes these in case user drags the shape.
        this.newX = e.getX();
        this.newY = e.getY();
        
        // Tests to see if user is making a new shape or moving an existing one.
        if(dboard.getNextShape() == "circle" || dboard.getNextShape() == "arrow"
           || dboard.getNextShape() == "cross"){
            Shape s;
            if(dboard.getNextShape().equals("circle")){
                s = new Circle(new Point(e.getX(), e.getY()), 10);
            } else if(dboard.getNextShape().equals("arrow")){
                s = new Arrow(new Point(e.getX(), e.getY()), 20);
            } else {
                s = new Cross(new Point(e.getX(), e.getY()), 20);
            }
            s.setSelected(true);
            s.setColor(new Color(rng.nextInt(256), 
                                 rng.nextInt(256), rng.nextInt(256)));
            dboard.addShape(s);
            dboard.notifyAllListeners();
        } else if(dboard.getNextShape() == "delete"){
            if(dboard.listShapes().size() > 0){
                dboard.removeShape();
            }
        } else {
            Shape oldshape = dboard.referShape();
            dboard.selectShape(e.getX(), e.getY());
            if(oldshape != dboard.referShape()){
                dboard.notifyAllListeners();
            }
        }
    }
    
    /**
     * Controls the movement of Shapes while dragging, if a valid shape has been
     * selected.
     * 
     * @param e mouse dragging event.
     */
    public void mouseDragged(MouseEvent e){
        // Allows user to drag shapes. Since shape may not be drawn as quickly as the
        // mouse can move, this will make sure the shape does its best to 'keep up'.
        if(dboard.getNextShape() == "" && dboard.referShape() != null){
            if(dboard.referShape().isOn(e.getX(), e.getY())){
                dragging = true;
            }
            
            // Only updates the graphic listeners so that viewer is not drowned under
            // a wave of useless location data. To enable data flooding, change
            // notifyGraphicListeners() to notifyAllListeners().
            if(dragging){
                this.oldX = newX;
                this.oldY = newY;
                this.newX = e.getX();
                this.newY = e.getY();   
                dboard.moveShape(newX-oldX, newY-oldY);
                dboard.notifyGraphicListeners();
            }
        }
    }
    
    /**
     * Ensures shape being dragged stays being dragged until user releases mouse
     * button.
     * 
     * @param e mouse released event.
     */
    public void mouseReleased(MouseEvent e){
        if(dragging){
            dboard.notifyAllListeners();
            dragging = false;
        }
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}   
}
