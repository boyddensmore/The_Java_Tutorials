package com.densmore.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CustomDialogBox extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtYup;
	public String ResultInput;

	/**
	 * Create the dialog.
	 */
	public CustomDialogBox() {
		setBounds(100, 100, 186, 107);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtYup = new JTextField();
			txtYup.setText("Yup.");
			contentPanel.add(txtYup);
			txtYup.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		ResultInput = txtYup.getText();
		        		CustomDialogBox.this.dispose();
		        	}
		        });
				buttonPane.add(cancelButton);
			}
		}
	}

}
