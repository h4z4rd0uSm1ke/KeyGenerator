package ruleta;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que establece y genera el panel de la ruleta gráficamente.
 * 
 * @author Miguel Igual
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Board extends JPanel{
	
	public static Casilla[] casillas;
	//Numero de casillas o porciones. Se puede establecer un numero del 2 al 10 y la ruleta será generada sin problema (excepto con el numero 7 que al ser usar nuestra función un entero no llega a cerrar el circulo del todo).
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
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param r Se recibe el frame Ruleta como parámetro
	 */
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
	
	/**
	 * Añade un evento al botón de girar, que al pulsar, si la ruleta no está girando ya,
	 * inicia la animación de rotar.
	 * 
	 */
	public void run(){

		botonGirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!rotation){
					animationRotate();
				}
			}
		});
	}
	
	/**
	 * Método que nos genera las porciones o casillas de la ruleta hasta rellenar un circulo completo.
	 * 
	 * @return void
	 */
	private void crearRuleta(int numCasillas){
	
		int inc=0;
		for(int i=0; i<numCasillas; i++){
				casillas[i] = new Casilla(inc, angle, colors.colores[i]);
				add(casillas[i]);
				inc=inc+angle;
		}
	}
	
	/**
	 * Método que genera la animación de giro de la ruleta.
	 * Esto se consigue modificando los paramétros de los angulos creados a traves de un Timer.
	 * Cuando el contador @count alcanza el valor de @randomSpin el timer se para.
	 * 
	 * @return void
	 */
	private void animationRotate(){
		botonGirar.setEnabled(false);
		random=((int)(Math.random()*10)+1)*2;
		rotation=true;
		randomSpin=148+random;
		
	    ruleta.repaint();
	    
		time = new Timer(deltaTime, new ActionListener() {
			
		int count=0;
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
