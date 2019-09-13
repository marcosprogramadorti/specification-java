package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_FUNCIONALIDADE_ACAO database table.
 * 
 */
@Entity
@Table(name="TB_FUNCIONALIDADE_ACAO")
@NamedQuery(name="FuncionalidadeAcao.findAll", query="SELECT f FROM FuncionalidadeAcao f")
public class FuncionalidadeAcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FUNCIONALIDADE_ACAO")
	private long idFuncionalidadeAcao;

	//bi-directional many-to-one association to Acao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ACAO")
	private Acao acao;

	//bi-directional many-to-one association to Funcionalidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_FUNCIONALIDADE")
	private Funcionalidade funcionalidade;

	//bi-directional many-to-one association to PerfilFuncionalidadeAcao
	@OneToMany(mappedBy="funcionalidadeAcao")
	private List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaos;

	public FuncionalidadeAcao() {
	}

	public long getIdFuncionalidadeAcao() {
		return this.idFuncionalidadeAcao;
	}

	public void setIdFuncionalidadeAcao(long idFuncionalidadeAcao) {
		this.idFuncionalidadeAcao = idFuncionalidadeAcao;
	}

	public Acao getAcao() {
		return this.acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public Funcionalidade getFuncionalidade() {
		return this.funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public List<PerfilFuncionalidadeAcao> getPerfilFuncionalidadeAcaos() {
		return this.perfilFuncionalidadeAcaos;
	}

	public void setPerfilFuncionalidadeAcaos(List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaos) {
		this.perfilFuncionalidadeAcaos = perfilFuncionalidadeAcaos;
	}

	public PerfilFuncionalidadeAcao addPerfilFuncionalidadeAcao(PerfilFuncionalidadeAcao perfilFuncionalidadeAcao) {
		getPerfilFuncionalidadeAcaos().add(perfilFuncionalidadeAcao);
		perfilFuncionalidadeAcao.setFuncionalidadeAcao(this);

		return perfilFuncionalidadeAcao;
	}

	public PerfilFuncionalidadeAcao removePerfilFuncionalidadeAcao(PerfilFuncionalidadeAcao perfilFuncionalidadeAcao) {
		getPerfilFuncionalidadeAcaos().remove(perfilFuncionalidadeAcao);
		perfilFuncionalidadeAcao.setFuncionalidadeAcao(null);

		return perfilFuncionalidadeAcao;
	}

}