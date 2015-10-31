import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Listener for graphical display of shapes in model.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class ShapeGraphicDisplay extends JPanel implements ShapeListener{    
    private DrawingBoard dboard;

    /**
     * Constructor for objects of class ShapeGraphicDisplay
     * 
     * @param dboard the DrawingBoard object this listener will register to.
     */
    public ShapeGraphicDisplay(DrawingBoard dboard){
        this.dboard = dboard;
        dboard.addListener(this);
        dboard.addGraphicListener(this);
    }
    
    /**
     * Updates the graphical display if the model state changes.
     */
    public void shapeChanged(){
        this.repaint();
    }
    
    /**
     * Method used to display each Shape object. Knowledge of Shape objects drawing
     * is implicit to each Shape.
     * 
     * @param g the Graphics object used to draw the Shapes.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Shape s;  
        ArrayList<Shape> things = dboard.listShapes();
        ListIterator<Shape> it = things.listIterator();
        while(it.nextIndex() < things.size() - 1){
            s = it.next();
            s.setSelected(false);
            s.paintComponent(g);
        }
        
        // Necessary to ensure that the last object is outlined.
        if(it.hasNext()){
            s = it.next();
            s.setSelected(true);
            s.paintComponent(g);
        }
        
    }
}
