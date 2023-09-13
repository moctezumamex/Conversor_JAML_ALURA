package mx.alura.conversor.modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversor_Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	public String valorIngresadoCaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor_Principal frame = new Conversor_Principal("");
					// conversor_Moneda_principal frame = new conversor_Moneda_principal();

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
	public Conversor_Principal(Object conversorPrincipal) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtValor = new JTextField();
		txtValor.setBounds(10, 62, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		/*-----------------------------------------------------------*/
		
		/** Caja valor Ingresado **/

		String valorIngresado = JOptionPane.showInputDialog("Ingrese el valor");

		try {
			while (valorIngresado.isEmpty() == true || Validador.ValidaNumeros(valorIngresado) == false) {
				JOptionPane.showMessageDialog(null, "Solo se aceptan números");
				valorIngresado = JOptionPane.showInputDialog("Ingrese el valor");
			}
			txtValor.setText(valorIngresado);
			valorIngresadoCaja = valorIngresado;
		} catch (NumberFormatException ex) {
		}

		String[] tipoconversorPrincipal = new String[0];
		String leyendaConversorPrincipal = "";
		Menu menuConversor = new Menu();
		
		/** Arreglos que contienen la información de los comboBox dependiendo de la opcion que se elija **/

		if (conversorPrincipal == "MONEDA") {
			tipoconversorPrincipal = new String[] { "Pesos MXN", "Dolar", "Yen", "Libra", "Euro" };
			leyendaConversorPrincipal = "la moneda de cambio";
		} else if (conversorPrincipal.toString().toUpperCase() == "TEMPERATURA") {
			tipoconversorPrincipal = new String[] { "Celsius", "Fahrenheit", "Kelvin" };
			leyendaConversorPrincipal = "la temperatura";
		} else if (conversorPrincipal.toString().toUpperCase() == "LONGITUD") {
			tipoconversorPrincipal = new String[] { "Milimetro", "Centimetro", "Metro", "Kilometro" };
			leyendaConversorPrincipal = "la longitud";
		}

		/* DECLARACION COMBO MONEDA PRINCIPAL */
		JComboBox<String> comboValorprincipal = new JComboBox<>();
		comboValorprincipal.setBounds(140, 61, 111, 21);

		/* DECLARACION COMBO MONEDA CAMBIO */
		JComboBox<String> comboValorCambio = new JComboBox<>();
		comboValorCambio.setBounds(299, 61, 111, 21);

		/* FOR que agrega las monedas del arreglo en la lista */
		for (String imoneda : tipoconversorPrincipal) {
			comboValorprincipal.addItem(imoneda);
			comboValorCambio.addItem(imoneda);
		}
		contentPane.add(comboValorprincipal);
		contentPane.add(comboValorCambio);

		/*-----------------------------------------------------------*/

		/* Inicia declaración de etiquetas */

		JLabel lblLeyenda = new JLabel("Ingrese el valor y seleccione " + leyendaConversorPrincipal);
		lblLeyenda.setBounds(10, 39, 367, 13);
		contentPane.add(lblLeyenda);

		JLabel lblDe = new JLabel("De");
		lblDe.setBounds(116, 65, 27, 13);
		contentPane.add(lblDe);

		JLabel lblA = new JLabel("A");
		lblA.setBounds(273, 65, 21, 13);
		contentPane.add(lblA);
		
		/* Termina declaración de etiquetas */

		/* Inicia Botón que convierte los valores */
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					/* Validador de conversores iguales */
					if (Validador.ValidaDatosIguales(comboValorprincipal.getSelectedItem().toString(),
							comboValorCambio.getSelectedItem().toString())) {

						String tipoCIngresado = "0";
						if (conversorPrincipal == "MONEDA") {
							/* Mensaje para agregar el tipo de cambio solo si es Moneda */
							tipoCIngresado = JOptionPane.showInputDialog("Ingrese el tipo de cambio");
							if (Validador.ValidaNumeros(tipoCIngresado) == false) {
								try {
									while (tipoCIngresado.isEmpty() == true) {
										tipoCIngresado = JOptionPane.showInputDialog("Ingrese el tipo de cambio");
									}
								} catch (NumberFormatException ex) {
								}
							} else {
								System.out.println("Solo se aceptan números");
							}

						}

						double valorSalida = 0;
						/* Se manda a llamar metodo de Calculo de conversion */
						CalculoConversor calculoconversor = new CalculoConversor();
						valorSalida = calculoconversor.calculaConversion(conversorPrincipal.toString(),
								comboValorprincipal.getSelectedItem().toString(),
								comboValorCambio.getSelectedItem().toString(), Double.valueOf(valorIngresadoCaja),
								Double.valueOf(tipoCIngresado));

						JOptionPane.showMessageDialog(null,
								valorSalida + " " + comboValorCambio.getSelectedItem().toString());

						int respuesta;
						respuesta = JOptionPane.showConfirmDialog(null, "Desea continuar?");

						if (respuesta == 0) {
							dispose();
							menuConversor.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Programa terminado");
							dispose();
						}

					} else {
						JOptionPane.showMessageDialog(null, "No se aceptan conversores iguales");

					}
				} catch (Exception ex) {

				}

			}
		});

		btnConvertir.setBounds(10, 155, 111, 21);
		contentPane.add(btnConvertir);
		
		/* Termina Botón que convierte los valores */

		/* Inicia botón de Menu principal */
		JButton btnMenuPrincipal = new JButton("Menú principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuConversor.setVisible(true);

			}
		});
		/* Termina botón de Menu principal */

		btnMenuPrincipal.setBounds(273, 10, 137, 21);
		contentPane.add(btnMenuPrincipal);

		txtValor = new JTextField();
		txtValor.setBounds(10, 62, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

	}
}
