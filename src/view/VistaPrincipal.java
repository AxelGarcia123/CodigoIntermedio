package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cuadruplos;
import model.Posfija;
import model.Tercetos;
import model.Triplos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VistaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField campoInfijo;
	private JButton generar;
	private JPanel panel_1;
	private JLabel campoPosfijo;
	private JLabel campoTriplos;
	private JLabel campoCuadruplos;
	private JLabel campoTercetos;
	private Posfija posfija;
	private Triplos triplos;
	private Cuadruplos cuadruplos;
	private Tercetos tercetos;
	private List<String> listaTercetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		posfija = new Posfija();
		triplos = new Triplos();
		cuadruplos = new Cuadruplos();
		tercetos = new Tercetos();
		listaTercetos = new ArrayList<>();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblIngresaUnaExpresin = new JLabel("Ingresa una expresión:");
		lblIngresaUnaExpresin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresaUnaExpresin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblIngresaUnaExpresin.setForeground(Color.BLACK);
		lblIngresaUnaExpresin.setBackground(Color.WHITE);
		panel.add(lblIngresaUnaExpresin);
		
		campoInfijo = new JTextField();
		panel.add(campoInfijo);
		campoInfijo.setColumns(10);
		
		generar = new JButton("Generar");
		generar.setForeground(Color.WHITE);
		generar.addActionListener(this);
		generar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		generar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generar.setBackground(new Color(45, 0, 255));
		panel.add(generar);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		
		campoPosfijo = new JLabel("Posfija");
		campoPosfijo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		campoPosfijo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(campoPosfijo);
		
		campoTriplos = new JLabel("Triplos");
		campoTriplos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		campoTriplos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(campoTriplos);
		
		campoCuadruplos = new JLabel("Cuádruplos");
		campoCuadruplos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		campoCuadruplos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(campoCuadruplos);
		
		campoTercetos = new JLabel("Tercetos");
		campoTercetos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		campoTercetos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(campoTercetos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == generar) {
			if(campoInfijo.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Ingrese una cadena en el campo.", null, JOptionPane.ERROR_MESSAGE);
			else {
				campoPosfijo.setText(posfija.posfija(campoInfijo.getText()));
				campoTriplos.setText("<html><body>"+ triplos.triplos(campoInfijo.getText()) + "</body></html>");
				listaTercetos = cuadruplos.cuadruplos(campoInfijo.getText());
				String cuadruplosTerminados = "";
				for (String datos : listaTercetos)
					cuadruplosTerminados += datos + "\n";
				campoCuadruplos.setText("<html><body>"+ cuadruplosTerminados + "</body></html>");
				listaTercetos = tercetos.tercetos(listaTercetos);
				String tercetosTerminados = "";
				for (String datos : listaTercetos)
					tercetosTerminados += datos + "\n";
				campoTercetos.setText("<html><body>"+ tercetosTerminados + "</body></html>");
				//c=a+(d-e*f)/j+b*k
				//c=a-d+(e*f+j)/b*k
				//c=a*d/(e-f+j)/b-k
				//c=a/d+(e-f*j)/b+k
				//c=a-d+(e*f+j)/b*k
			}
		}
	}

}
