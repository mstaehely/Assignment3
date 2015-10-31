import java.util.ArrayList;
import java.awt.*;

/**
 * Constructs a Drawing Board to store Shape objects.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class DrawingBoard{
    private Shape selected; // references the selected shape
    private ArrayList<Shape> shapeList; //used for storing all the shapes
    private ArrayList<ShapeListener> listeners;
    private ArrayList<ShapeListener> graphicListeners;
    private String nextShape;
    
    /**
     * Constructs the DrawingBoard.
     */
    public DrawingBoard(){
        selected = null;
        nextShape = "";
        shapeList = new ArrayList<Shape>();
        listeners = new ArrayList<ShapeListener>();
        graphicListeners = new ArrayList<ShapeListener>();
    }
    
    /**
     * Adds a shape to the shapeList array.
     * 
     * @param s Shape to be added to the array.
     */
    public void addShape(Shape s){
        shapeList.add(s);
        this.selected = s;
    }
    
    /**
     * Selects upper-most Shape which contains the x-y coordinates specified.
     * 
     * @param x the x-coordinate of the indicated point.
     * @param y the y-coordinate of the indicated point.
     * 
     * @throws IllegalArgumentException if either coordinate is less than 0.
     */
    public void selectShape(int x, int y){
        if(x < 0 || y < 0) 
        throw new IllegalArgumentException("Both coordinates must be positive.");
            for(int i = shapeList.size() -1; i >= 0; i--){
            if(shapeList.get(i).isOn(x, y)){
                this.selected = shapeList.get(i);
                this.selected.setSelected(true);
                shapeList.add(shapeList.get(i));
                shapeList.remove(i);
                i = -1;
            }
        }
    }
    
    /**
     * Passes a reference to the currently selected Shape.
     * 
     * @return reference to the selected shape, or null if none is selected.
     */
    public Shape referShape(){
        return selected;
    }
    
    /**
     * Removes a shape from the DrawingBoard.
     * 
     * @throws IllegalStateException if no Shape is selected.
     */
    public void removeShape(){
        if(selected == null) 
        throw new IllegalStateException("Shape must be selected for removal.");        
        shapeList.remove(shapeList.lastIndexOf(selected));//removes the selected Shape
        
        //Sets the newest selection to the topmost Shape in the array. If none exist, sets to null.
        if(shapeList.size() > 0){
            this.selected = shapeList.get(shapeList.size() - 1);
            this.selected.setSelected(true);
        } else {
            selected = null;
        }
        notifyAllListeners();
    }
    
    /**
     * Colors a selected Shape.
     * 
     * @param c the Color object used to set a Shape's color.
     * 
     * @throws IllegalStateException if no shape is selected.
     */
    public void colorShape(Color c){
        if(selected == null)
        throw new IllegalStateException("Shape must be selected for coloration.");
        this.selected.setColor(c);
    }
    
    /**
     * Moves a selected Shape.
     * 
     * @param deltaX moves the shape x number of pixels right.
     * @param deltaY moves the shape y number of pixels down.
     * 
     * @throws IllegalStateException if no Shape is selected.
     */
    public void moveShape(int deltaX, int deltaY){
        if(selected == null)
        throw new IllegalStateException("Shape must be selected for translation");
        this.selected.shiftUpperLeftBy(deltaX, deltaY);
    }
    
    /**
     * Returns an ArrayList copy of the original ArrayList for reference.
     * 
     * @return a list of the Shapes.
     */
    public ArrayList<Shape> listShapes(){     
       return new ArrayList<Shape>(shapeList);
    }
    
    /**
     * Adds a listener to this object's list of listeners.
     * 
     * @param sl ShapeListener object.
     * @throws IllegalStateException if a null listener is added.
     */
    public void addListener(ShapeListener sl){
        if(sl == null) throw new IllegalStateException();
        listeners.add(sl);
    }
    
    /**
     * Adds a listener to the list of this object's graphical listeners.
     * 
     * @param sl ShapeListener object.
     * @throws IllegalStateException if a null listener is added.
     */
    public void addGraphicListener(ShapeListener sl){
        if(sl == null) throw new IllegalStateException();
        graphicListeners.add(sl);
    }
    
    /**
     * Notifies any of this object's graphical listeners of changes to the model.
     * 
     * @throws IllegalStateException if system attempts to update when no listeners are
     * registered.
     */
    public void notifyGraphicListeners(){
        if(graphicListeners.size() < 1) throw new IllegalStateException();
        for(ShapeListener s : graphicListeners){
            s.shapeChanged();
        }
    }
            
    
    /**
     * Updates all listeners when changes are made to the model.
     * 
     * @throws IllegalStateException if system attempts to update when no listeners are
     * registered.
     */
    public void notifyAllListeners(){
        if(listeners.size() < 1) throw new IllegalStateException();
        for(ShapeListener s : listeners){
            s.shapeChanged();
        }
    }
    
    /**
     * Keeps track of the next shape to be added.
     * 
     * @param shape the shape which will be added with the next mouse click in window.
     */
    public void setNextShape(String shape){
        this.nextShape = shape;
    }
    
    /**
     * Informs listener of what shape is to be created on next click.
     * 
     * @return String the name of the shape to be created.
     */
    public String getNextShape(){
        return nextShape;  
    }
}