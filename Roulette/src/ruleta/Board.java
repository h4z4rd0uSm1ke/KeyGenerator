package ruleta;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Board extends JPanel{
	
	public static Casilla[] casillas;
	public static int numeroCasillas=10;
	private Timer time;
	private int deltaTime;
	private boolean rotation;
	private static JButton botonGirar;
	private int random;
	private int randomSpin;
	private Ruleta ruleta;
	private Colors colors;
	private int angle=360/numeroCasillas;
	
	public Board(Ruleta r){
		
		super();
		colors= new Colors();
		ruleta=r;
		deltaTime=20;
		botonGirar=Ruleta.btnGirar;
		rotation=false;
		casillas = new Casilla[numeroCasillas];
		crearRuleta(numeroCasillas);
		run();

	}
	
	public void renew(){
		colors= new Colors();
		botonGirar=Ruleta.btnGirar;
		rotation=false;
		casillas = new Casilla[numeroCasillas];
		crearRuleta(numeroCasillas);
		repaint();
	}
	
	public void run(){

		botonGirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!rotation){
					animationRotate();
				}
			}
		});
	}
	
	private void crearRuleta(int numCasillas){
	
		int inc=0;
		for(int i=0; i<numCasillas; i++){
				casillas[i] = new Casilla(inc, angle, colors.colores[i]);
				add(casillas[i]);
				inc=inc+angle;
		}
	}
	
	private void animationRotate(){
		botonGirar.setEnabled(false);
		random=((int)(Math.random()*10)+1)*2;
		rotation=true;
		randomSpin=148+random;
		
//	        switch (random) {
//	            case 1:  randomSpin = 220;
//	            	break;
//	            case 2:  randomSpin = 222;
//	            	break;
//	            case 3:  randomSpin = 224;
//	            	break;
//	            case 4:  randomSpin = 226;
//                	break;
//	            case 5:  randomSpin = 228;
//                	break;
//	            case 6:  randomSpin = 230;
//                	break;
//	        }
//	      
	    ruleta.repaint();
	    
		time = new Timer(deltaTime, new ActionListener() {
			
		int count=0;
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0; i<numeroCasillas; i++){
					remove(casillas[i]);
					add(casillas[i] = new Casilla((casillas[i].start)+12, angle, casillas[i].color));
					ruleta.repaint();
				}
				count++;
				
				//wheel stop
				if(count==randomSpin){
					rotation=false;
					botonGirar.setEnabled(true);
					time.stop();
					ruleta.repaint();
				}
				
				repaint();
					
			}
			
		});
		time.start();
	}

	
}
