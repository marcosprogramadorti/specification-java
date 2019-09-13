package br.gov.mt.infra.api.repository.dto;

import java.io.Serializable;

import org.springframework.data.domain.Sort.Direction;

public class ClassificacaoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1479623792032867679L;
	String ordenarPorCampo;
	Direction direcao;
	public String getOrdenarPorCampo() {
		return ordenarPorCampo;
	}
	public void setOrdenarPorCampo(String ordenarPorCampo) {
		this.ordenarPorCampo = ordenarPorCampo;
	}
	public Direction getDirecao() {
		return direcao;
	}
	public void setDirecao(Direction direcao) {
		this.direcao = direcao;
	}
	
	
	
	
}
