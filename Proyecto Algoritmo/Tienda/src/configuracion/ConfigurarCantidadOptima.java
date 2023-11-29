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
import java.awt.Color;

public class ConfigurarCantidadOptima extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantidades;
	private JButton btnAceptar;
	private JButton btnCerrar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarCantidadOptima frame = new ConfigurarCantidadOptima();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConfigurarCantidadOptima() {
		setBackground(new Color(0, 0, 0));
		setTitle("Configurar cantidad \u00F3ptima");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblNewLabel.setBounds(10, 11, 204, 14);
		contentPane.add(lblNewLabel);
		
		txtCantidades = new JTextField();
		txtCantidades.setBounds(216, 8, 68, 20);
		txtCantidades.setText(""+MenuPrincipal.cantidadOptima);
		contentPane.add(txtCantidades);
		txtCantidades.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(314, 7, 89, 23);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(314, 41, 89, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			btnCerrarActionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			btnAceptarActionPerformed(e);
		}
	}

	private void btnAceptarActionPerformed(ActionEvent e) {
		int cantidadOptima;
		cantidadOptima = getValorCantidadOptima();
		getCantidadOptima(cantidadOptima);
		
	}
	
	//Entrada de dato
	int getValorCantidadOptima() {
		return Integer.parseInt(txtCantidades.getText());
	}
	
	void getCantidadOptima(int cantidadOp) {
		if (cantidadOp == 0) {
			JOptionPane.showConfirmDialog(this, " El valor es nullo ", "Mensaje de error",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			txtCantidades.requestFocus();
			txtCantidades.selectAll();
		}
		else {
			JOptionPane.showConfirmDialog(this, " El Cambio se realizo de forma exitosa ", "Mensaje",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			MenuPrincipal.cantidadOptima = cantidadOp;
		}
		
	}

	private void btnCerrarActionPerformed(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}
}
