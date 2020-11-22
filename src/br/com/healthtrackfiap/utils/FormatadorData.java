package br.com.healthtrackfiap.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.healthtrackfiap.exception.*;;

public class FormatadorData {
	
public static String toDate(Date data) throws DataIncorretaException {
		
		if ( data == null  ) {
			throw new DataIncorretaException("A data nao pode ser nula");
		}
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    return df.format(data);
	}

	public static Date parseDate(String data) throws DataIncorretaException {
		
		List<String> masks = new ArrayList<String>();
		
		masks.add("dd/MM/yyyy HH:mm:ss");
		masks.add("dd/MM/yyyy'T'HH:mm:ss");
		masks.add("dd/MM/yyyy");
		masks.add("yyyy-MM-dd'T'HH:mm:ss");
		masks.add("yyyy-MM-dd HH:mm:ss");
		masks.add("yyyy-MM-dd");
		
		Date date1 = null;
		
		for (String mask: masks) { 
			try {
				date1 = new SimpleDateFormat(mask).parse(data);
				break;
			} catch (ParseException e) {}  
		}
		
		if (date1 == null)
			throw new DataIncorretaException();
		
		return date1;
		
	}

}
