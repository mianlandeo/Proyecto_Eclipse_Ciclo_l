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

public class ConfigurarCuotaDiaria extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCuotaDiaria frame = new ConfigurarCuotaDiaria();
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
	public ConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(10, 11, 151, 14);
		contentPane.add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(171, 8, 131, 20);
		txtCantidad.setText(""+MenuPrincipal.cuotaDiaria);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(335, 7, 89, 23);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 41, 89, 23);
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
		double cuotasDiarias;
		cuotasDiarias =	getCambioCuotaDiaria();
		getCuotasDiarias(cuotasDiarias);
	}
	
	
	void getCuotasDiarias(double cantidadOp) {
		//Si el resultado es 0 el usuario recibira un mensaje de error
		if (cantidadOp == 0) {
			JOptionPane.showConfirmDialog(this, " El valor es nullo ", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtCantidad.requestFocus();
			txtCantidad.selectAll();
		}
		else {
			JOptionPane.showConfirmDialog(this, " Cambio exitoso ", "Mensaje",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			MenuPrincipal.cuotaDiaria = cantidadOp;
			dispose();
		}
	}
	
	//Entrada de dato / Guarda el tipo de dato que se agrego
	double getCambioCuotaDiaria() {
		return MenuPrincipal.cuotaDiaria = Double.parseDouble(txtCantidad.getText());
	}
	

	private void btnCancelarActionPerformed(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}
}
