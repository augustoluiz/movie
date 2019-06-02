package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	
	public FormataData() {
		
	}
	
	public Date formataDataYMDHM(Date data) throws ParseException {
		String data_str = sdf.format(data);
		return sdf.parse(data_str);
	}
	
	public Date formataDataYMD(Date data) throws ParseException {
		String data_str = sdf1.format(data);
		return sdf1.parse(data_str);
	}
	
}
