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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ModificarTienda extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JComboBox boxModelo;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JTextField txtContenido;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarTienda frame = new ModificarTienda();
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
	public ModificarTienda() {
		setTitle("Modificar Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(10, 43, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ancho (cm)");
		lblNewLabel_2.setBounds(10, 74, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Largo (cm)");
		lblNewLabel_3.setBounds(10, 105, 63, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Espesor (mm)");
		lblNewLabel_4.setBounds(10, 136, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contenido");
		lblNewLabel_5.setBounds(10, 236, 63, 14);
		contentPane.add(lblNewLabel_5);
		
		boxModelo = new JComboBox();
		boxModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		boxModelo.setBounds(97, 7, 168, 22);
		boxModelo.addActionListener(this);
		contentPane.add(boxModelo);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(97, 71, 168, 20);
		contentPane.add(txtAncho);
		txtAncho.setColumns(10);
		
		txtLargo = new JTextField();
		txtLargo.setBounds(97, 102, 168, 20);
		contentPane.add(txtLargo);
		txtLargo.setColumns(10);
		
		txtEspesor = new JTextField();
		txtEspesor.setBounds(97, 133, 168, 20);
		contentPane.add(txtEspesor);
		txtEspesor.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(275, 7, 103, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(275, 39, 103, 23);
		btnGrabar.addActionListener(this);
		contentPane.add(btnGrabar);
		
		JLabel lblNewLabel_6 = new JLabel("Contenido");
		lblNewLabel_6.setBounds(10, 167, 63, 14);
		contentPane.add(lblNewLabel_6);
		
		txtContenido = new JTextField();
		txtContenido.setBounds(97, 164, 168, 20);
		contentPane.add(txtContenido);
		txtContenido.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(97, 40, 168, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			btnGrabarActionPerformed(e);
		}
		if (e.getSource() == boxModelo) {
			boxModeloSelectIndex(e);
		}
		if (e.getSource() == btnCerrar) {
			btnCerrarActionPerformed(e);
		}
	}

	private void btnCerrarActionPerformed(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}

	private void boxModeloSelectIndex(ActionEvent e) {
		int modelo;
		modelo = getModelo();
		setSelectIndex(modelo);
	}


	private void btnGrabarActionPerformed(ActionEvent e) {
		int modelo;
		modelo = getModelo();
		getChangerResult(modelo);
	}
	
	int getModelo() {
		return boxModelo.getSelectedIndex();
	}
	
	//Metodo de cambios
	void getChangerResult(int model) {
		switch (model) {
		case 0:
			MenuPrincipal.precio0 = Double.parseDouble(txtPrecio.getText());
			MenuPrincipal.ancho0 = Double.parseDouble(txtAncho.getText());
			MenuPrincipal.largo0 = Double.parseDouble(txtLargo.getText());
			MenuPrincipal.espesor0 = Double.parseDouble(txtEspesor.getText());
			MenuPrincipal.contenido0 = Integer.parseInt(txtContenido.getText());
			break;
		case 1:
			MenuPrincipal.precio1 = Double.parseDouble(txtPrecio.getText());
			MenuPrincipal.ancho1 = Double.parseDouble(txtAncho.getText());
			MenuPrincipal.largo1 = Double.parseDouble(txtLargo.getText());
			MenuPrincipal.espesor1 = Double.parseDouble(txtEspesor.getText());
			MenuPrincipal.contenido1 = Integer.parseInt(txtContenido.getText());
			break;
		case 2:
			MenuPrincipal.precio2 = Double.parseDouble(txtPrecio.getText());
			MenuPrincipal.ancho2 = Double.parseDouble(txtAncho.getText());
			MenuPrincipal.largo2 = Double.parseDouble(txtLargo.getText());
			MenuPrincipal.espesor2 = Double.parseDouble(txtEspesor.getText());
			MenuPrincipal.contenido2 = Integer.parseInt(txtContenido.getText());
			break;
		case 3:
			MenuPrincipal.precio3 = Double.parseDouble(txtPrecio.getText());
			MenuPrincipal.ancho3 = Double.parseDouble(txtAncho.getText());
			MenuPrincipal.largo3 = Double.parseDouble(txtLargo.getText());
			MenuPrincipal.espesor3 = Double.parseDouble(txtEspesor.getText());
			MenuPrincipal.contenido3 = Integer.parseInt(txtContenido.getText());
			break;
		case 4:
			MenuPrincipal.precio4 = Double.parseDouble(txtPrecio.getText());
			MenuPrincipal.ancho4 = Double.parseDouble(txtAncho.getText());
			MenuPrincipal.largo4 = Double.parseDouble(txtLargo.getText());
			MenuPrincipal.espesor4 = Double.parseDouble(txtEspesor.getText());
			MenuPrincipal.contenido4 = Integer.parseInt(txtContenido.getText());
			break;
		}
		int opc = JOptionPane.showConfirmDialog(this, "Valores cambiados, deseas seguir?", "Mensaje de cambios", JOptionPane.YES_NO_OPTION);
		if (opc == 1) {
			dispose();
		}
	}
	
	//Metodo de seleccion -> muestra el resultado 
	void setSelectIndex(int model) {
		switch (model) {
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
