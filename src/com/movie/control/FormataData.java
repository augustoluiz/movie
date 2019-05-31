package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public FormataData() {
		
	}
	
	public Date formataDataYMDHM(Date data) throws ParseException {
		String data_str = sdf.format(data);
		return sdf.parse(data_str);
	}
	
}
