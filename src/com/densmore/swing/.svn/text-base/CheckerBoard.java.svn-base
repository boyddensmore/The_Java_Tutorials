package com.densmore.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

public class CheckerBoard {

	private static JFrame frame;
	private static JPanel[][] panelGrid;
	private static int frameX = 400;
	private static int frameY = 300;
	private static int frameHeight = 400;
	private static int frameWidth = 400;
	private static int gridCols = 5;
	private static int gridRows = 5;
	static private GlassPane myGlassPane;

	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.

    	System.out.println("Started createAndShowGUI");
    	
		// Create the frame
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(frameX, frameY, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(gridCols, gridRows));

		System.out.println("Frame created");
		
		// Create the grid of panels that will be the board.
		panelGrid = new JPanel[gridCols][gridRows];

		for (int y = 0; y < gridRows; y++) {
			for (int x = 0; x < gridCols; x++) {
				panelGrid[x][y] = new JPanel(); // creates new panel
				panelGrid[x][y].setBorder(new LineBorder(Color.black));
				panelGrid[x][y].setSize(frameWidth / gridCols, frameHeight
						/ gridRows);
				frame.add(panelGrid[x][y]); // adds panel to grid

				// Add a piece to this panel
			}
		}
		
		//Set up the glass pane, which appears over both menu bar
        //and content pane and is an item listener on the change
        //button.
        myGlassPane = new GlassPane(panelGrid, frame.getContentPane());

        frame.setGlassPane(myGlassPane);

        //Show the window.
        frame.pack();
        frame.setVisible(true);
		
	}

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}

class GlassPane extends JComponent implements ItemListener {
	Point point;

	// React to change button clicks.
	public void itemStateChanged(ItemEvent e) {
		setVisible(e.getStateChange() == ItemEvent.SELECTED);
	}

	protected void paintComponent(Graphics g) {
		if (point != null) {
			g.setColor(Color.red);
			g.fillOval(point.x - 10, point.y - 10, 20, 20);
		}
	}

	public void setPoint(Point p) {
		point = p;
	}

	public GlassPane(JPanel[][] panelGrid,
			Container contentPane) {
		CBListener listener = new CBListener(panelGrid, this, contentPane);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
}

/**
 * Listen for all events that our check box is likely to be
 * interested in.  Redispatch them to the check box.
 */
class CBListener extends MouseInputAdapter {
    Toolkit toolkit;
    JPanel[][] panelGrid;
    GlassPane glassPane;
    Container contentPane;

    public CBListener(JPanel[][] panelGrid,
                      GlassPane glassPane, Container contentPane) {
        toolkit = Toolkit.getDefaultToolkit();
        this.panelGrid = panelGrid;
        this.glassPane = glassPane;
        this.contentPane = contentPane;
    }

    public void mouseMoved(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    public void mouseDragged(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    public void mouseClicked(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    public void mouseEntered(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    public void mouseExited(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    public void mousePressed(MouseEvent e) {
        redispatchMouseEvent(e, false);
    }

    public void mouseReleased(MouseEvent e) {
        redispatchMouseEvent(e, true);
    }

    //A basic implementation of redispatching events.
    private void redispatchMouseEvent(MouseEvent e,
                                      boolean repaint) {
        Point glassPanePoint = e.getPoint();
        Container container = contentPane;
        Point containerPoint = SwingUtilities.convertPoint(
                                        glassPane,
                                        glassPanePoint,
                                        contentPane);
//        if (containerPoint.y < 0) { //we're not in the content pane
//            if (containerPoint.y + menuBar.getHeight() >= 0) {
            	
                //The mouse event is over the menu bar.
                //Could handle specially.
//            } else { 
                //The mouse event is over non-system window 
                //decorations, such as the ones provided by
                //the Java look and feel.
                //Could handle specially.
//            }
//        } else {
            //The mouse event is probably over the content pane.
            //Find out exactly which component it's over.  
//            Component component = 
//                SwingUtilities.getDeepestComponentAt(
//                                        container,
//                                        containerPoint.x,
//                                        containerPoint.y);
//                            
//            if ((component != null) 
//                && (component.equals(liveButton))) {
                //Forward events over the check box.
//                Point componentPoint = SwingUtilities.convertPoint(
//                                            glassPane,
//                                            glassPanePoint,
//                                            component);
//                component.dispatchEvent(new MouseEvent(component,
//                                                     e.getID(),
//                                                     e.getWhen(),
//                                                     e.getModifiers(),
//                                                     componentPoint.x,
//                                                     componentPoint.y,
//                                                     e.getClickCount(),
//                                                     e.isPopupTrigger()));
//            }
//        }
        
        //Update the glass pane if requested.
        if (repaint) {
            glassPane.setPoint(glassPanePoint);
            glassPane.repaint();
        }
    }
}

class Piece {
	private int x;
	private int y;
	private int player;
	private Color color;
	private boolean king;
	private int width;
	private int height;

	/**
	 * Creates a new piece within the given JPanel container.
	 * 
	 * @param container The JPanel that will hold this piece initially.
	 * @param player An integer specifying either player 1 (Black) or player 2 (Red).
	 */
	public Piece(JPanel place, int player) {
		this.player = player;
		if (player == 1) {
			color = Color.black;
		} else if (player == 2) {
			color = Color.red;
		}

		king = false;
		x = place.getX() + 5;
		y = place.getY() + 5;
	}

	/**
	 * Moves the piece to a new spot.
	 * 
	 * @param newContainer The new container that will hold this piece.
	 */
	public void movePiece(JPanel newContainer) {

	}

	/**
	 * Make this piece a king, allowing it more flexibility of movement.
	 */
	public void makeKing() {
		king = true;
	}

	public void paintSquare(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

}
