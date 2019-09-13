package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_PERFIL database table.
 * 
 */
@Entity
@Table(name="TB_PERFIL")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL")
	private long idPerfil;

	@Column(name="DS_PERFIL")
	private String dsPerfil;

	@Column(name="ID_RECURSO")
	private BigDecimal idRecurso;

	@Column(name="NM_PERFIL")
	private String nmPerfil;

	@Column(name="ST_ATIVO")
	private BigDecimal stAtivo;

	@Column(name="ST_EXCLUIDO")
	private BigDecimal stExcluido;

	@Column(name="ST_GESTOR")
	private String stGestor;

	//bi-directional many-to-one association to PerfilFuncionalidadeAcao
	@OneToMany(mappedBy="perfil")
	private List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaos;

	//bi-directional many-to-one association to UsuarioPerfil
	@OneToMany(mappedBy="perfil")
	private List<UsuarioPerfil> usuarioPerfils;

	public Perfil() {
	}

	public long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDsPerfil() {
		return this.dsPerfil;
	}

	public void setDsPerfil(String dsPerfil) {
		this.dsPerfil = dsPerfil;
	}

	public BigDecimal getIdRecurso() {
		return this.idRecurso;
	}

	public void setIdRecurso(BigDecimal idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getNmPerfil() {
		return this.nmPerfil;
	}

	public void setNmPerfil(String nmPerfil) {
		this.nmPerfil = nmPerfil;
	}

	public BigDecimal getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(BigDecimal stAtivo) {
		this.stAtivo = stAtivo;
	}

	public BigDecimal getStExcluido() {
		return this.stExcluido;
	}

	public void setStExcluido(BigDecimal stExcluido) {
		this.stExcluido = stExcluido;
	}

	public String getStGestor() {
		return this.stGestor;
	}

	public void setStGestor(String stGestor) {
		this.stGestor = stGestor;
	}

	public List<PerfilFuncionalidadeAcao> getPerfilFuncionalidadeAcaos() {
		return this.perfilFuncionalidadeAcaos;
	}

	public void setPerfilFuncionalidadeAcaos(List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaos) {
		this.perfilFuncionalidadeAcaos = perfilFuncionalidadeAcaos;
	}

	public PerfilFuncionalidadeAcao addPerfilFuncionalidadeAcao(PerfilFuncionalidadeAcao perfilFuncionalidadeAcao) {
		getPerfilFuncionalidadeAcaos().add(perfilFuncionalidadeAcao);
		perfilFuncionalidadeAcao.setPerfil(this);

		return perfilFuncionalidadeAcao;
	}

	public PerfilFuncionalidadeAcao removePerfilFuncionalidadeAcao(PerfilFuncionalidadeAcao perfilFuncionalidadeAcao) {
		getPerfilFuncionalidadeAcaos().remove(perfilFuncionalidadeAcao);
		perfilFuncionalidadeAcao.setPerfil(null);

		return perfilFuncionalidadeAcao;
	}

	public List<UsuarioPerfil> getUsuarioPerfils() {
		return this.usuarioPerfils;
	}

	public void setUsuarioPerfils(List<UsuarioPerfil> usuarioPerfils) {
		this.usuarioPerfils = usuarioPerfils;
	}

	public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().add(usuarioPerfil);
		usuarioPerfil.setPerfil(this);

		return usuarioPerfil;
	}

	public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().remove(usuarioPerfil);
		usuarioPerfil.setPerfil(null);

		return usuarioPerfil;
	}

}