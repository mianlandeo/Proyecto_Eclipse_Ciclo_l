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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Vender extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JTextArea txtResultado;
	private JComboBox boxModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Vender() {
		setTitle("Vender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 11, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(10, 36, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(10, 61, 59, 14);
		contentPane.add(lblNewLabel_2);
		
		boxModelo = new JComboBox();
		boxModelo.setBounds(77, 7, 180, 22);
		contentPane.add(boxModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(77, 33, 180, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(77, 58, 180, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(335, 7, 89, 23);
		btnVender.addActionListener(this);
		contentPane.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 57, 89, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 414, 164);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			btnGrabarActionPerformed(e);
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

	private void btnGrabarActionPerformed(ActionEvent e) {
		
		
	}
}
