package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TB_PERFIL_FUNCIONALIDADE_ACAO database table.
 * 
 */
@Entity
@Table(name="TB_PERFIL_FUNCIONALIDADE_ACAO")
@NamedQuery(name="PerfilFuncionalidadeAcao.findAll", query="SELECT p FROM PerfilFuncionalidadeAcao p")
public class PerfilFuncionalidadeAcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL_FUNCIONALIDADE_ACAO")
	private long idPerfilFuncionalidadeAcao;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_CADASTRO")
	private Date dhCadastro;

	//bi-directional many-to-one association to FuncionalidadeAcao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_FUNCIONALIDADE_ACAO")
	private FuncionalidadeAcao funcionalidadeAcao;

	//bi-directional many-to-one association to Perfil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;

	public PerfilFuncionalidadeAcao() {
	}

	public long getIdPerfilFuncionalidadeAcao() {
		return this.idPerfilFuncionalidadeAcao;
	}

	public void setIdPerfilFuncionalidadeAcao(long idPerfilFuncionalidadeAcao) {
		this.idPerfilFuncionalidadeAcao = idPerfilFuncionalidadeAcao;
	}

	public Date getDhCadastro() {
		return this.dhCadastro;
	}

	public void setDhCadastro(Date dhCadastro) {
		this.dhCadastro = dhCadastro;
	}

	public FuncionalidadeAcao getFuncionalidadeAcao() {
		return this.funcionalidadeAcao;
	}

	public void setFuncionalidadeAcao(FuncionalidadeAcao funcionalidadeAcao) {
		this.funcionalidadeAcao = funcionalidadeAcao;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}