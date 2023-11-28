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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class GenerarReportes extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox boxReportes;
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
		setBounds(100, 100, 627, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipos de reportes");
		lblNewLabel.setBounds(10, 15, 104, 14);
		contentPane.add(lblNewLabel);
		
		boxReportes = new JComboBox();
		boxReportes.addActionListener(this);
		boxReportes.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Comparaci\u00F3n de precios con el precio promedio", "Comparaci\u00F3n de cajas vendidas con la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
		boxReportes.setBounds(124, 11, 315, 22);
		contentPane.add(boxReportes);
		
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(521, 11, 89, 23);
		btnCerrar.addActionListener(this);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 594, 335);
		contentPane.add(scrollPane);
		
		txtResultados = new JTextArea();
		txtResultados.setEditable(false);
		txtResultados.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtResultados);
	}	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			btnCerrarActionPerformed(e);
		}
		if (e.getSource() == boxReportes) {
			boxReportesActionPerformed(e);
		}
	}

	private void boxReportesActionPerformed(ActionEvent e) {
		int modeloReport;
		modeloReport = SeleccionarReporte();
		getReportes(modeloReport);
	}
	
	//Obtiene los reportes
	void getReportes(int model) {
		switch (model) {
		case 0:
			txtResultados.setText("========================== VENTAS POR MODELO ==========================" +  "\n");
			txtResultados.append("\n");
			mostrarResultado0(MenuPrincipal.modelo0, Vender.cantidadVendidas0, Vender.cajaVendida0, Vender.importCompraTotal0, Vender.cantidadPorcentaje0);
			mostrarResultado0(MenuPrincipal.modelo1, Vender.cantidadVendidas1, Vender.cajaVendida1, Vender.importCompraTotal1, Vender.cantidadPorcentaje1);
			mostrarResultado0(MenuPrincipal.modelo2, Vender.cantidadVendidas2, Vender.cajaVendida2, Vender.importCompraTotal2, Vender.cantidadPorcentaje2);
			mostrarResultado0(MenuPrincipal.modelo3, Vender.cantidadVendidas3, Vender.cajaVendida3, Vender.importCompraTotal3, Vender.cantidadPorcentaje3);
			mostrarResultado0(MenuPrincipal.modelo4, Vender.cantidadVendidas4, Vender.cajaVendida4, Vender.importCompraTotal4, Vender.cantidadPorcentaje4);
			break;
		case 1:
			txtResultados.setText("============ COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO ============" +  "\n");
			txtResultados.append("\n");
			mostrarResultado1(MenuPrincipal.modelo0, MenuPrincipal.precio0);
			mostrarResultado1(MenuPrincipal.modelo1, MenuPrincipal.precio1);
			mostrarResultado1(MenuPrincipal.modelo2, MenuPrincipal.precio2);
			mostrarResultado1(MenuPrincipal.modelo3, MenuPrincipal.precio3);
			mostrarResultado1(MenuPrincipal.modelo4, MenuPrincipal.precio4);
			break;
		case 2:
			txtResultados.setText("========= COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA =========" +  "\n");
			txtResultados.append("\n");
			mostrarResultado2(MenuPrincipal.modelo0, Vender.cajaVendida0, MenuPrincipal.cantidadOptima);
			mostrarResultado2(MenuPrincipal.modelo1, Vender.cajaVendida1, MenuPrincipal.cantidadOptima);
			mostrarResultado2(MenuPrincipal.modelo2, Vender.cajaVendida2, MenuPrincipal.cantidadOptima);
			mostrarResultado2(MenuPrincipal.modelo3, Vender.cajaVendida3, MenuPrincipal.cantidadOptima);
			mostrarResultado2(MenuPrincipal.modelo4, Vender.cajaVendida4, MenuPrincipal.cantidadOptima);
			break;
		case 3:
			txtResultados.setText("============= ESTADÍSTICA SOBRE EL PRECIO =============" +  "\n");
			txtResultados.append("\n");
			mostrarResultados3();
			break;
		}
	}
	
	//Reporte venta por modelo
	void mostrarResultado0(String model, int cnVentas, int cnCajasVendidas, double importCompra, double porcentajeCuotaDiaria) {
		imprimir("modelo\t\t\t\t : " + model);
		imprimir("Cantidad de ventas\t\t : " + cnVentas);
		imprimir("Cantidad de cajas vendidas\t : " + cnCajasVendidas);
		imprimir("Importe total vendido\t\t : S/." + String.format("%1.2f", importCompra));
		imprimir("Aporte a la cuota diaria\t : " + String.format("%1.2f", porcentajeCuotaDiaria) + "%" + "\n");
	}
	
	//reporte comparación precio con precio promedio
	void mostrarResultado1(String model, double precio) {
		double sumarPrecio, precioPromedio, preciorestante;
		String msmPrecio = "";
		//Sumamos los precio y lo divimos
		sumarPrecio = MenuPrincipal.precio0 + MenuPrincipal.precio1 + MenuPrincipal.precio2 + MenuPrincipal.precio3 + MenuPrincipal.precio4;  
		precioPromedio = sumarPrecio / 5;
		//si el precio es mayor al promedio restara precio con el promedio
		//si el promedio es mayor restara primero el primedio y luego el precio
		if (precio > precioPromedio) {
			preciorestante = precio - precioPromedio;
		} else {
			preciorestante = precioPromedio - precio;
		}
		//Mensaje mayor y menos al promedio
		if (precio > precioPromedio) {
			msmPrecio = "mas que el promedio";
		} else {
			msmPrecio = "menos que el promedio";
		}
		imprimir("Modelo\t\t : " + model);
		imprimir("Precio\t\t : " + String.format("%1.2f", precio));
		imprimir("Precio promedio  : " + String.format("%1.2f", precioPromedio));
		imprimir("Comparación\t : " + String.format("%1.2f", preciorestante) + " " + msmPrecio + "\n");
	}
	
	//Reporte cajas vendidas con la cantidad optima
	void mostrarResultado2(String model, int cnCajasVendidas, int cnOptima) {
		int cnComparacion; 
		String comparacion = "";
		//Renta la cantidad de optima con la cantidad de cajas adquiridas
		if (cnOptima > cnCajasVendidas) {
			cnComparacion = cnOptima - cnCajasVendidas;
		} else {
			cnComparacion = cnCajasVendidas - cnOptima;	
		}
		//Mensaje -> igual - mas - menos
		if(cnCajasVendidas == cnOptima) {
			comparacion = cnComparacion + " " + "igual que la cantidad optima";
		} else if (cnCajasVendidas < cnOptima) {
			comparacion = cnComparacion + " " + "mas que la cantidad optima";
		} else {
			comparacion = cnComparacion + " " + "menos que la cantidad optima";
		}
		
		imprimir("Modelo\t\t\t\t: " + model);
		imprimir("Cantidad de cajas vendidas\t: " + cnCajasVendidas);
		imprimir("Cantidad optima\t\t\t: " + cnOptima);
		imprimir("Comparación\t\t\t: " + comparacion + "\n");
	}
	
	//Reporte estadisticas de precios
	void mostrarResultados3() {
		double precioPromedio, precioMayor, precioMenor, sumarPrecio;
		
		sumarPrecio = MenuPrincipal.precio0 + MenuPrincipal.precio1 + MenuPrincipal.precio2 + MenuPrincipal.precio3 + MenuPrincipal.precio4;
		precioPromedio = sumarPrecio / 5;
		
		//Precio mayor
		if (MenuPrincipal.precio0 > MenuPrincipal.precio1 && MenuPrincipal.precio0 > MenuPrincipal.precio2 && 
				MenuPrincipal.precio0 > MenuPrincipal.precio3 && MenuPrincipal.precio0 > MenuPrincipal.precio4) {
			precioMayor = MenuPrincipal.precio0;
		} else if (MenuPrincipal.precio1 > MenuPrincipal.precio2 && MenuPrincipal.precio1 > MenuPrincipal.precio3 && 
				MenuPrincipal.precio1 > MenuPrincipal.precio4) {
			precioMayor = MenuPrincipal.precio1;
		} else if (MenuPrincipal.precio2 > MenuPrincipal.precio3 && MenuPrincipal.precio2 > MenuPrincipal.precio4) {
			precioMayor = MenuPrincipal.precio2;
		} else if (MenuPrincipal.precio3 > MenuPrincipal.precio4) {
			precioMayor = MenuPrincipal.precio3;
		} else {
			precioMayor = MenuPrincipal.precio4;
		}
		
		//Precio Menor
		if (MenuPrincipal.precio0 < MenuPrincipal.precio1 && MenuPrincipal.precio0 < MenuPrincipal.precio2 && 
				MenuPrincipal.precio0 < MenuPrincipal.precio3 && MenuPrincipal.precio0 < MenuPrincipal.precio4) {
			precioMenor = MenuPrincipal.precio0;
		} else if (MenuPrincipal.precio1 < MenuPrincipal.precio2 && MenuPrincipal.precio1 < MenuPrincipal.precio3 && 
				MenuPrincipal.precio1 < MenuPrincipal.precio4) {
			precioMenor = MenuPrincipal.precio1;
		} else if (MenuPrincipal.precio2 < MenuPrincipal.precio3 && MenuPrincipal.precio2 < MenuPrincipal.precio4) {
			precioMenor = MenuPrincipal.precio2;
		} else if (MenuPrincipal.precio3 < MenuPrincipal.precio4) {
			precioMenor = MenuPrincipal.precio3;
		} else {
			precioMenor = MenuPrincipal.precio4;
		}
		imprimir("Precio promedio\t : S/. " + String.format("%1.2f", precioPromedio));
		imprimir("Precio mayor\t : S/. " + String.format("%1.2f", precioMayor));
		imprimir("Precio menor\t : S/. " + String.format("%1.2f", precioMenor) + "\n");
	}
	
	int SeleccionarReporte() {
		return boxReportes.getSelectedIndex();
	}
	
	void imprimir(String valor) {
		txtResultados.append(valor + "\n");
	}

	private void btnCerrarActionPerformed(ActionEvent e) {
		int opc = JOptionPane.showConfirmDialog(this, "Desea Terminar?", "Conformar", JOptionPane.YES_NO_OPTION);
		if (opc == 0) {
			dispose();
		}
	}

}
