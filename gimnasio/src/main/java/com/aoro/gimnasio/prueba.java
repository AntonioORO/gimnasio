package com.aoro.gimnasio;

import java.text.DecimalFormat;

public class prueba {
	public static void main(String args[]) {
		DecimalFormat formato = new DecimalFormat("#,###.00");
		String valorFormateado = formato.format(121113456.7);

		System.out.println(valorFormateado);
	}
}
