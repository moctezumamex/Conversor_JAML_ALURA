package mx.alura.conversor.modelo;

public class Validador {

	public static boolean ValidaNumeros(String parametro) {

		boolean valido = true;

		if (!parametro.matches("[^a-zA-Z]*")) {
			valido = false;
		}
		return valido;
	}

	public static boolean ValidaDatosIguales(String parametro, String parametro2) {

		boolean valido = true;

		if (parametro == parametro2) {
			valido = false;
		}
		System.out.println(valido);
		return valido;
	}

}
