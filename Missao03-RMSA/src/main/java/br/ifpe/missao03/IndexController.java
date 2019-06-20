package br.ifpe.missao03;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class IndexController {
	
	@Autowired
	private EventoDAO eventoRep;
	
	@Autowired
	private LocalEventoDAO localeventoRep;

	
	@GetMapping("/eventos")
	public ModelAndView exibirEventos() {
		ModelAndView mv = new ModelAndView("/eventos-list");		
		mv.addObject("listaEventos", this.eventoRep.findAll(Sort.by("nomeEvento")));
		return mv;
	}
	
	@PostMapping("/eventos")
	public ModelAndView pesquisarProdutos(@RequestParam(required=false) String nomePesquisa) {
		ModelAndView mv = new ModelAndView("/eventos-list");		
		
		List<Evento> listaEventos;
		if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
			listaEventos = this.eventoRep.findAll(Sort.by("nomeEvento"));	
		} else {
			listaEventos = this.eventoRep.findByNomeEventoContainingIgnoreCase(nomePesquisa);
		}
		
		mv.addObject("listaEventos", listaEventos);
		return mv;
	}
	
	@GetMapping("/eventosForm")
	public ModelAndView exibirFormEventos(Evento evento) {
		ModelAndView mv = new ModelAndView("/cadastroEvento");		
		mv.addObject("listaEventos", this.eventoRep.findAll(Sort.by("nomeEvento")));
		// Caso seja passado o Id do produto, esta chamada será para edição do produto
		if (evento != null && evento.getCodigo() != null) {
			evento = this.eventoRep.getOne(evento.getCodigo());
		} else { // Caso contrário, será uma adição de novo produto
			evento = new Evento();}
		mv.addObject("evento", evento);
		return mv;
	}
	
	//Controller da página inicial
	@GetMapping("/ind")
	public String index() {
		
		return "index";
	}
	
	//Controller da página de cadastro
	@GetMapping("/cad") 
	public String cadastrar(Model model) {
		model.addAttribute("tituloCad", "CADASTRO DE CONVIDADOS");
		return "cadastrar";
	}
	
	//Controller da página de alterar cadastro
	@GetMapping("/alt")
	public String alterar(Model model) {
		model.addAttribute("tituloAlt","ALTERAR CADASTRO");
		return "alterar";
	}
	
	//Controller da página de recuperar senha
	@GetMapping("/rec")
	public String recuperar(Model model) {
		model.addAttribute("tituloRec", "RECUPERAR SENHA");
		return "recuperar";
	}
	
	//Controller da página de remover senha
	@GetMapping("/rem")
	public String remover(Model model) {
		model.addAttribute("tituloRem", "REMOVER SENHA");
		return "remover";
	}
	
	//Controller da página de listar senhas
	@GetMapping("/list")
	public String listar(Model model) {
		model.addAttribute("tituloList", "LISTA DE CONVIDADOS");
		return "listar";
	}
	
	
		//MISSÃO 02 -----------------------------------------------
	
	//Controller da página listaEventos
	@GetMapping("/eventlist")
	public ModelAndView listaEventos() {
		
		ModelAndView le = new ModelAndView("/listaEventos");
		le.addObject("evento", eventoRep.findAll());
		le.addObject("localEvento", localeventoRep.findAll());
		return le;
	}
	
	//Controller da página de cadastro de eventos
	@GetMapping("/novoevento")
	public ModelAndView cadastroEvento() {
		ModelAndView mv = new ModelAndView("cadastroEvento");
		mv.addObject("evento", new Evento());
		mv.addObject("localEvento", localeventoRep.findAll());
		return mv;
	}
	
	
	@GetMapping("/exibirEvento")
	public ModelAndView exibir(@RequestParam Integer codigo) {
		
		ModelAndView mv = new ModelAndView("cadastroEvento");
		mv.addObject("evento", eventoRep.getOne(codigo));
		mv.addObject("localEvento", localeventoRep.findAll());
		return mv;
	}
	
	@GetMapping("/removerEvento")
	public ModelAndView remover(@RequestParam Integer codigo) {		
		eventoRep.deleteById(codigo);
		return listaEventos();
		
	}
	
	//ADICIONAR EVENTO
	
	@PostMapping("/add")
	public ModelAndView addEvento(@Valid Evento evento, BindingResult br) {
		
		ModelAndView mv = new ModelAndView("/cadastroEvento");
		mv.addObject("evento", evento);
		mv.addObject("localEvento", localeventoRep.findAll());
		
		if(br.hasErrors()) {
			
			return mv;
		}
		
		this.eventoRep.save(evento);
		return listaEventos();
	}
	
		//MISSÃO 03 ---------------------------------
	
	//PÁGINA PARA FORMULÁRIO DE LOCAL DE EVENTOS
	@GetMapping("/cadLocal")
	public ModelAndView cadastroLocal() {
		
		ModelAndView mv = new ModelAndView("cadLocalEventos");
		mv.addObject("localEvento", new LocalEvento());
		return mv;
		
	}
	
	//ADICIONAR UM NOVO LOCAL DE EVENTOS
	@PostMapping("/addLocal")
	public String salvarLocal(@ModelAttribute LocalEvento localEvento) {
		
		this.localeventoRep.save(localEvento);
		return "redirect:/listLocais";
		
	}
	
	//PÁGINA PARA LISTAR OS LOCAIS DE EVENTOS
	@GetMapping("/listLocais")
	public ModelAndView listaLocais() {
		
		ModelAndView mv = new ModelAndView("/listaLocais");
		mv.addObject("localEvento", localeventoRep.findAll());
		return mv;
	}
	
	//PÁGINA PARA EDITAR OS LOCAIS DE EVENTOS
	@GetMapping("/editLocal")
	public ModelAndView editarLocal(@RequestParam Integer codigo) {
		
		ModelAndView mv = new ModelAndView("cadLocalEventos");
		mv.addObject("localEvento", localeventoRep.getOne(codigo));
		return mv;
	}
	
	//PÁGINA PARA REMOVER UM LOCAL DE EVENTOS
	@GetMapping("/removeLocal")
	public ModelAndView removerLocal(@RequestParam Integer codigo) {
		
		localeventoRep.deleteById(codigo);
		return listaLocais();
		
	}
}
