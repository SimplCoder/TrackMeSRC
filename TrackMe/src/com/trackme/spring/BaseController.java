package com.trackme.spring;

import org.springframework.ui.Model;

public class BaseController {
	String successMessage;
	String errorMessage;

	
	public void addSuccessMessage(String successMessage) {
		if(successMessage!=null && successMessage!=""){
				this.successMessage=successMessage;
			
		}
	}
	public void addErrorMessage(String errorMessage) {
		if(errorMessage!=null && errorMessage!=""){
		
				this.errorMessage=errorMessage;
		}
	}
	
	public Model addSuccessOrErrorMessageToModel(Model model){
		if(successMessage!=null && successMessage!=""){
			model.addAttribute("showSuccessMessage",true);
			model.addAttribute("successMessage",successMessage);
		}
		if(errorMessage!=null && errorMessage!=""){
			model.addAttribute("showErrorMessage",true);
			model.addAttribute("errorMessage",errorMessage);
		}
		successMessage=null;
		errorMessage=null;
		return model;
	}

}
