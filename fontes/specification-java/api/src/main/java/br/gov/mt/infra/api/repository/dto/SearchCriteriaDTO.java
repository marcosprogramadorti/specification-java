package br.gov.mt.infra.api.repository.dto;

public class SearchCriteriaDTO {
	private String key;
	private String operation;
	private String value;

	public String getKey() {
		return key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
