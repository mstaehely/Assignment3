import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Controller object for Shapes.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */
public class ShapeController extends JPanel{
    private DrawingBoard dboard;
    private ShapeGraphicDisplay viewPane;
    private ShapeMouseListener mouseListener;
    private ShapeTextDisplay textPane;
    
    /**
     * Constructs a ShapeController object.
     * 
     * @param dboard the DrawingBoard this Controller controls.
     */
    public ShapeController(DrawingBoard dboard){
        this.dboard = dboard;
        setLayout(new BorderLayout());
        
        
        viewPane = new ShapeGraphicDisplay(dboard); 
        mouseListener = new ShapeMouseListener(dboard);
        
        viewPane.addMouseListener(mouseListener);
        viewPane.addMouseMotionListener(mouseListener);
        viewPane.setPreferredSize(new Dimension(400, 250));
        add(viewPane, BorderLayout.CENTER);
        
        textPane = new ShapeTextDisplay(dboard);
        JPanel buttons = new JPanel();
        JButton circle = new JButton("circle");
        circle.addActionListener(new ShapeButtonListener(dboard));
        JButton cross = new JButton("cross");
        cross.addActionListener(new ShapeButtonListener(dboard));
        JButton arrow = new JButton("arrow");
        arrow.addActionListener(new ShapeButtonListener(dboard));
        JButton done = new JButton("select");
        done.setActionCommand("");
        done.addActionListener(new ShapeButtonListener(dboard));
        JButton delete = new JButton("delete");
        delete.setActionCommand("delete");
        delete.addActionListener(new ShapeButtonListener(dboard));
        
        buttons.add(circle);
        buttons.add(cross);
        buttons.add(arrow);
        buttons.add(done);
        buttons.add(delete);
        this.add(buttons, BorderLayout.SOUTH);
    }
}