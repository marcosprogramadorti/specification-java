package br.gov.mt.infra.api.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.gov.mt.infra.api.repository.dto.SearchCriteriaDTO;

public class GenericSpecificationMany<T> implements Specification<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SearchCriteriaDTO> listaCriteria;
	

	public GenericSpecificationMany(List<SearchCriteriaDTO> listaCriteria) {
		super();
		this.listaCriteria = listaCriteria;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
		Predicate[] criteria = createListPredicate(this.listaCriteria,root,query, builder); 
		return builder.and(criteria);
	}
	
	public Predicate[] createListPredicate(List<SearchCriteriaDTO> listaCriteria, Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		List<Predicate> predicates = new ArrayList<>();
		for (SearchCriteriaDTO sc : listaCriteria) {
			predicates.add(partialPredicate(root, query,builder, sc));
		};
		return predicates.toArray(new Predicate[predicates.size()]);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Predicate partialPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder,
			SearchCriteriaDTO criteria) {
		FactoryPredicate fp = new FactoryPredicate(root, builder, criteria);
		return fp.createPredicate();
	}

}
