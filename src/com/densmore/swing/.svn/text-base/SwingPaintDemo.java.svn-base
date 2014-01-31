package com.densmore.swing;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class SwingPaintDemo {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? "
				+ SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame("Swing Paint Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(550, 550);
		f.setVisible(true);
	}
}

class MyPanel extends JPanel {

	Square blackSquare = new Square(50, 50, 75, 75, Color.black);
	Square redSquare = new Square(150, 150, 75, 75, Color.red);
	private int leftMouseState = 0;
	private int rightMouseState = 0;
	private int lastYCord = 0;
	private int lastXCord = 0;
	private int moveXOffset = 0;
	private int moveYOffset = 0;
	private boolean squareCaptured = false;

	public MyPanel() {

		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int widthChange = 0;
				int heightChange = 0;
				
//				Toggle the state of the button fields
				switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					leftMouseState = MouseEvent.BUTTON1;
					break;
				case MouseEvent.BUTTON3:
					rightMouseState = MouseEvent.BUTTON3;
					break;
				}
				
//				If mouse 1 is pressed, set the move offset for use by the mouseDragged method and mark the square as captured.
				 if (e.getButton() == MouseEvent.BUTTON1){
					 if (e.getX() >= blackSquare.getX() && e.getX() <= blackSquare.getX() + blackSquare.getWidth() &&
						 e.getY() >= blackSquare.getY() && e.getY() <= blackSquare.getY() + blackSquare.getHeight()){
						 moveXOffset = blackSquare.getX() - e.getX();
						 moveYOffset = blackSquare.getY() - e.getY();
						 squareCaptured = true;
					 }
					 
//				If mouse 3 is pressed, see how far the mouse is from the top left corner of the 
//				square and resize the square by that amount.
				 } else if (e.getButton() == MouseEvent.BUTTON3){
					 lastYCord = e.getY();
					 lastXCord = e.getX();
					 
					 widthChange = e.getX() - blackSquare.getX() - blackSquare.getWidth();
					 heightChange = e.getY() - blackSquare.getY() - blackSquare.getHeight();
					 
					 resizeSquare(widthChange, heightChange);
				 }
			}
		});

		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
//				Mouse button has been released.  Toggle the mouse button fields back to 0.
				switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					leftMouseState = 0;
					squareCaptured = false;
					break;
				case MouseEvent.BUTTON3:
					rightMouseState = 0;
					break;
				}
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				int xChange = 0;
				int yChange = 0;
				
//				If the left mouse button is pressed, move the square.
				if (leftMouseState > 0){
					if (squareCaptured) {
						moveSquare(e.getX() + moveXOffset, e.getY() + moveYOffset);
					}
				} else
//				If the right mouse button is pressed, resize the square.
				if (rightMouseState >= 0) {
					if (e.getX() > blackSquare.getX()) {
						xChange = e.getX() - blackSquare.getX() - blackSquare.getWidth();
					}
					
					if (e.getY() > blackSquare.getY()) {
						yChange = e.getY() - blackSquare.getY() - blackSquare.getHeight();
					}

					resizeSquare(xChange, yChange);
					
					lastXCord = e.getX();
					lastYCord = e.getY();
				}
					
			}
		});

	}

	
	private void resizeSquare(int widthChange, int heightChange) {
		int newHeight = 0;
		int newWidth = 0;
		
		final int CURR_X = blackSquare.getX();
		final int CURR_Y = blackSquare.getY();
		final int CURR_W = blackSquare.getWidth();
		final int CURR_H = blackSquare.getHeight();
		final int OFFSET = 1;

		newHeight = blackSquare.getHeight() + heightChange;
		newWidth = blackSquare.getWidth() + widthChange ;
		
		if (newHeight < 1) {
			newHeight = 1;
		}
		if (newWidth < 1) {
			newWidth = 1;
		}
		
		blackSquare.setHeight(newHeight);
		blackSquare.setWidth(newWidth);
		
		// The square is moving, repaint background
		// over the old square location.
		repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

		// Repaint the square at the new location.
		repaint(blackSquare.getX(), blackSquare.getY(), blackSquare.getWidth()
				+ OFFSET, blackSquare.getHeight() + OFFSET);
	}
	
	
	private void moveSquare(int x, int y) {

		// Current square state, stored as final variables
		// to avoid repeat invocations of the same methods.
		final int CURR_X = blackSquare.getX();
		final int CURR_Y = blackSquare.getY();
		final int CURR_W = blackSquare.getWidth();
		final int CURR_H = blackSquare.getHeight();
		final int OFFSET = 1;

		if ((CURR_X != x) || (CURR_Y != y)) {

			// The square is moving, repaint background
			// over the old square location.
			repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

			// Update coordinates.
			blackSquare.setX(x);
			blackSquare.setY(y);

			// Repaint the square at the new location.
			repaint(blackSquare.getX(), blackSquare.getY(), blackSquare.getWidth()
					+ OFFSET, blackSquare.getHeight() + OFFSET);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(150, 100);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Move me, resize me", 10, 20);

		blackSquare.paintSquare(g);
		redSquare.paintSquare(g);
	}
}

class Square {

	private int xPos = 50;
	private int yPos = 50;
	private int width = 50;
	private int height = 50;
	private Color color = Color.red;

	/**
	 * @param xPos
	 * @param yPos
	 * @param width
	 * @param height
	 * @param color
	 */
	public Square(int xPos, int yPos, int width, int height, Color color) {
		this.setX(xPos);
		this.setY(yPos);
		this.setHeight(height);
		this.setWidth(width);
		this.setColor(color);
	}
	
	public Square() {
	}
	
	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getX() {
		return xPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color) {
		if (! color.equals(null)){
			this.color = color;
		}
	}
	
	
	public void paintSquare(Graphics g) {
		g.setColor(color);
		g.fillRect(xPos, yPos, width, height);
		g.setColor(color);
		g.drawRect(xPos, yPos, width, height);
	}
}
