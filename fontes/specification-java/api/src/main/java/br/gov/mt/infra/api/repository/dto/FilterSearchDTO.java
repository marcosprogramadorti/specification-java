package br.gov.mt.infra.api.repository.dto;

import br.gov.mt.infra.api.repository.impl.MGenericPaginacao;

public class FilterSearchDTO {
	
	SearchCriteriaDTO filtro; 
	MGenericPaginacao paginacao;
	
	public SearchCriteriaDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(SearchCriteriaDTO filtro) {
		this.filtro = filtro;
	}
	public MGenericPaginacao getPaginacao() {
		return paginacao;
	}
	public void setPaginacao(MGenericPaginacao paginacao) {
		this.paginacao = paginacao;
	}
	
	
	
	
}
