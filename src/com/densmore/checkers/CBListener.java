package com.densmore.checkers;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

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
//        redispatchMouseEvent(e, false);
    }

    public void mouseDragged(MouseEvent e) {
//        redispatchMouseEvent(e, false);
    }

    public void mouseClicked(MouseEvent e) {
//        redispatchMouseEvent(e, false);
    }

    public void mouseEntered(MouseEvent e) {
//        redispatchMouseEvent(e, false);
    }

    public void mouseExited(MouseEvent e) {
//        redispatchMouseEvent(e, false);
    }

    public void mousePressed(MouseEvent e) {
//        redispatchMouseEvent(e, false);
    }

    public void mouseReleased(MouseEvent e) {
//      TODO - CheckerBoard - CBListener - remove the repainting of the glass pane. 
    	redispatchMouseEvent(e, false);
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
        if (containerPoint.y < 0) { //we're not in the content pane
            if (containerPoint.y >= 0) {
            	
                //The mouse event is over the menu bar.
                //Could handle specially.
            } else { 
                //The mouse event is over non-system window 
                //decorations, such as the ones provided by
                //the Java look and feel.
                //Could handle specially.
            }
        } else {
            //The mouse event is probably over the content pane.
            //Find out exactly which component it's over.  
            Component component = 
                SwingUtilities.getDeepestComponentAt(
                                        container,
                                        containerPoint.x,
                                        containerPoint.y);
            
            if (component != null) {
           	
            	for (int y = 0; y < panelGrid.length; y++) {
            		for (int x = 0; x < panelGrid.length; x++ ) {
            			if (component.equals(panelGrid[y][x])) {
            				System.out.println(x + " " + y);
            			}
            		}
            	}
            	
                //Forward events over the check box.
                Point componentPoint = SwingUtilities.convertPoint(
                                            glassPane,
                                            glassPanePoint,
                                            component);
                component.dispatchEvent(new MouseEvent(component,
                                                     e.getID(),
                                                     e.getWhen(),
                                                     e.getModifiers(),
                                                     componentPoint.x,
                                                     componentPoint.y,
                                                     e.getClickCount(),
                                                     e.isPopupTrigger()));
            }
        }
        
        //Update the glass pane if requested.
        if (repaint) {
            glassPane.setPoint(glassPanePoint);
            glassPane.repaint();
        }
    }
}