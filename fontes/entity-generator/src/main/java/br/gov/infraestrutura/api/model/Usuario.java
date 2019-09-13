package br.gov.infraestrutura.api.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TB_USUARIO database table.
 * 
 */
@Entity
@Table(name="TB_USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="CD_TOKEN")
	private byte[] cdToken;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_ATIVACAO")
	private Date dhAtivacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_EXPIRACAO")
	private Date dhExpiracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_REGISTRO")
	private Date dhRegistro;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_TOKEN")
	private Date dhToken;

	@Temporal(TemporalType.DATE)
	@Column(name="DH_ULTIMO_ACESSO")
	private Date dhUltimoAcesso;

	@Column(name="ID_PESSOA")
	private BigDecimal idPessoa;

	@Column(name="ID_TIPO_USUARIO")
	private BigDecimal idTipoUsuario;

	@Column(name="NM_EMAIL")
	private String nmEmail;

	@Column(name="NM_LOGIN")
	private String nmLogin;

	@Column(name="NM_SENHA")
	private String nmSenha;

	@Column(name="NM_USUARIO")
	private String nmUsuario;

	@Column(name="ST_EXCLUIDO")
	private BigDecimal stExcluido;

	@Column(name="ST_USUARIO")
	private BigDecimal stUsuario;

	//bi-directional many-to-one association to UsuarioPerfil
	@OneToMany(mappedBy="usuario")
	private List<UsuarioPerfil> usuarioPerfils;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public byte[] getCdToken() {
		return this.cdToken;
	}

	public void setCdToken(byte[] cdToken) {
		this.cdToken = cdToken;
	}

	public Date getDhAtivacao() {
		return this.dhAtivacao;
	}

	public void setDhAtivacao(Date dhAtivacao) {
		this.dhAtivacao = dhAtivacao;
	}

	public Date getDhExpiracao() {
		return this.dhExpiracao;
	}

	public void setDhExpiracao(Date dhExpiracao) {
		this.dhExpiracao = dhExpiracao;
	}

	public Date getDhRegistro() {
		return this.dhRegistro;
	}

	public void setDhRegistro(Date dhRegistro) {
		this.dhRegistro = dhRegistro;
	}

	public Date getDhToken() {
		return this.dhToken;
	}

	public void setDhToken(Date dhToken) {
		this.dhToken = dhToken;
	}

	public Date getDhUltimoAcesso() {
		return this.dhUltimoAcesso;
	}

	public void setDhUltimoAcesso(Date dhUltimoAcesso) {
		this.dhUltimoAcesso = dhUltimoAcesso;
	}

	public BigDecimal getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(BigDecimal idPessoa) {
		this.idPessoa = idPessoa;
	}

	public BigDecimal getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(BigDecimal idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNmEmail() {
		return this.nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public String getNmLogin() {
		return this.nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getNmSenha() {
		return this.nmSenha;
	}

	public void setNmSenha(String nmSenha) {
		this.nmSenha = nmSenha;
	}

	public String getNmUsuario() {
		return this.nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public BigDecimal getStExcluido() {
		return this.stExcluido;
	}

	public void setStExcluido(BigDecimal stExcluido) {
		this.stExcluido = stExcluido;
	}

	public BigDecimal getStUsuario() {
		return this.stUsuario;
	}

	public void setStUsuario(BigDecimal stUsuario) {
		this.stUsuario = stUsuario;
	}

	public List<UsuarioPerfil> getUsuarioPerfils() {
		return this.usuarioPerfils;
	}

	public void setUsuarioPerfils(List<UsuarioPerfil> usuarioPerfils) {
		this.usuarioPerfils = usuarioPerfils;
	}

	public UsuarioPerfil addUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().add(usuarioPerfil);
		usuarioPerfil.setUsuario(this);

		return usuarioPerfil;
	}

	public UsuarioPerfil removeUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		getUsuarioPerfils().remove(usuarioPerfil);
		usuarioPerfil.setUsuario(null);

		return usuarioPerfil;
	}

}