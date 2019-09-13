package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TB_FUNCIONALIDADE database table.
 * 
 */
@Entity
@Table(name="TB_FUNCIONALIDADE")
@NamedQuery(name="Funcionalidade.findAll", query="SELECT f FROM Funcionalidade f")
public class Funcionalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FUNCIONALIDADE")
	private long idFuncionalidade;

	@Column(name="CD_FUNCIONALIDADE")
	private String cdFuncionalidade;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_CADASTRO")
	private Date dhCadastro;

	@Column(name="ID_MODULO")
	private BigDecimal idModulo;

	@Column(name="NM_FUNCIONALIDADE")
	private String nmFuncionalidade;

	@Column(name="ST_EXCLUIDO")
	private BigDecimal stExcluido;

	//bi-directional many-to-one association to FuncionalidadeAcao
	@OneToMany(mappedBy="funcionalidade")
	private List<FuncionalidadeAcao> funcionalidadeAcaos;

	public Funcionalidade() {
	}

	public long getIdFuncionalidade() {
		return this.idFuncionalidade;
	}

	public void setIdFuncionalidade(long idFuncionalidade) {
		this.idFuncionalidade = idFuncionalidade;
	}

	public String getCdFuncionalidade() {
		return this.cdFuncionalidade;
	}

	public void setCdFuncionalidade(String cdFuncionalidade) {
		this.cdFuncionalidade = cdFuncionalidade;
	}

	public Date getDhCadastro() {
		return this.dhCadastro;
	}

	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}

	public BigDecimal getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(BigDecimal idModulo) {
		this.idModulo = idModulo;
	}

	public String getNmFuncionalidade() {
		return this.nmFuncionalidade;
	}

	public void setNmFuncionalidade(String nmFuncionalidade) {
		this.nmFuncionalidade = nmFuncionalidade;
	}

	public BigDecimal getStExcluido() {
		return this.stExcluido;
	}

	public void setStExcluido(BigDecimal stExcluido) {
		this.stExcluido = stExcluido;
	}

	public List<FuncionalidadeAcao> getFuncionalidadeAcaos() {
		return this.funcionalidadeAcaos;
	}

	public void setFuncionalidadeAcaos(List<FuncionalidadeAcao> funcionalidadeAcaos) {
		this.funcionalidadeAcaos = funcionalidadeAcaos;
	}

	public FuncionalidadeAcao addFuncionalidadeAcao(FuncionalidadeAcao funcionalidadeAcao) {
		getFuncionalidadeAcaos().add(funcionalidadeAcao);
		funcionalidadeAcao.setFuncionalidade(this);

		return funcionalidadeAcao;
	}

	public FuncionalidadeAcao removeFuncionalidadeAcao(FuncionalidadeAcao funcionalidadeAcao) {
		getFuncionalidadeAcaos().remove(funcionalidadeAcao);
		funcionalidadeAcao.setFuncionalidade(null);

		return funcionalidadeAcao;
	}

}