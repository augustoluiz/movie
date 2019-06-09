package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private SimpleDateFormat sdf_data = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf_hora = new SimpleDateFormat("HH:mm");
	
	public FormataData() {
		
	}
	
	public Date formataDataYMDHM(Date data) throws ParseException {
		String data_str = sdf.format(data);
		return sdf.parse(data_str);
	}
	
	public Date formataDataYMD(Date data) throws ParseException {
		String data_str = sdf_data.format(data);
		return sdf_data.parse(data_str);
	}
	
	public Date formataDataYMDHMExibicao(Date data_exibicao, Date hora_exibicao) throws ParseException {
		String data = sdf_data.format(data_exibicao);
		String hora = sdf_hora.format(hora_exibicao);
		String data_str = data+" "+hora;
		return sdf.parse(data_str);
	}
	
}
