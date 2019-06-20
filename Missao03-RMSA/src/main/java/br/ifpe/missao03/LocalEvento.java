package br.ifpe.missao03;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class LocalEvento {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoLocal;
	private String nomeLocal;
	
	//ENDEREÇO
	private String nomeRua;
	private int numLocal;
	private String complemento;
	private String bairro;
	private String cidade;
	
	private String linkEndereco;
	private int capacidade;
	private String tipoAmbiente;
	
	//GETTERS E SETTERS
	
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	public String getNomeLocal() {
		return nomeLocal;
	}
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	public int getNumLocal() {
		return numLocal;
	}
	public void setNumLocal(int numLocal) {
		this.numLocal = numLocal;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLinkEndereco() {
		return linkEndereco;
	}
	public void setLinkEndereco(String linkEndereco) {
		this.linkEndereco = linkEndereco;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getTipoAmbiente() {
		return tipoAmbiente;
	}
	public void setTipoAmbiente(String tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	
	
	
}
