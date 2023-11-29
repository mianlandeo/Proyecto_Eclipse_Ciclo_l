package configuracion;

import java.awt.EventQueue;
import java.awt.Font;
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

public class ConfigurarObsequios extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtOnce_mas;
	private JTextField txtseis_diez;
	private JTextField txtUno_cinco;
	private JTextField txtObsequio;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarObsequios frame = new ConfigurarObsequios();
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
	public ConfigurarObsequios() {
		setTitle("Configurar Obsequio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de obsequio");
		lblNewLabel.setBounds(10, 11, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1 a 5 unidades");
		lblNewLabel_1.setBounds(10, 36, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("6 a 10 unidades");
		lblNewLabel_2.setBounds(10, 61, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("11 a mas unidades");
		lblNewLabel_3.setBounds(10, 86, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		txtOnce_mas = new JTextField();
		txtOnce_mas.setBounds(110, 83, 99, 20);
		txtOnce_mas.setText(MenuPrincipal.obsequioCantidad3+"");
		contentPane.add(txtOnce_mas);
		txtOnce_mas.setColumns(10);
		
		txtseis_diez = new JTextField();
		txtseis_diez.setBounds(110, 58, 99, 20);
		txtseis_diez.setText(MenuPrincipal.obsequioCantidad2+"");
		contentPane.add(txtseis_diez);
		txtseis_diez.setColumns(10);
		
		txtUno_cinco = new JTextField();
		txtUno_cinco.setBounds(110, 33, 99, 20);
		txtUno_cinco.setText(MenuPrincipal.obsequioCantidad1+"");
		contentPane.add(txtUno_cinco);
		txtUno_cinco.setColumns(10);
		
		txtObsequio = new JTextField();
		txtObsequio.setBounds(110, 8, 99, 20);
		txtObsequio.setText(""+MenuPrincipal.tipoObsequio+"");
		contentPane.add(txtObsequio);
		txtObsequio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(263, 7, 89, 23);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(263, 36, 89, 23);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			btnCancelarActionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			btnAceptarActionPerformed(e);
		}
	}

	private void btnAceptarActionPerformed(ActionEvent e) {
		int unidadUnoCinco, unidadSeisDiez, unidadMasOnce;
		String nombreObsequio = "";
		
		unidadUnoCinco = getCantidadObsequio1();
		unidadSeisDiez = getCantidadObsequio2();
		unidadMasOnce = getCantidadObsequio3();
		nombreObsequio = getObsequio();
		
		verificacionValores(nombreObsequio ,unidadUnoCinco, unidadSeisDiez, unidadMasOnce);
	}
	
	//Si el valor es 0 mandara un mensaje de error
	void verificacionValores(String obsequio, int unidadUC, int unidadSD, int unidadMasO) {
		//Si el resultado es 0 dara un mensaje de error 
		if (obsequio.length() == 0) {
			JOptionPane.showConfirmDialog(this, "Sin valor, por favor coloca el tipo de obsequio que se dara", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtObsequio.requestFocus();
			txtObsequio.selectAll();
		} else if (unidadUC == 0) {
			JOptionPane.showConfirmDialog(this, "Sin valor, por favor coloca el tipo de obsequio que se dara", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtObsequio.requestFocus();
			txtObsequio.selectAll();
		} else if (unidadSD == 0) {
			JOptionPane.showConfirmDialog(this, "Sin valor, por favor coloca el tipo de obsequio que se dara", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtObsequio.requestFocus();
			txtObsequio.selectAll();
		} else if (unidadMasO == 0) {
			JOptionPane.showConfirmDialog(this, "Sin valor, por favor coloca el tipo de obsequio que se dara", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtObsequio.requestFocus();
			txtObsequio.selectAll();
		} else {
			//Si el resultado es mayor a 1 el resultado se guardara 
			JOptionPane.showConfirmDialog(this, "Los valores se cambiaron",
	                "MENSAJE DE AVISO", JOptionPane.CLOSED_OPTION,
	                JOptionPane.INFORMATION_MESSAGE);
			MenuPrincipal.tipoObsequio = txtObsequio.getText();
			MenuPrincipal.obsequioCantidad1 = Integer.parseInt(txtUno_cinco.getText());
			MenuPrincipal.obsequioCantidad2 = Integer.parseInt(txtseis_diez.getText());
			MenuPrincipal.obsequioCantidad3 = Integer.parseInt(txtOnce_mas.getText());
			dispose();
		}
	}
	
	//Entrada de valores entero y una cadena
	String getObsequio() {
		return txtObsequio.getText();
	}
	
	//Entrada de dato
	int getCantidadObsequio1() {
		return Integer.parseInt(txtUno_cinco.getText());
	}

	//Entrada de dato
	int getCantidadObsequio2() {
		return Integer.parseInt(txtseis_diez.getText());		
	}
	
	//Entrada de dato
	int getCantidadObsequio3() {
		return Integer.parseInt(txtOnce_mas.getText());
	}
	
	private void btnCancelarActionPerformed(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}
}
