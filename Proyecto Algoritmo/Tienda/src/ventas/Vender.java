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

public class Vender extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JComboBox boxModelo;
	private JTextArea txtResultado;


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
	
	//Variables Globales
	//Incremento vendidas
	public static int cantidadVendidas0 = 0, cantidadVendidas1, cantidadVendidas2, cantidadVendidas3, cantidadVendidas4, cantidadVentasGanadas;
	//Incremento de cajas vendidas
	public static int cajaVendida0 = 0, cajaVendida1, cajaVendida2, cajaVendida3, cajaVendida4;
	//Incremento total del importe de compra
	public static double importCompraTotal0 = 0, importCompraTotal1, importCompraTotal2, importCompraTotal3, importCompraTotal4, cantidadImportVenta;
	//Incremento de porcentaje
	public static double cantidadPorcentaje0 = 0, cantidadPorcentaje1, cantidadPorcentaje2, cantidadPorcentaje3, cantidadPorcentaje4, cantidadPorcentajeAcumulado;
	
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
		mostrarModelo = getModelResult(modelo);
		mostrarPrecio = getsaleResult(modelo);
		totalCompra = getImportCompra(modelo, cantidad); //Total de la compra
		totalPorcentaje = getimportDescuento(cantidad, totalCompra); //Descuento por el total de la compra
		totalPagar = getImporPagar(totalCompra, totalPorcentaje); //Total a pagar
		mostrarObsequio = getGift(cantidad); // Cantidad de obsequio a entregar por la cantidad del producto adquirido
		getIncremento(modelo, totalPagar, cantidad); 
		getContadorVentas();
		getMensajeVentas();
		
		//Salida
		getResult(totalPorcentaje, totalCompra, totalPagar, mostrarModelo, mostrarPrecio, cantidad, mostrarObsequio);
	}
	
	//Entrada
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
		printResult("Modelo\t \t: "  + salidaModelo);
		printResult("Precio\t \t: " + "S./ " +  salidaPrecio);
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
				imprtCompra = MenuPrincipal.precio0 * cantidad;
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
			return (MenuPrincipal.porcentaje1 / 100) * importCompra;
		} else if (model > 6 && model < 10) {
			return (MenuPrincipal.porcentaje2 / 100) * importCompra;
		} else if (model > 11 && model < 15) {
			return (MenuPrincipal.porcentaje3 / 100) * importCompra;
		} else {
			return (MenuPrincipal.porcentaje4 / 100) * importCompra;
		}
	}

	//Logica a pagar
	double getImporPagar(double iCompra, double iDescuento){
		return iCompra - iDescuento;
	}
	
	//Logica de obsequios
	int getGift(int cantidad) {
		if (cantidad > 1 && cantidad <= 5) {
			return MenuPrincipal.obsequioCantidad1;
		} else if (cantidad > 6 && cantidad <= 10) {
			return MenuPrincipal.obsequioCantidad2;
		} else {
			return MenuPrincipal.obsequioCantidad3;
		}
	}
	
	//Se suma el incremento del producto
	void getIncremento(int model, double importPagar, int can) {
		switch (model) {
		case 0:
			cantidadVendidas0++;
			importCompraTotal0 += importPagar;
			cantidadPorcentaje0 = (importCompraTotal0 * 100) / MenuPrincipal.cuotaDiaria;
			cajaVendida0 += can;
			break;
		case 1:
			cantidadVendidas1++;
			importCompraTotal1 += importPagar;
			cantidadPorcentaje1 = (importCompraTotal1 * 100) / MenuPrincipal.cuotaDiaria;
			cajaVendida1 += can;			
			break;
		case 2:
			cantidadVendidas2++;
			importCompraTotal2 += importPagar;
			cantidadPorcentaje2 = (importCompraTotal2 * 100) / MenuPrincipal.cuotaDiaria;
			cajaVendida2 += can;
			break;
		case 3:
			cantidadVendidas3++;
			importCompraTotal3 += importPagar;
			cantidadPorcentaje3 = (importCompraTotal3 * 100) / MenuPrincipal.cuotaDiaria;
			cajaVendida3 += can;
			break;
		case 4:
			cantidadVendidas4++;
			importCompraTotal4 += importPagar;
			cantidadPorcentaje4 = (importCompraTotal4 * 100) / MenuPrincipal.cuotaDiaria;
			cajaVendida4 += can;
			break;
			}
	}
	
	//Acumula cantidad, importe de venta y porcentaje divido por la cuota diaria
	void getContadorVentas() {
		cantidadVentasGanadas = cantidadVendidas0 + cantidadVendidas1 + cantidadVendidas2 + cantidadVendidas3 + cantidadVendidas4;
		cantidadImportVenta = importCompraTotal0 + importCompraTotal1 + importCompraTotal2 + importCompraTotal3 + importCompraTotal4;
		cantidadPorcentajeAcumulado = (cantidadImportVenta * 100) / MenuPrincipal.cuotaDiaria;
	}
	
	//El mensaje se ejecuta al llegar a las 5 ventas
	private void getMensajeVentas() {
		if (cantidadVentasGanadas%5 == 0) {
			JOptionPane.showConfirmDialog(this, "Ventas Nro. " + cantidadVentasGanadas + "\n" +
			"Importe total general acumulado : S/. " + String.format("%1.2f", cantidadImportVenta) + "\n" + 
			"Porcentaje de las cuotas diarias : %" + String.format("%1.2f", cantidadPorcentajeAcumulado), 
			"Avance de ventas", JOptionPane.OK_OPTION ,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	void printResult(String cad) {
		txtResultado.append(cad + "\n");
	}
	
	//Mostrar precio en el inicio
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
		break;
	case 4:
		txtPrecio.setText(""+MenuPrincipal.precio4);
		break;
		}
	}
}
