package ruleta;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * Clase que dibuja el elemento "Aguja"
 * 
 * @author Miguel Igual
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Aguja extends JPanel {
	
	private Polygon triangle;

	/**
	 * Constructor de la clase.
	 * Establece los parametros y coordenadas del triangulo que representará la aguja.
	 */
	public Aguja() {
		setBounds(0, 0, 34, 34);
	    int xPoly[] = {4, 17, 30};
        int yPoly[] = {0, 34, 0};

        triangle = new Polygon(xPoly, yPoly, xPoly.length);
	}
	
	/**
	 * Método que dibuja el objeto aguja
	 * 
	 * @return void
	 */
	private void drawAguja(Graphics g) {
		  super.paintComponent(g);
          g.setColor(Color.DARK_GRAY);
          g.fillPolygon(triangle);
	}
	
	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g){
		drawAguja(g);
	}
}
