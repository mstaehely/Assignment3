import javax.swing.*;

/**
 * GraphicsEditorApp class.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class GraphicsEditorApp{
    private DrawingBoard dboard = new DrawingBoard();
    
    /**
     * Main method for using a GraphicsEditorApp object.
     * 
     * @param args not used in this context.
     */
    public static void main(String[] args)
    {
        new GraphicsEditorApp();        
    }
    
    /**
     * Constructs a new GraphicsEditorApp object.
     */
    public GraphicsEditorApp()
    {          
        JFrame win = new JFrame("Shape Viewer");
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ShapeMouseListener sml = new ShapeMouseListener(dboard);
        ShapeController control = new ShapeController(dboard);
        win.getContentPane().add(control);
        
        win.pack();
        win.setVisible(true);        
    }
}
