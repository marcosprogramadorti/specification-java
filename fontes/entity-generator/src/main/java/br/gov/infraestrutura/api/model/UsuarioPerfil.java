package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_USUARIO_PERFIL database table.
 * 
 */
@Entity
@Table(name="TB_USUARIO_PERFIL")
@NamedQuery(name="UsuarioPerfil.findAll", query="SELECT u FROM UsuarioPerfil u")
public class UsuarioPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO_PERFIL")
	private long idUsuarioPerfil;

	@Column(name="ST_EXCLUIDO")
	private BigDecimal stExcluido;

	//bi-directional many-to-one association to Perfil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public UsuarioPerfil() {
	}

	public long getIdUsuarioPerfil() {
		return this.idUsuarioPerfil;
	}

	public void setIdUsuarioPerfil(long idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	public BigDecimal getStExcluido() {
		return this.stExcluido;
	}

	public void setStExcluido(BigDecimal stExcluido) {
		this.stExcluido = stExcluido;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}