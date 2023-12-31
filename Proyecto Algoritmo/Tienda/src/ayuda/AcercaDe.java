package ayuda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class AcercaDe extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe frame = new AcercaDe();
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
	public AcercaDe() {
		setTitle("Acerca de.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTienda = new JLabel("  Tienda de ceramicas");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienda.setForeground(Color.BLACK);
		lblTienda.setBounds(135, 0, 157, 49);
		contentPane.add(lblTienda);
		
		JLabel lblA�o = new JLabel("2023");
		lblA�o.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblA�o.setBounds(205, 162, 28, 25);
		contentPane.add(lblA�o);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(176, 188, 89, 23);
		contentPane.add(btnCerrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 414, 2);
		contentPane.add(separator);
		
		JLabel lblAutores = new JLabel("Autores");
		lblAutores.setForeground(Color.BLACK);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(184, 44, 55, 39);
		contentPane.add(lblAutores);
		
		JLabel lblNewLabel = new JLabel("Michel Torres Landeo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(156, 94, 128, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Emilio Cabrera");
		lblNewLabel_1.setBounds(184, 119, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Palacios Mediomundo Keiber Antonio");
		lblNewLabel_2.setBounds(135, 144, 174, 14);
		contentPane.add(lblNewLabel_2);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
		protected void actionPerformedBtnCerrar(ActionEvent e) {
			dispose();
		}
}
