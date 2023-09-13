package mx.alura.conversor.modelo;

public class Moneda_Test {

	public static void main(String[] args) {

		String tipomoneda = "Pesos MXN,Dolar,Yen,Libra,Euro";
		String separador = ",";

		String[] tipomonedaarray = tipomoneda.split(separador);

		for (String lenguaje : tipomonedaarray) {
			System.out.println(lenguaje);
		}

	}
	
}