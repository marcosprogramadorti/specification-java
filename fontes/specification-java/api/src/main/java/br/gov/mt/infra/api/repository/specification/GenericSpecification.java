package br.gov.mt.infra.api.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.gov.mt.infra.api.repository.dto.SearchCriteriaDTO;


public class GenericSpecification<T> implements Specification<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchCriteriaDTO criteria;
	
	
	
	public GenericSpecification(SearchCriteriaDTO criteria) {
		super();
		this.criteria = criteria;
	}

	

	public SearchCriteriaDTO getCriteria() {
		return criteria;
	}



	public void setCriteria(SearchCriteriaDTO criteria) {
		this.criteria = criteria;
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
		FactoryPredicate fp = new FactoryPredicate(root, builder, criteria);
		return fp.createPredicate();
    }
	
	



	
	
	
	
	
   
}
