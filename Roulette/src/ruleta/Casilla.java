package ruleta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Clase que dibuja las porciones de la ruleta basandose en un angulo
 * 
 * @author Miguel Igual
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Casilla extends JPanel{

		public int start;
		public int angle;
		public Color color;
		
		/**
		 * Constructor de la clase.
		 * Recibe tres parámetros y los asigna a los privados de la clase:
		 * 
		 * @param start	posicion de inicio del angulo en grados
		 * @param angle angulo de cada porcion
		 * @param color color de la porcion
		 */
		public Casilla(int start, int angle, Color color)
		{
			super();
			setBounds(0, 0, 300, 300);
			this.start = start;
			this.angle = angle;
			this.color = color;
		}
		/**
		 * Método que dibuja la porcion establecida
		 * 
		 * @return void
		 */
	    private void drawPorcion(Graphics g) {
			g.setColor(color);
			g.fillArc(0, 0, 300, 300, start, angle);
	    }
	    
	    /**
	     * (non-Javadoc)
	     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	     */
		@Override
		protected void paintComponent(Graphics g){
			drawPorcion(g);
		}
		
	    
}
