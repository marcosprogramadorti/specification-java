package br.gov.mt.infra.api.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.gov.mt.infra.api.repository.dto.SearchCriteriaDTO;

/***
 * TODO: throw Exception
 * 
 * **/
public class FactoryPredicate {
	private Root<?> root;
	private CriteriaBuilder builder;
	private SearchCriteriaDTO criteria;

	public FactoryPredicate(Root<?> root, CriteriaBuilder builder, SearchCriteriaDTO criteria) {
		super();
		this.root = root;
		this.builder = builder;
		this.criteria = criteria;
	}

	public Predicate createPredicate() {
		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return createPredicateByType(TipoDaExpressao.greaterThanOrEqualTo);
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return createPredicateByType(TipoDaExpressao.lessThanOrEqualTo);
		} else if (criteria.getOperation().equalsIgnoreCase(":")) {

			String[] keys = getKeys(criteria.getKey());
			if (keys.length > 1) {

				return createPredicateJoin(keys);

			} else if (root.get(criteria.getKey()).getJavaType() == String.class) {
				return createPredicateByType(TipoDaExpressao.like);
			} else {
				return createPredicateByType(TipoDaExpressao.equal);
			}
		}
		return null;
	}

	private Predicate createPredicateJoin(String[] keys) {
		Join<?, ?> join = null;
		Join<?, ?> nJoin = null;
		join = root.join(keys[0]);
		if (keys.length == 2) {

			return builder.like(builder.upper(join.<String>get(keys[keys.length - 1])),
					"%" + criteria.getValue().toUpperCase() + "%");
		}

		for (int i = 1; i < keys.length - 1; i++) {
			String string = keys[i];
			nJoin = join.join(string);
		}
		if (nJoin != null) {
			return builder.like(builder.upper(nJoin.<String>get(keys[keys.length - 1])),
					"%" + criteria.getValue().toUpperCase() + "%");
		}
		return null;
		

	}

	private Predicate createPredicateByType(TipoDaExpressao tipo) {
		if (tipo == TipoDaExpressao.greaterThanOrEqualTo) {
			
			return builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		}
		if (tipo == TipoDaExpressao.lessThanOrEqualTo) {
			return builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		}
		if (tipo == TipoDaExpressao.like) {
			return builder.like(builder.upper(root.<String>get(criteria.getKey())),
					"%" + criteria.getValue().toUpperCase() + "%");
		}
		if (tipo == TipoDaExpressao.equal) {
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		}
		/***
		 * TODO: between, in
		 * 
		 * **/

		return null;

	}

	/**
	 * split:exige uma expressão regular
	 * 
	 * Por isso, lembre-se de evitar caracteres especiais, se necessário. há 12
	 * caracteres com significados especiais: a barra invertida \, o acento
	 * circunflexo ^, o cifrão $, o ponto ou ponto ., o símbolo vertical de barra ou
	 * tubo |, o ponto de interrogação ?, o asterisco ou estrela *, o sinal de mais
	 * +, o parêntese de abertura (, o parêntese de fechamento ), eo colchete de
	 * abertura [, a chave de abertura {, Esses caracteres especiais são
	 * freqüentemente chamados de "metacaracteres".
	 * 
	 * Então, se você quiser dividir por exemplo período / ponto .que significa "
	 * qualquer caractere " em regex, use a barra invertida\ para escapar do
	 * caractere especial individual assim split("\\."), ou use a classe de
	 * caractere[] para representar caracteres literais como esse split("[.]"), ou
	 * use Pattern#quote()para escapar toda a corda assim split(Pattern.quote(".")).
	 **/
	private String[] getKeys(String keyOriginal) {
		String[] keys = keyOriginal.split("\\.");
		return keys;
	}
	
	public static enum TipoDaExpressao {
		greaterThanOrEqualTo,
		lessThanOrEqualTo,
		like,
		equal,
		between,
		in
	}
	
	
}
