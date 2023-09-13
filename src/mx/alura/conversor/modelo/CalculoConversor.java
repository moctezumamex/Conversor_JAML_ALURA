package mx.alura.conversor.modelo;

import javax.swing.JOptionPane;

public class CalculoConversor {

	public double calculaConversion(String conversorPrincipal, String valorConversorPrincipal,
			String valorConversorCambio, double valorIngresadoPrincipal, double tipoCPrincipal) {

		double conversorCambio = 0;

		if (conversorPrincipal == "MONEDA") {
			conversorCambio = (valorIngresadoPrincipal * tipoCPrincipal);

		} else if (conversorPrincipal == "TEMPERATURA") {
			if (valorConversorPrincipal == "Celsius") {
				if (valorConversorCambio == "Fahrenheit") {
					conversorCambio = (valorIngresadoPrincipal * 9 / 5) + 32;
				}
				if (valorConversorCambio == "Kelvin") {
					conversorCambio = (valorIngresadoPrincipal + 273.15);
				}
			}

			if (valorConversorPrincipal == "Fahrenheit") {
				if (valorConversorCambio == "Celsius") {
					conversorCambio = (valorIngresadoPrincipal - 32) * 5 / 9;

				}
				if (valorConversorCambio == "Kelvin") {
					conversorCambio = (valorIngresadoPrincipal - 32) * 5 / 9 + 273.15;
				}
			}
			if (valorConversorPrincipal == "Kelvin") {
				if (valorConversorCambio == "Fahrenheit") {
					conversorCambio = (valorIngresadoPrincipal - 273.15) * 9 / 5 + 32;
				}
				if (valorConversorCambio == "Celsius") {
					conversorCambio = valorIngresadoPrincipal - 273.15;
				}
			}

		} else if (conversorPrincipal == "LONGITUD") {

			if (valorConversorPrincipal == "Kilometro") {
				if (valorConversorCambio == "Metro") {
					conversorCambio = valorIngresadoPrincipal * 1000;
				}
				if (valorConversorCambio == "Centimetro") {
					conversorCambio = valorIngresadoPrincipal * 100000;
				}
				if (valorConversorCambio == "Milimetro") {
					conversorCambio = valorIngresadoPrincipal * 1000000;
				}
			}

			if (valorConversorPrincipal == "Metro") {
				if (valorConversorCambio == "Kilometro") {
					conversorCambio = valorIngresadoPrincipal * 0.001;
				}
				if (valorConversorCambio == "Centimetro") {
					conversorCambio = valorIngresadoPrincipal * 100;
				}
				if (valorConversorCambio == "Milimetro") {
					conversorCambio = valorIngresadoPrincipal * 1000;
				}
			}
			if (valorConversorPrincipal == "Centimetro") {
				if (valorConversorCambio == "Metro") {
					conversorCambio = valorIngresadoPrincipal * 0.01;
				}
				if (valorConversorCambio == "Kilometro") {
					conversorCambio = valorIngresadoPrincipal * 0.01 * 0.001;
				}
				if (valorConversorCambio == "Milimetro") {
					conversorCambio = valorIngresadoPrincipal * 10;
				}
			}

			if (valorConversorPrincipal == "Milimetro") {
				if (valorConversorCambio == "Kilometro") {
					conversorCambio = valorIngresadoPrincipal * 0.000001;
				}

				if (valorConversorCambio == "Metro") {
					conversorCambio = valorIngresadoPrincipal * 0.001;
				}

				if (valorConversorCambio == "Centimetro") {
					conversorCambio = valorIngresadoPrincipal * 0.1;
				}

			}

		} else {
			JOptionPane.showMessageDialog(null, "");

		}

		return conversorCambio;
	}

}
