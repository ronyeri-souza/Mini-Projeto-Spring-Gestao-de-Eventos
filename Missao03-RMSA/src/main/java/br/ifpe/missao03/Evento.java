package br.ifpe.missao03;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {

	//Attributes
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank(message="O nome deve ser preenchido com texto válido!")
	private String nomeEvento;
	private String descEvento;
	
	@Future(message="Insira a data atual ou superior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataRealizacao;
	
	@Min(value=10)
	private int qtdConvidados;
	private String nomeResp;
	private String foneResp;
	
	@Size(min=1)
	private String duracao;
	
	@ManyToOne
	@NotNull(message="O local deve ser informado!")
	private LocalEvento localEvento;
	
	
	//Getters and Setters
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDescEvento() {
		return descEvento;
	}
	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}
	public LocalDate getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(LocalDate dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public int getQtdConvidados() {
		return qtdConvidados;
	}
	public void setQtdConvidados(int qtdConvidados) {
		this.qtdConvidados = qtdConvidados;
	}
	public String getNomeResp() {
		return nomeResp;
	}
	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}
	public String getFoneResp() {
		return foneResp;
	}
	public void setFoneResp(String foneResp) {
		this.foneResp = foneResp;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public LocalEvento getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(LocalEvento localEvento) {
		this.localEvento = localEvento;
	}
	
}
