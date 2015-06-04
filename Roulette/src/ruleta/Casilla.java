package ruleta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Casilla extends JPanel{
	
		public int start;
		public int angle;
		public Color color;
		
		public Casilla(int start, int angle, Color color)
		{
			super();
			setBounds(0, 0, 300, 300);
			this.start = start;
			this.angle = angle;
			this.color = color;
		}
		
	    private void drawCasilla(Graphics g) {
			g.setColor(color);
			g.fillArc(0, 0, 300, 300, start, angle);
	    }
	    
		@Override
		protected void paintComponent(Graphics g){
			drawCasilla(g);
		}
		
	    
}
