package mantenimiento;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ConsultaTienda extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnCerrar;
	private JComboBox<?> boxSeleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTienda frame = new ConsultaTienda();
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
	public ConsultaTienda() {
		setTitle("Consultar Tienda");
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		contentPane.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 44, 66, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 77, 66, 14);
		contentPane.add(lblAncho);
		
		JLabel lblLargo = new JLabel("Largo (cm)");
		lblLargo.setBounds(10, 111, 66, 14);
		contentPane.add(lblLargo);
		
		JLabel lblEspesor = new JLabel("Espesor (mm)");
		lblEspesor.setBounds(10, 146, 66, 14);
		contentPane.add(lblEspesor);
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(10, 182, 66, 14);
		contentPane.add(lblContenido);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\mianl\\Projectos Eclipse\\proyecto en grupo\\Proyecto-Ceramicas\\Tienda Ceramica\\src\\img\\exit.png"));
		btnCerrar.setBounds(307, 7, 117, 51);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(86, 41, 211, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(86, 77, 211, 20);
		contentPane.add(txtAncho);
		txtAncho.setColumns(10);
		
		txtLargo = new JTextField();
		txtLargo.setEditable(false);
		txtLargo.setBounds(86, 108, 211, 20);
		contentPane.add(txtLargo);
		txtLargo.setColumns(10);
		
		txtEspesor = new JTextField();
		txtEspesor.setEditable(false);
		txtEspesor.setBounds(86, 143, 211, 20);
		contentPane.add(txtEspesor);
		txtEspesor.setColumns(10);
		
		txtContenido = new JTextField();
		txtContenido.setEditable(false);
		txtContenido.setBounds(86, 179, 211, 20);
		contentPane.add(txtContenido);
		txtContenido.setColumns(10);
		
		boxSeleccion = new JComboBox();
		boxSeleccion.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		boxSeleccion.addActionListener(this);
		boxSeleccion.setBounds(86, 7, 211, 22);
		contentPane.add(boxSeleccion);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCerrar) {
			btnPerformedDelete(event);
		}
		if (event.getSource() == boxSeleccion) {
			cboSeleccionIndex(event);
		}
	}

	private void btnPerformedDelete(ActionEvent event) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Salir de consultas?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}
	
	private void cboSeleccionIndex(ActionEvent event) {
		switch (boxSeleccion.getSelectedIndex()) {
		case 0:
			txtPrecio.setText(""+MenuPrincipal.precio0);
			txtAncho.setText(""+MenuPrincipal.ancho0);
			txtLargo.setText(""+MenuPrincipal.largo0);
			txtEspesor.setText(""+MenuPrincipal.espesor0);
			txtContenido.setText(""+MenuPrincipal.contenido0);
			break;
		case 1:
			txtPrecio.setText(""+MenuPrincipal.precio1);
			txtAncho.setText(""+MenuPrincipal.ancho1);
			txtLargo.setText(""+MenuPrincipal.largo1);
			txtEspesor.setText(""+MenuPrincipal.espesor1);
			txtContenido.setText(""+MenuPrincipal.contenido1);			
			break;
		case 2:
			txtPrecio.setText(""+MenuPrincipal.precio2);
			txtAncho.setText(""+MenuPrincipal.ancho2);
			txtLargo.setText(""+MenuPrincipal.largo2);
			txtEspesor.setText(""+MenuPrincipal.espesor2);
			txtContenido.setText(""+MenuPrincipal.contenido2);
			break;
		case 3:
			txtPrecio.setText(""+MenuPrincipal.precio3);
			txtAncho.setText(""+MenuPrincipal.ancho3);
			txtLargo.setText(""+MenuPrincipal.largo3);
			txtEspesor.setText(""+MenuPrincipal.espesor3);
			txtContenido.setText(""+MenuPrincipal.contenido3);
			break;
		case 4:
			txtPrecio.setText(""+MenuPrincipal.precio4);
			txtAncho.setText(""+MenuPrincipal.ancho4);
			txtLargo.setText(""+MenuPrincipal.largo4);
			txtEspesor.setText(""+MenuPrincipal.espesor4);
			txtContenido.setText(""+MenuPrincipal.contenido4);
			break;
		}
	}
	
	
}
