package br.gov.mt.infra.api.repository.dto;

import java.util.List;

public class GenericFilterDTO {
	
	List<SearchCriteriaDTO>  listSearchCriteria;
	public List<SearchCriteriaDTO> getListSearchCriteria() {
		return listSearchCriteria;
	}
	public void setListSearchCriteria(List<SearchCriteriaDTO> listSearchCriteria) {
		this.listSearchCriteria = listSearchCriteria;
	}
	
	
	
	
}
