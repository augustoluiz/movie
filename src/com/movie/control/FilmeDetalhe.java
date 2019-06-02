package com.movie.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.SalaDAO;
import com.movie.model.Filme;
import com.movie.model.Programacao;

@Controller
public class FilmeDetalhe {
	
	private FilmeDAO filmeDAO = new FilmeDAO();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	private SalaDAO salaDAO = new SalaDAO();
	private FormataData formataData = new FormataData();
	
	@RequestMapping(value="/filme/{id}")
	public ModelAndView DetalheFilme(@PathVariable Long id) {
		
		Filme filme = new Filme();
		List<Programacao> programacoes = new ArrayList<>();
		List<Date> dias_exibicao = new ArrayList<>();
		Map<Date, List<Programacao>> hashDeProgramacoes = new HashMap<>();
		
		String erro = null;
		Date data_atual = new Date();
		
		try {
			filme = filmeDAO.consultaFilme(id);
			programacoes = programacaoDAO.consultaProximasProgramacoes(filme.getId(), formataData.formataDataYMDHM(data_atual));
			
			/*Atribui o nome da sala por programacao e insere datas na lista de dias(key do hash)*/
			for(Programacao p : programacoes) {
				p.setNome_sala(salaDAO.consultaSalaPorId(p.getId_sala()));
				Date dia = formataData.formataDataYMD(p.getExibicao());
				if(!dias_exibicao.contains(dia)) {
					dias_exibicao.add(dia);
				}
			}
			
			/*Atribui as programacoes para a lista de programacoes com base no dia e depois associa a key do hash(dia)*/
			for(Date dia : dias_exibicao) {
				List<Programacao> programacoesPorDia = new ArrayList<>();
				for(Programacao p : programacoes) {
					Date dia_prog = formataData.formataDataYMD(p.getExibicao());
					if (dia.equals(dia_prog)) {
						programacoesPorDia.add(p);
					}
				}
				hashDeProgramacoes.put(dia, programacoesPorDia);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			erro = "Ocorreu um erro inesperado, por favor contate um administrador";
		}
		
		
		ModelAndView mv = new ModelAndView("detalhe", "filme", filme);
		mv.addObject("hashProgramacoes", hashDeProgramacoes);
		mv.addObject("erro", erro);
				
		return mv;
	}
	
}
