package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Choice;

import javax.swing.JButton;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSlider;

import java.awt.Label;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


/**
 * GUI del programa.
 * 
 * @author Miguel Igual
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	/**
	 * El panel que contendrá el resto de elementos
	 */
	private JPanel contentPane;
	/**
	 * Botón que al pulsar nos generará la clave deseada
	 */
	private JButton btnGenerar;
	/**
	 * Campo de texto donde aparecerá impresa la clave generada
	 */
	private JTextField txtKey;
	/**
	 * Etiqueta que muestra la logitud de la clave actualmente seleccionada
	 */
	private Label labelLong;
	/**
	 * Deslizador que nos permite eligir la longitud de la clave en un rango determinado
	 */
	private JSlider slider;
	/**
	 * Lista desplegable con las distintas opciones a elegir
	 */
	private Choice choice;
	
	/**
	 * Lanza la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el Frame
	 */
	public MainFrame() {
		
		
		setResizable(false);
		setTitle("GeneratorMikeGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 279);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		String[] opt;
		opt=new String[5];
		opt[0]="[A-Z]";
		opt[1]="[0-9]";
		opt[2]="[hex]";
		opt[3]="[A-Z + 0-9]";
		opt[4]="[anterior + special chars]";
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setForeground(Color.YELLOW);
		panel.add(lblLongitud);
		
		labelLong = new Label("New label");
		labelLong.setForeground(new Color(255, 255, 0));
		labelLong.setAlignment(Label.CENTER);
		panel.add(labelLong);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				labelLong.setText(""+slider.getValue()+" caracteres");
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		slider.setBackground(new Color(0, 0, 0));
		slider.setForeground(new Color(255, 255, 0));
		slider.setMinimum(4);
		slider.setMaximum(48);
		slider.setValue(8);
		panel.add(slider);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.YELLOW);
		panel.add(lblTipo);
		
		choice = new Choice();
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.LIGHT_GRAY);
		choice.addItem(opt[0]);
		choice.addItem(opt[1]);
		choice.addItem(opt[2]);
		choice.addItem(opt[3]);
		choice.addItem(opt[4]);
		panel.add(choice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_center_down = new JPanel();
		panel_center_down.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_center_down);
		panel_center_down.setLayout(null);
		
		txtKey = new JTextField();
		txtKey.setEditable(false);
		txtKey.setBounds(33, 92, 400, 20);
		panel_center_down.add(txtKey);
		txtKey.setForeground(new Color(255, 255, 255));
		txtKey.setBackground(new Color(51, 51, 51));
		txtKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtKey.setColumns(54);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(193, 55, 85, 23);
		panel_center_down.add(btnGenerar);
		btnGenerar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				int opt=choice.getSelectedIndex();
					
				GenerateAZ genAZ = new GenerateAZ(slider.getValue(), opt);
				txtKey.setText(genAZ.keyGenerated());
				
				repaint();

				}
			});
		btnGenerar.setForeground(Color.BLACK);
		btnGenerar.setBackground(Color.GREEN);
		btnGenerar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		setFocusable(true);
	}
}
