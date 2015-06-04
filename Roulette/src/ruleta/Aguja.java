package ruleta;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Aguja extends JPanel {
	
	private Polygon triangle;

	/**
	 * Create the panel.
	 */
	public Aguja() {
		setBounds(0, 0, 34, 34);
	    int xPoly[] = {4, 17, 30};
        int yPoly[] = {0, 34, 0};

        triangle = new Polygon(xPoly, yPoly, xPoly.length);
	}
	
	private void drawAguja(Graphics g) {
		  super.paintComponent(g);
          g.setColor(Color.DARK_GRAY);
          g.fillPolygon(triangle);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		drawAguja(g);
	}
}
