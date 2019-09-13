package br.gov.mt.infra.api.repository.impl;

import javax.validation.Payload;

public class MGenericSeverity {
	public static class Info implements Payload {};
    public static class Error implements Payload {};
    public static class Worning implements Payload {};
    
}
