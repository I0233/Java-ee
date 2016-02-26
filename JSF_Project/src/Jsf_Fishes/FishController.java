package Jsf_Fishes;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped 
public class FishController implements java.io.Serializable  {

	public FishController() {
		// TODO Auto-generated constructor stub
	}
	
	/* @return null (error) tai success */
    public String tarkista() {
        FacesContext facesContext = FacesContext.getCurrentInstance();       
        
        //Keeping faces message after redirect (JSF)
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        
        // JSF:ssa luodun beanin nimell‰ p‰‰st‰‰n olioon kiinni "fish" (faces-config.xml)
        Fish f = (Fish)facesContext.getExternalContext().getSessionMap().get("fish");
        int a = f.getLength();
        int b = f.getWeight();
        
        if (a <= 0 && b <= 0) { // Onko pituus tai paino nolla tai negatiivinen!
        	facesContext.addMessage(null, new FacesMessage("Pituus ja paino arvot on muutettava enemm‰n kun nolla!"));
            return "FishError"; // virhe. ohjaus virhesivulle - FishError.xhtml
        }
        else if (b <= 0){
        	facesContext.addMessage(null, new FacesMessage("Painon on oltava enemm‰n kun nolla!"));
            return "FishError"; 
        }
        else if (a <= 0){
        	facesContext.addMessage(null, new FacesMessage("Pituuden on oltava enemm‰n kun nolla!"));
            return "FishError"; 
        }
        else{
        	return "FishOutput"; // Suora ohjaus tiedostoon - FishOutput.xhtml
        }
    }

}
