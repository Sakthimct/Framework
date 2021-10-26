package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPagePojo extends BaseClass {
	
	public FBLoginPagePojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	
	private WebElement txtUser;
	
	@FindBy(name="pass")
	
	private WebElement txtPass;
	
	@FindBy(xpath="//button[@name='login']")
	
	private WebElement btnlogin;
	
	public WebElement getTxtUser( ) {
		
		return txtUser;
	}
	
	
public WebElement getTxtPass( ) {
		
		return txtPass;
	}
	
public WebElement getBtnLogin( ) {
	
	return btnlogin;
}

	
	
	

}
