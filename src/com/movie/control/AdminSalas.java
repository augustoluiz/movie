package com.movie.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.SalaDAO;
import com.movie.dao.exception.DAOException;
import com.movie.model.Sala;

@Controller
public class AdminSalas {
	
	private SalaDAO salaDAO = new SalaDAO();
	
	@RequestMapping(value = {"/admin/salas"})
	public ModelAndView Filme() {
		List<Sala> salas = new ArrayList<>();
		String erro = null;
		
		try {
			salas = salaDAO.consultaSalas();
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao exibir as salas";
		}
		
		ModelAndView mv = new ModelAndView("sala", "salas", salas);
		mv.addObject("erro", erro);
		
		return mv;
	}
	
}
