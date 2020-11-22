package br.com.healthtrackfiap.utils;

import java.text.DecimalFormat;

import br.com.healthtrackfiap.exception.DataIncorretaException;;

public class FormatadorNumero {

	public static String toNumber(double number, int decimais) throws DataIncorretaException {
		return new DecimalFormat("#.00").format(number);
	}
}
