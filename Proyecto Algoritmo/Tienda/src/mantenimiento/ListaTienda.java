package mantenimiento;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import app.MenuPrincipal;

public class ListaTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = -3450133481530019653L;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaTienda dialog = new ListaTienda();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ListaTienda() {
		setTitle("Listar");
		setResizable(false);
		setBounds(100, 100, 460, 310);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 212);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);

		panel = new JPanel();
		panel.setBounds(128, 238, 188, 23);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(99, 0, 89, 23);
		panel.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(0, 0, 89, 23);
		panel.add(btnListar);
		btnCerrar.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		getResult();
	}
	
	void getResult() {
		imprimir("Listado de Ceramicos");
		imprimir("Modelo\t:" + MenuPrincipal.modelo0);
		imprimir("Precio\t: " + MenuPrincipal.precio0);
		imprimir("Ancho\t: " + MenuPrincipal.ancho0);
		imprimir("Largo\t: " + MenuPrincipal.largo0);
		imprimir("Espesor\t: " + MenuPrincipal.espesor0);
		imprimir("Contenido:"+ MenuPrincipal.contenido0);
		imprimir("");
		imprimir("Modelo\t:" + MenuPrincipal.modelo1);
		imprimir("Precio\t: " + MenuPrincipal.precio1);
		imprimir("Ancho\t: " + MenuPrincipal.ancho1);
		imprimir("Largo\t: " + MenuPrincipal.largo1);
		imprimir("Espesor\t: " + MenuPrincipal.espesor1);
		imprimir("Contenido: "+ MenuPrincipal.contenido1);
		imprimir("");
		imprimir("Modelo\t:" + MenuPrincipal.modelo2);
		imprimir("Precio\t: " + MenuPrincipal.precio2);
		imprimir("Ancho\t: " + MenuPrincipal.ancho2);
		imprimir("Largo\t: " + MenuPrincipal.largo2);
		imprimir("Espesor\t: " + MenuPrincipal.espesor2);
		imprimir("Contenido: "+ MenuPrincipal.contenido2);
		imprimir("");
		imprimir("Modelo\t:" + MenuPrincipal.modelo3);
		imprimir("Precio\t: " + MenuPrincipal.precio3);
		imprimir("Ancho\t: " + MenuPrincipal.ancho3);
		imprimir("Largo\t: " + MenuPrincipal.largo3);
		imprimir("Espesor\t: " + MenuPrincipal.espesor3);
		imprimir("Contenido: "+ MenuPrincipal.contenido3);
		imprimir("");
		imprimir("Modelo\t:" + MenuPrincipal.modelo4);
		imprimir("Precio\t: " + MenuPrincipal.precio4);
		imprimir("Ancho\t: " + MenuPrincipal.ancho4);
		imprimir("Largo\t: " + MenuPrincipal.largo4);
		imprimir("Espesor\t: " + MenuPrincipal.espesor4);
		imprimir("Contenido: "+ MenuPrincipal.contenido4);
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}

