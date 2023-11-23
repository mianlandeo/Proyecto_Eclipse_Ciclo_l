package ventas;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Vender extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JComboBox boxModelo;
	private JTextArea txtResultado;

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
		setBounds(100, 100, 459, 314);
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
		boxModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		boxModelo.setBounds(77, 7, 180, 22);
		boxModelo.addActionListener(this);
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
		btnVender.setBounds(344, 7, 89, 23);
		btnVender.addActionListener(this);
		contentPane.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(344, 57, 89, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 423, 178);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
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
		setResult();
		
	}

	private void btnGrabarActionPerformed(ActionEvent e) {
		int cantidad;
		int modelo;
		double totalPorcentaje;
		double totalCompra;
		double totalPagar;
		String mostrarModelo;
		double mostrarPrecio;
		int mostrarObsequio;

		cantidad = getCantidad();
		modelo = getModelo();
		totalCompra = getImportCompra(modelo, cantidad);
		totalPorcentaje = getimportDescuento(cantidad, totalCompra);
		totalPagar = totalCompra - totalPorcentaje;
		mostrarModelo = getModelResult(modelo);
		mostrarPrecio = getsaleResult(modelo);
		mostrarObsequio = getGift(cantidad);
		
		getResult(totalPorcentaje, totalCompra, totalPagar, mostrarModelo, mostrarPrecio, cantidad, mostrarObsequio);
	}
	
	int getModelo() {
		return boxModelo.getSelectedIndex(); 
	}
	
	int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	//Metodo resultado
	void getResult(double porcentaje, double totalCompra, double totalPagar, 
			String salidaModelo, double salidaPrecio, int mostrarCantidad, int salidaObsequio) {
		txtResultado.setText("");
		printResult("=================BOLETA DE VENTA=================");
		printResult("");
		printResult("Modelo\t \t : "  + salidaModelo);
		printResult("Precio\t \t : " + "S./ " +  salidaPrecio);
		printResult("Cantidad adquirida \t: "  + mostrarCantidad);
		printResult("Importe de compra \t: " + "S/. " + totalCompra);
		printResult("Importe de descuento \t:" + " S/. " + String.format("%1.2f", porcentaje));
		printResult("Importe a pagar \t: " + "S/. " + String.format("%1.2f", totalPagar));
		printResult("Tipo de obsequio \t: " + MenuPrincipal.tipoObsequio);
		printResult("Unidades obsequiadas \t: " + salidaObsequio);
		
	}
	
	//Mostrar marca del producto
	String getModelResult(int model) {
		String modelSelect = "";
		switch (model) {
		case 0:
			modelSelect = MenuPrincipal.modelo0;
			break;
		case 1:
			modelSelect = MenuPrincipal.modelo1;			
			break;
		case 2:
			modelSelect = MenuPrincipal.modelo2;
			break;
		case 3:
			modelSelect = MenuPrincipal.modelo3;
			break;
		case 4:
			modelSelect = MenuPrincipal.modelo4;
			break;
		}
		return modelSelect;
	}
	//Mostrar precio del producto
	double getsaleResult(int model) {
		double sale = 0;
		switch (model) {
		case 0:
			sale = MenuPrincipal.precio0;
			break;
		case 1:
			sale = MenuPrincipal.precio1;			
			break;
		case 2:
			sale = MenuPrincipal.precio2;
			break;
		case 3:
			sale = MenuPrincipal.precio3;
			break;
		case 4:
			sale = MenuPrincipal.precio4;
			break;
		}
		return sale;
	}

	
	//Logica del importe de compra
	double getImportCompra(int model, int cantidad) {
			double imprtCompra = 0;
			switch (model) {
			case 0:
				imprtCompra = MenuPrincipal.precio0 * cantidad;
				break;
			case 1:
				imprtCompra = MenuPrincipal.precio0 * cantidad;
				break;
			case 2:
				imprtCompra = MenuPrincipal.precio0 * cantidad;
				break;
			case 3:
				imprtCompra = MenuPrincipal.precio0 * cantidad;;
				break;
			case 4:
				imprtCompra = MenuPrincipal.precio0 * cantidad;
				break;
				}
			return imprtCompra;
	}
	
	//Logica del descuento
	double getimportDescuento(int model, double importCompra) {
		if (model >= 1 && model < 5) {
			return importCompra * MenuPrincipal.porcentaje1;
		} else if (model > 6 && model < 10) {
			return importCompra * MenuPrincipal.porcentaje2;
		} else if (model > 11 && model < 15) {
			return importCompra * MenuPrincipal.porcentaje3;
		} else {
			return importCompra * MenuPrincipal.porcentaje4;
		}
	}
	
	int getGift(int cantidad) {
		if (cantidad > 1 && cantidad <= 5) {
			return MenuPrincipal.obsequioCantidad1;
		} else if (cantidad > 6 && cantidad <= 10) {
			return MenuPrincipal.obsequioCantidad2;
		} else {
			return MenuPrincipal.obsequioCantidad3;
		}
	}
	
	//==========================================================================================
	
	void printResult(String cad) {
		txtResultado.append(cad + "\n");
	}
	
	//Metodo de cambios
	void setResult() {
	switch (boxModelo.getSelectedIndex()) {
	case 0:
		txtPrecio.setText(""+MenuPrincipal.precio0);
		break;
	case 1:
		txtPrecio.setText(""+MenuPrincipal.precio1);		
		break;
	case 2:
		txtPrecio.setText(""+MenuPrincipal.precio2);
		break;
	case 3:
		txtPrecio.setText(""+MenuPrincipal.precio3);
	case 4:
		txtPrecio.setText(""+MenuPrincipal.precio4);
		break;
		}
	}
}
