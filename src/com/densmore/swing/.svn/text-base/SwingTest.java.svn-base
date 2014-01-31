package com.densmore.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingTest {

	private JFrame frame;
	private JTextField celsiusValue;
	private JLabel lblFahrenheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingTest window = new SwingTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingTest() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				int celsiusInt = (int)(Double.parseDouble(celsiusValue.getText()));
				int notches = e.getWheelRotation();
			    if (notches < 0) {
		    		celsiusInt++;
			    } else {
			    	if (celsiusInt > 0) {
			    		celsiusInt--;
			    	}
			    }
			    celsiusValue.setText(Integer.toString(celsiusInt));
			}
		});
		frame.setBounds(100, 100, 223, 106);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setBounds(110, 46, 95, 14);
		frame.getContentPane().add(lblFahrenheit);
		
		celsiusValue = new JTextField();
		celsiusValue.setText("0");
		celsiusValue.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(celsiusValue);
		celsiusValue.setColumns(10);
		
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(110, 14, 46, 14);
		frame.getContentPane().add(lblCelsius);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Parse degrees Celsius as a double and convert to Fahrenheit.
			    int tempFahr = (int)((Double.parseDouble(celsiusValue.getText()))
			            * 1.8 + 32);
			    lblFahrenheit.setText(tempFahr + " Fahrenheit");
			}
		});
		btnConvert.setBounds(10, 42, 89, 23);
		frame.getContentPane().add(btnConvert);
	}
}
