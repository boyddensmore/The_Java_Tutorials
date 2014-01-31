package com.densmore.swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonGrid {
	
    public static void main(String[] args) {
    	int width = 5;
    	int length = 5;
    	JFrame frame=new JFrame(); //creates frame
        JButton[][] grid; //names the grid of buttons
   	
        frame.setLayout(new GridLayout(width,length)); //set layout
        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++){
                for(int x=0; x<width; x++){
                        grid[x][y]=new JButton("("+x+","+y+")"); //creates new button    
                        frame.add(grid[x][y]); //adds button to grid
                }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
        frame.setSize(400, 400);
    	
    }
}