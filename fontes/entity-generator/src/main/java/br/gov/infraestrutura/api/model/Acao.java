package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_ACAO database table.
 * 
 */
@Entity
@Table(name="TB_ACAO")
@NamedQuery(name="Acao.findAll", query="SELECT a FROM Acao a")
public class Acao implements Serializable {
	private static final long serialVersionUID = 1L;
	private long idAcao;
	private String cdAcao;
	private String nmAcao;
	private List<FuncionalidadeAcao> funcionalidadeAcaos;

	public Acao() {
	}


	@Id
	@Column(name="ID_ACAO")
	public long getIdAcao() {
		return this.idAcao;
	}

	public void setIdAcao(long idAcao) {
		this.idAcao = idAcao;
	}


	@Column(name="CD_ACAO")
	public String getCdAcao() {
		return this.cdAcao;
	}

	public void setCdAcao(String cdAcao) {
		this.cdAcao = cdAcao;
	}


	@Column(name="NM_ACAO")
	public String getNmAcao() {
		return this.nmAcao;
	}

	public void setNmAcao(String nmAcao) {
		this.nmAcao = nmAcao;
	}


	//bi-directional many-to-one association to FuncionalidadeAcao
	@OneToMany(mappedBy="acao")
	public List<FuncionalidadeAcao> getFuncionalidadeAcaos() {
		return this.funcionalidadeAcaos;
	}

	public void setFuncionalidadeAcaos(List<FuncionalidadeAcao> funcionalidadeAcaos) {
		this.funcionalidadeAcaos = funcionalidadeAcaos;
	}

	public FuncionalidadeAcao addFuncionalidadeAcao(FuncionalidadeAcao funcionalidadeAcao) {
		getFuncionalidadeAcaos().add(funcionalidadeAcao);
		funcionalidadeAcao.setAcao(this);

		return funcionalidadeAcao;
	}

	public FuncionalidadeAcao removeFuncionalidadeAcao(FuncionalidadeAcao funcionalidadeAcao) {
		getFuncionalidadeAcaos().remove(funcionalidadeAcao);
		funcionalidadeAcao.setAcao(null);

		return funcionalidadeAcao;
	}

}