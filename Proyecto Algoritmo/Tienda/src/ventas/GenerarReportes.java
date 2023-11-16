package ventas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GenerarReportes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnCerrar;
	private JTextArea txtResultados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes frame = new GenerarReportes();
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
	public GenerarReportes() {
		setTitle("Generar Reportes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipos de reportes");
		lblNewLabel.setBounds(10, 15, 104, 14);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(124, 11, 315, 22);
		contentPane.add(comboBox);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(521, 11, 89, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 594, 200);
		contentPane.add(scrollPane);
		
		txtResultados = new JTextArea();
		scrollPane.setViewportView(txtResultados);
	}	
	
	public void actionPerformed(ActionEvent e) {
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

}
