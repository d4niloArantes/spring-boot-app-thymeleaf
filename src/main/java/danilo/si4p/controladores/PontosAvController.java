package danilo.si4p.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import danilo.si4p.entidades.Aluno;
import danilo.si4p.entidades.Avaliacao;
import danilo.si4p.entidades.PontosAv;
import danilo.si4p.repositorios.AlunoRepositorio;
import danilo.si4p.repositorios.AvaliacaoRepositorio;
import danilo.si4p.repositorios.PontosAvRepositorio;

@Controller
public class PontosAvController 
{
	@Autowired
	private PontosAvRepositorio pontosRepositorio;
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	@Autowired
	private AvaliacaoRepositorio avaliacaoRepositorio;
	
	@RequestMapping( value = "/pontos"  )
	public String avaliaAluno(Aluno aluno, PontosAv pontos, Model model)
	{	
		if(aluno.getId() != null)
			model.addAttribute("aluno", alunoRepositorio.findOne(aluno.getId()));
		else
			model.addAttribute("aluno", new Aluno());
		
		if(pontos.getIdPontosAv() == null)
			model.addAttribute("ponto", new PontosAv());
		
		model.addAttribute("avaliacoes", avaliacaoRepositorio.findAll());
		model.addAttribute("pontos", pontosRepositorio.findAll());
		return "PontosAv";
	}
	
	@RequestMapping( value = "/pontoslist"  )
	public String avaliaAlunos(Aluno aluno, PontosAv pontos, Avaliacao avaliacao, Model model)
	{	
		if(aluno.getId() != null)
			model.addAttribute("aluno", alunoRepositorio.findOne(aluno.getId()));
		else
			model.addAttribute("aluno", new Aluno());
		
		if(pontos.getIdPontosAv() != null)
			model.addAttribute("ponto", pontosRepositorio.findOne(pontos.getIdPontosAv()));
		else
			model.addAttribute("ponto", new PontosAv());
		
		if(avaliacao.getId() != null)
			model.addAttribute("avaliacao", avaliacaoRepositorio.findOne(avaliacao.getId()));
		else
			model.addAttribute("avaliacao", new Avaliacao());
		
		model.addAttribute("alunos", alunoRepositorio.findAll());
		model.addAttribute("avaliacoes", avaliacaoRepositorio.findAll());
		model.addAttribute("pontos", pontosRepositorio.findAll());
		return "PontosList";
	}
	
	@RequestMapping(value = "/pontos/save")
	public String salvar(PontosAv pontos)
	{
		pontosRepositorio.save(pontos);
		return "redirect:/pontoslist";
	}
}
