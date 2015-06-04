package ruleta;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class Ruleta extends JFrame {

	public static JButton btnGirar = new JButton("Girar");
	private JPanel contentPane;
	private int width=1200;
	private int height=700;
	private Board board;
	private Aguja panel_aguja;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel[] panelColors;
	private JLabel[] campos;
	private JPanel[] cuadros;
	private int posCuadro=10;
	private Colors colors;
	private int numCasillas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ruleta frame = new Ruleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ruleta() {
		setTitle("La Petite Roulette");
		
		int screenWidth=getScreenWidth();
		int screenHeight=getScreenHeight();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((screenWidth/2)-(width/2), (screenHeight/2)-(height/2), width, height);
		numCasillas=Board.numeroCasillas;
		
		colors = new Colors();
		
		panelColors = new JPanel[10];
		for(int i=0; i<10; i++){
			panelColors[i]=new JPanel();
			panelColors[i].setLayout(null);
		}
		campos = new JLabel[numCasillas];
		for(int i=0; i<numCasillas; i++){
			campos[i]=new JLabel();
			campos[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
			campos[i].setBounds(70, 11, 180, 43);
			campos[i].setText("Resultado "+(i+1));
			panelColors[i].add(campos[i]);
		}
		cuadros = new JPanel[Board.numeroCasillas];
		for(int i=0; i<numCasillas; i++){
			cuadros[i]=new JPanel();
			cuadros[i].setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			cuadros[i].setBackground(colors.colores[i]);
			cuadros[i].setBounds(posCuadro, 11, 50, 43);
			panelColors[i].add(cuadros[i]);
		}

	
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 600, 640);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(600, 63, 580, 445);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(5, 2, 0, 0));
		
		board = new Board(this);
		board.setBounds((panel_1.getWidth()/2)-150, 134, 300, 300);
		board.setBackground(Color.GRAY);
		board.setLayout(null);
		panel_1.add(board);
		
		panel_aguja = new Aguja();
		panel_aguja.setBounds((panel_1.getWidth()/2)-17, 100, 34, 34);
		panel_1.add(panel_aguja);
		panel_aguja.setLayout(null);
		
		btnGirar.setBounds((panel_1.getWidth()/2)-50, 500, 100, 23);
		panel_1.add(btnGirar);
		
		for(int i=0; i<10; i++){
			panel_2.add(panelColors[i]);
		}
	
	}
	
	public static int getScreenWidth() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	}

	public static int getScreenHeight() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}
}
