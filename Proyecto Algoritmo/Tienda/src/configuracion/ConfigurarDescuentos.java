package configuracion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigurarDescuentos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtMas_Quince;
	private JTextField txtOnce_quince;
	private JTextField txtSeis_Diez;
	private JTextField txtUna_cinco;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnAceptar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuentos frame = new ConfigurarDescuentos();
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
	public ConfigurarDescuentos() {
		setTitle("Configurar porcentaje de descuento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(10, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("6 a 10 unidades");
		lblNewLabel_1.setBounds(10, 36, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("11 a 15 unidades");
		lblNewLabel_2.setBounds(10, 61, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("mas de 15 unidades");
		lblNewLabel_3.setBounds(10, 86, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txtMas_Quince = new JTextField();
		txtMas_Quince.setBounds(116, 83, 136, 20);
		txtMas_Quince.setText(MenuPrincipal.porcentaje4+"");
		contentPane.add(txtMas_Quince);
		txtMas_Quince.setColumns(10);
		
		txtOnce_quince = new JTextField();
		txtOnce_quince.setBounds(116, 58, 136, 20);
		txtOnce_quince.setText(MenuPrincipal.porcentaje3+"");
		contentPane.add(txtOnce_quince);
		txtOnce_quince.setColumns(10);
		
		txtSeis_Diez = new JTextField();
		txtSeis_Diez.setBounds(116, 33, 136, 20);
		txtSeis_Diez.setText(MenuPrincipal.porcentaje2+"");
		contentPane.add(txtSeis_Diez);
		txtSeis_Diez.setColumns(10);
		
		txtUna_cinco = new JTextField();
		txtUna_cinco.setBounds(116, 8, 136, 20);
		txtUna_cinco.setText(MenuPrincipal.porcentaje1+"");
		contentPane.add(txtUna_cinco);
		txtUna_cinco.setColumns(10);
		
		lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setBounds(262, 11, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setBounds(262, 36, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("%");
		lblNewLabel_6.setBounds(262, 61, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("%");
		lblNewLabel_7.setBounds(262, 86, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(335, 8, 89, 23);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 36, 89, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			btnCancelarActionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			btnAceptarActionPerformed(e);
		}
	}
	


	private void btnAceptarActionPerformed(ActionEvent e) {
		double porcentajeUno, porcentajeDos, porcentajeTres, porcentajeCuatro;
		
		porcentajeUno = getporcentajeUno();
		porcentajeDos = getporcentajeDos();
		porcentajeTres = getporcentajeTres();
		porcentajeCuatro = getporcentajeCuatro();
	
		getporcentaje0(porcentajeUno, porcentajeDos, porcentajeTres, porcentajeCuatro);
	}
	
	void getporcentaje0(double por1, double por2, double por3, double por4) {
		//S� la cantidad es 0, el valor almacenado sera anulado y se mostrara un mensaje 
		if (por1 == 0) {
			JOptionPane.showConfirmDialog(this, " La cantidad debe ser mayor a 0 ", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtUna_cinco.requestFocus();
			txtUna_cinco.selectAll();
			
		} else if (por2 == 0) {
			JOptionPane.showConfirmDialog(this, " La cantidad debe ser mayor a 0 ", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtSeis_Diez.requestFocus();
			txtSeis_Diez.selectAll();
		} else if (por3 == 0) {
			JOptionPane.showConfirmDialog(this, " La cantidad debe ser mayor a 0 ", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtOnce_quince.requestFocus();
			txtOnce_quince.selectAll();
		} else if (por4 == 0) {
			JOptionPane.showConfirmDialog(this, " La cantidad debe ser mayor a 0 ", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtMas_Quince.requestFocus();
			txtMas_Quince.selectAll();
		}
		//S� es valor es mayor a 0 entonces se guardara dicho valor y se mostrara un mensaje de cambio exitoso
		else {
			JOptionPane.showConfirmDialog(this, " La cantidad se cambio exitosamente ", "Mensaje de aviso",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			MenuPrincipal.porcentaje1 = por1;
			MenuPrincipal.porcentaje2 = por2;
			MenuPrincipal.porcentaje3 = por3;
			MenuPrincipal.porcentaje4 = por4;
			dispose();
			
		}
		
	}
	
	double getporcentajeUno() {
		return Double.parseDouble(txtUna_cinco.getText());
	}
	
	double getporcentajeDos() {
		return Double.parseDouble(txtSeis_Diez.getText());
	}
	
	double getporcentajeTres() {
		return Double.parseDouble(txtOnce_quince.getText());
	}
	
	double getporcentajeCuatro() {
		return Double.parseDouble(txtMas_Quince.getText());
	}

	private void btnCancelarActionPerformed(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}
}
