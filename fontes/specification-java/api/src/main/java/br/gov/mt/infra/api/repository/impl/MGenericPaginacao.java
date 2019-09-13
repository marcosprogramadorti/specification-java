package br.gov.mt.infra.api.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.gov.mt.infra.api.repository.dto.ClassificacaoDTO;

public class MGenericPaginacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 288698669626758028L;

	private int numeroPagina;
	private int tamanhoPagina;
	private List<ClassificacaoDTO> listaClassificacao;
	private Sort sort;

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(int tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public List<ClassificacaoDTO> getListaClassificacao() {
		return listaClassificacao;
	}

	public void setListaClassificacao(List<ClassificacaoDTO> listaClassificacao) {
		this.listaClassificacao = listaClassificacao;
	}

	public void doSortPorMultCampos(List<ClassificacaoDTO> listaClassificacao) {
		this.sort = null;
		if (listaClassificacao.size() > 0 ) {
			this.sort = Sort.by(listaClassificacao.get(0).getDirecao(), listaClassificacao.get(0).getOrdenarPorCampo());
			if (listaClassificacao.size() > 1) {
				for (int i = 1; i < listaClassificacao.size(); i++) {
					this.sort.and(Sort.by(listaClassificacao.get(i).getDirecao(),
							listaClassificacao.get(i).getOrdenarPorCampo()));
				}
			}
		}
	}

	public PageRequest factoryPageRequest() {
		doSortPorMultCampos(listaClassificacao);
		if (this.sort != null) {
			return PageRequest.of(numeroPagina, tamanhoPagina, sort);
		} else {
			return PageRequest.of(numeroPagina, tamanhoPagina);
		}

	}

}
