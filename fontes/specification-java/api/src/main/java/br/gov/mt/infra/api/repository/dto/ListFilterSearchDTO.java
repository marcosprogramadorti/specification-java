package br.gov.mt.infra.api.repository.dto;

import br.gov.mt.infra.api.repository.impl.MGenericPaginacao;

public class ListFilterSearchDTO {

	GenericFilterDTO filtro;
	MGenericPaginacao paginacao;

	public GenericFilterDTO getFiltro() {
		return filtro;
	}

	public void setFiltro(GenericFilterDTO filtro) {
		this.filtro = filtro;
	}

	public MGenericPaginacao getPaginacao() {
		return paginacao;
	}

	public void setPaginacao(MGenericPaginacao paginacao) {
		this.paginacao = paginacao;
	}

}
