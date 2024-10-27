package com.jsfcourse.calc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalcBB {
	private String kredyt;    
	private String okrKr;    
	private String oproc;     
	private Double result; 
	

	@Inject
	FacesContext ctx;
	
	public String getKredyt() {
		return kredyt;
	}

	public void setKredyt(String kredyt) {
		this.kredyt = kredyt;
	}

	public String getOkrKr() {
		return okrKr;
	}

	public void setOkrKr(String okrKr) {
		this.okrKr = okrKr;
	}

	public String getOproc() {
		return oproc;
	}

	public void setOproc(String oproc) {
		this.oproc = oproc;
	}

	public Double getResult() {
		return result;
	}

	
	public String calc() {
		try {
			
			double kredyt = Double.parseDouble(this.kredyt);
			double okrKrYears = Double.parseDouble(this.okrKr); 
			double oproc = Double.parseDouble(this.oproc);

			
			double okrKrMonths = okrKrYears * 12;

			
			result = (kredyt + (kredyt * oproc / 100)) / okrKrMonths;

			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return "showresult"; 
		} catch (Exception e) {
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return null;
		}
	}

	public String info() {
		return "info";
	}
}