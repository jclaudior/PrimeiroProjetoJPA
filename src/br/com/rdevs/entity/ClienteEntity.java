package br.com.rdevs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteEntity {
	@Column(name ="ID_CLIENTE")
	@Id
	@GeneratedValue
	private int idCliente;
	
	@Column(name="NM_CLIENTE")
	private String nmCliente;
	
	@Column(name="NR_CPF")
	private String nrCPF;
	
	@Column(name="NR_CNPJ")
	private String nrCNPJ;
	
	@Column(name="DT_CADASTRO")
	private Date dtCadastro;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getNrCPF() {
		return nrCPF;
	}

	public void setNrCPF(String nrCPF) {
		this.nrCPF = nrCPF;
	}

	public String getNrCNPJ() {
		return nrCNPJ;
	}

	public void setNrCNPJ(String nrCNPJ) {
		this.nrCNPJ = nrCNPJ;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
	
	
	
}
