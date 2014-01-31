package com.densmore.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

/* TopLevelDemo.java requires no other files. */
public class LaunchCustomDialogBox {
	
	private static JFrame frame;
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the menu bar.  Make it have a green background.
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200, 20));

        //Create a yellow label to put in the content pane.
        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));

        //Set the menu bar and add the label to the content pane.
        frame.setJMenuBar(greenMenuBar);
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
        
        JButton btnTryMe = new JButton("Try Me");
        btnTryMe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		Gonna show me a message        		
//        		JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
//        		JOptionPane.showMessageDialog(frame, "Test", "Test title",  JOptionPane.QUESTION_MESSAGE);
        		try {
        			CustomDialogBox dialog = new CustomDialogBox();
        			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        			dialog.setVisible(true);
        		} catch (Exception x) {
        			x.printStackTrace();
        		}
        	}
        });
        frame.getContentPane().add(btnTryMe);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

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