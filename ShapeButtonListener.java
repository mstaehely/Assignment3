import java.awt.event.*;

/**
 * Controls button clicks for the GUI window.
 * 
 * @author Matthew Staehely
 * @version CSC 143 Winter 15
 */

class ShapeButtonListener implements ActionListener{
    private DrawingBoard dboard;
    
    /**
     * Constructor for objects of class ShapeButtonListener
     * 
     * @param board the model object of the simulation.
     */
    public ShapeButtonListener(DrawingBoard board){
        super();
        this.dboard = board;
    }
    
    /**
     * Processes button clicks by tracking which shape the user wishes to draw.
     * 
     * @param e the event created by the button click.
     */  
    public void actionPerformed(ActionEvent e){
        dboard.setNextShape(e.getActionCommand());
        if(e.getActionCommand() == "delete"){
            System.out.println("Selected shape will be deleted. Click to confirm.");
        } else if(e.getActionCommand() != ""){
            System.out.println("Now making: " + e.getActionCommand());
        } else {
            System.out.println("Click on a shape to select it.");
        }
    }
}