package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatador {

	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(double valor) {
		return formatandoValores.format(valor);
	}
}
