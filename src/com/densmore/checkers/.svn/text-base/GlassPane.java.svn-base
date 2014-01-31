package com.densmore.checkers;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

class GlassPane extends JComponent implements ItemListener {
	Point point;

	// React to change button clicks.
	public void itemStateChanged(ItemEvent e) {
		setVisible(true);
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