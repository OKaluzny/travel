package org.germes.presentation.admin.i18n;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("language")
@SessionScoped
/**
 * Keeps selected langauge for the current user
 * @author Morenets
 *
 */
public class LanguageBean implements Serializable{
	private static final long serialVersionUID = -1622109063359055116L;
	
	/**
	 * Locale for the current user
	 */
	private Locale locale;

	public Locale getLocale() {
		return locale;
	}
	
	public void setLanguage(String lang) {
		locale = new Locale(lang);
	}

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}
}
