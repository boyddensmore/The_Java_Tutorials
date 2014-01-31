package com.densmore.checkers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		// Create the frame
		frame = new JFrame();
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(gridCols, gridRows));

		// Create the grid of panels that will be the board.
		panelGrid = new JPanel[gridCols][gridRows];

		for (int y = 0; y < gridRows; y++) {
			for (int x = 0; x < gridCols; x++) {
				panelGrid[x][y] = new JPanel(); // creates new panel
				panelGrid[x][y].setBorder(new LineBorder(Color.black));
				panelGrid[x][y].setSize(frameWidth / gridCols, frameHeight
						/ gridRows);

				panelGrid[x][y].addMouseListener(new MouseListener() {
		            @Override
		            public void mousePressed(MouseEvent e) {
		            }
					@Override
		            public void mouseReleased(MouseEvent e) {
						panelClicked((JPanel) e.getSource(), e);
		            }
					@Override
					public void mouseClicked(MouseEvent arg0) {
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
					}
		        });
				
				frame.getContentPane().add(panelGrid[x][y]); // adds panel to grid
			}
		}
		
		//Set up the glass pane, which appears over both menu bar
        //and content pane.
//        myGlassPane = new GlassPane(panelGrid, frame.getContentPane());
//        frame.setGlassPane(myGlassPane);
//        myGlassPane.setVisible(true);

	
        //Show the window.
        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
//      For use in another project, perhaps.  
//      Makes the frame the size it would need to be to fit all of the components.  
//      frame.pack();
        frame.setVisible(true);
		
	}

    public static void panelClicked(JPanel panel, MouseEvent e) {
    	System.out.println("Mouse Released: " + e.getButton());
    	if (e.getButton() == MouseEvent.BUTTON1) {
    		panel.setBackground(Color.white);
    	} else if (e.getButton() == MouseEvent.BUTTON3) {
    		
    		panel.setBackground(Color.black);
    		
    		JButton btnNewButton = new JButton("New button");
    		btnNewButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.println("Clicked the button");
    			}
    		});
    		btnNewButton.setBackground(Color.black);
    		btnNewButton.setVisible(true);
    		panel.add(btnNewButton);
    		frame.setVisible(true);
    		
    	}
    	
    		
    		
    	
    	
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