package net.gll.test.gll.test.steps;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.Parameter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.gll.pgobjects.gll.pgobjects.CheckOutPgObjects;
import net.gll.pgobjects.gll.pgobjects.CheckoutConfirmationPgObjects;
import net.gll.pgobjects.gll.pgobjects.ForgotPasswordPgObjects;
import net.gll.pgobjects.gll.pgobjects.HomePgObjects;
import net.gll.pgobjects.gll.pgobjects.LogInPgObjects;
import net.gll.pgobjects.gll.pgobjects.ProductsPgObjects;
import net.gll.pgobjects.gll.pgobjects.RegConfirmationPgObjects;
import net.gll.pgobjects.gll.pgobjects.RegistrationPgObjects;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import util.TabCatcher;
import util.TpGenerator;

public class Gllsteps {
	
	@Steps
	@Managed
	public static WebDriver driver;
	HomePgObjects homePgObjects;
	CheckoutConfirmationPgObjects checkoutConfirmationPgObjects;
	CheckOutPgObjects checkOutPgObjects;
	LogInPgObjects logInPgObjects;
	ProductsPgObjects productsPgObjects;
	RegConfirmationPgObjects regConfirmationPgObjects;
	RegistrationPgObjects registrationPgObjects;
	ForgotPasswordPgObjects forgotPasswordPgObjects;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Gllsteps.class);
	
	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
	    driver.get("https://www.glifestyle.net/en/login?returnUrl=http://www.glifestyle.net/en");
	    driver.manage().window().maximize();
	}
	@Given("^user direct to the staging site$")
	public void user_direct_to_the_staging_site() throws Throwable {
		driver.get("https://store.myqweb.biz/en/login?returnUrl=http://store.myqweb.biz/en");
	    driver.manage().window().maximize();
	}
	@When("^user click on Login or Register button$")
	public void user_click_on_Login_or_Register_button() throws Throwable {  
	   // homePgObjects.clickLogInReg();
	}

	@When("^user enter a valid ID or email \"([^\"]*)\"$")
	public void user_enter_a_valid_ID_or_email(String user) throws Throwable {
		
	    logInPgObjects.enterID(user);
	    
	}

	@When("^user enter a password \"([^\"]*)\"$")
	public void user_enter_a_password(String pass) throws Throwable {
	    logInPgObjects.enterPassword(pass);
	    
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		
	    logInPgObjects.clickLogInBtn();
	    Thread.sleep(15000);
	}

	@Then("^validate the landing page \"([^\"]*)\"$")
	public void validate_the_landing_page(String url) throws Throwable {
		 
	    Assert.assertEquals("validate the landing page", url, driver.getCurrentUrl());
	    
	}
	
	@When("^user click on become a Bus Asso$")
	public void user_click_on_become_a_Bus_Asso() throws Throwable {
		driver.manage().window().maximize();
	    logInPgObjects.clickRegBtn();
	    Thread.sleep(3000);
	   
	}

	@When("^user select registration type \"([^\"]*)\"$")
	public void user_select_registration_type(String type) throws Throwable {
		driver.manage().window().maximize();
	    registrationPgObjects.selectRegType(type);
	    Thread.sleep(3000);
	}

	@When("^user enter referrer ir id \"([^\"]*)\"$")
	public void user_enter_referrer_ir_id(String id) throws Throwable {
	    
		registrationPgObjects.enterID(id);
	}

	@When("^user enter name \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enter_name(String title, String fname, String lname) throws Throwable {
		registrationPgObjects.selectTitle(title);
		registrationPgObjects.enterFName(fname);
		registrationPgObjects.enterLName(lname);
	    
	}

	@When("^user select date of birth \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_select_date_of_birth(String year, String month, String date) throws Throwable {
		registrationPgObjects.enterBday(date+"/"+month+"/"+year);
	    
	}

	@When("^user select language \"([^\"]*)\"$")
	public void user_select_language(String language) throws Throwable {
		registrationPgObjects.selectLanguage(language);
	    
	}

	@When("^user enter mobile phone no \"([^\"]*)\"$")
	public void user_enter_mobile_phone_no(String mobnum) throws Throwable {
		registrationPgObjects.enterMobNum("9477818"+String.valueOf(TpGenerator.getTP(9000, 1000)));
	    
	}

	@When("^user enter PWD \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enter_PWD(String pass, String repass) throws Throwable {
		registrationPgObjects.enterPassword(pass);
		registrationPgObjects.reenterPassword(repass);
	    
	}

	@When("^user enter Address \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enter_Address(String add, String city, String postal) throws Throwable {
		registrationPgObjects.enterAddressL1(add);
		registrationPgObjects.reenterCity(city);
		registrationPgObjects.enterPCode(postal);
		
	    
	}
	@When("^user enter bank details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enter_bank_details(String bankName, String branchName, String accNo, String email) throws Throwable {
		registrationPgObjects.enterEmail(email);
		registrationPgObjects.reenterEmail(email);
		registrationPgObjects.selectBankName(bankName);
		registrationPgObjects.enterBranch(branchName);
		registrationPgObjects.enterACN(accNo);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		registrationPgObjects.clickContinueBtn();
		Thread.sleep(3000);
	}

	

	@Then("^Accept terms and conditions$")
	public void accept_terms_and_conditions() throws Throwable {
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		registrationPgObjects.acceptTC();
		jse.executeScript("window.scrollBy(0,200)", "");
		//registrationPgObjects.clickCloseChat();
		//Thread.sleep(5000);
		registrationPgObjects.clickAcceptBtn();
		Thread.sleep(40000);
		
		//jse.executeScript("window.scrollBy(0,300)", "");
		
	    
	}
	
	@Then("^Enter ecard details and validate \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_ecard_details_and_validate(String no, String pin) throws Throwable {
		
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);
		registrationPgObjects.enterGLVoucherNum(no);
		registrationPgObjects.enterGLVoucherPIN(pin);
		//jse.executeScript("window.scrollBy(0,200)", "");
	    
	}
	@Then("^Enter ecard details and validate two \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_ecard_details_and_validate_two(String no, String pin) throws Throwable {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);
		registrationPgObjects.enterGLVoucherNum(no);
		registrationPgObjects.enterGLVoucherPIN(pin);
		jse.executeScript("window.scrollBy(0,200)", "");
	}


	@Then("^Click on confirm button$")
	public void click_on_confirm_button() throws Throwable {
		registrationPgObjects.clickValidateBtn();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(40000);
		registrationPgObjects.clickConfirmBtn();
	    
	}

	@Then("^Validate the Auto Login \"([^\"]*)\"$")
	public void validate_the_Auto_Login(String content) throws Throwable {
		Thread.sleep(30000);
		regConfirmationPgObjects.clickCloseVO();
		Thread.sleep(30000);
	    Assert.assertEquals("Validate the Auto Login", content, regConfirmationPgObjects.getContent());
	    
	}
	
	@When("^user enter conpany details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enter_conpany_details(String comname, String desig, String contp) throws Throwable {
		registrationPgObjects.enterCompanyName(comname);
		registrationPgObjects.enterDesignation(desig);
		registrationPgObjects.enterContactPerson(contp);
	}
	@When("^user click on become a Retail Customer$")
	public void user_click_on_become_a_Retail_Customer() throws Throwable {
	    logInPgObjects.clickRetailBtn();
	}
	@When("^enter email \"([^\"]*)\"$")
	public void enter_email(String email) throws Throwable {
		registrationPgObjects.enterEmail(email);
		registrationPgObjects.reenterEmail(email);
		
		
	}
	@When("^click continue btn$")
	public void click_continue_btn() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(3000);
		registrationPgObjects.clickContinueBtn2();
		Thread.sleep(3000); 
	}

@Then("^Accept terms$")
public void accept_terms() throws Throwable {
	Thread.sleep(5000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(5000);
	registrationPgObjects.acceptTC2();
	jse.executeScript("window.scrollBy(0,200)", "");
	//registrationPgObjects.clickCloseChat();
	Thread.sleep(5000);
	registrationPgObjects.clickAcceptBtn2();
	Thread.sleep(25000);
}



@When("^user enter valid credentials \"([^\"]*)\" \"([^\"]*)\"$")
public void user_enter_valid_credentials(String id, String pss) throws Throwable {
	driver.manage().window().maximize();
    logInPgObjects.enterID(id);
    logInPgObjects.enterPassword(pss);
    logInPgObjects.clickLogInBtn();
    Thread.sleep(20000);
    
}

@When("^user click on products tab$")
public void user_click_on_products_tab() throws Throwable {
    homePgObjects.clickProductsTab();
    
}

@When("^user click on products link$")
public void user_click_on_products_link() throws Throwable {
    homePgObjects.clickSITEQLIK();
    
}

@When("^user add products to the cart$")
public void user_add_products_to_the_cart() throws Throwable {
	Thread.sleep(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,900)", "");
	Thread.sleep(3000);
    productsPgObjects.clickProd1();
    Thread.sleep(3000);
   
}

@When("^user click on shopping cart$")
public void user_click_on_shopping_cart() throws Throwable {
    productsPgObjects.clickCart();
    
}

@When("^user click on checkout button$")
public void user_click_on_checkout_button() throws Throwable {
    productsPgObjects.clickCheckOut();
    Thread.sleep(3000);
    driver.manage().window().maximize();
    checkOutPgObjects.acceptTC();
    checkOutPgObjects.clickProceedCheckOut();
    Thread.sleep(8000);
}

@When("^select delivery option and click checkout \"([^\"]*)\"$")
public void select_delivery_option_and_click_checkout(String dilivery) throws Throwable {
	/*checkOutPgObjects.selectDeliveryOption(dilivery);
    Thread.sleep(3000);*/
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,600)", "");
	Thread.sleep(2000);
    checkOutPgObjects.clickCheckOutSelectPayment();
}
@When("^select delivery option and click checkout preprod \"([^\"]*)\"$")
public void select_delivery_option_and_click_checkout_preprod(String arg1) throws Throwable {
	 checkOutPgObjects.clickCheckOutSelectPayment();
}

@When("^User distribute the BVs and click on countinue$")
public void user_distribute_the_BVs_and_click_on_countinue() throws Throwable {
	Thread.sleep(2000);
	checkOutPgObjects.clickBC02();
    //Thread.sleep(2000);
    checkOutPgObjects.clickBC02();
   // Thread.sleep(2000);
    checkOutPgObjects.clickBC02();
   // Thread.sleep(2000);
    checkOutPgObjects.clickBC02();
   // Thread.sleep(2000);
    checkOutPgObjects.clickBC02();
   // Thread.sleep(2000);
    
    checkOutPgObjects.clickBC03();
   // Thread.sleep(2000);
    checkOutPgObjects.clickBC03();
  //  Thread.sleep(2000);
    checkOutPgObjects.clickBC03();
   // Thread.sleep(2000);
   checkOutPgObjects.clickBC03();
  //  Thread.sleep(2000);
    checkOutPgObjects.clickBC03();
  //Thread.sleep(2000);
  checkOutPgObjects.clickBC03();
  //Thread.sleep(2000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	Thread.sleep(20000);
    checkOutPgObjects.clickContinue();
    
}
@When("^Enter ecard details \"([^\"]*)\" \"([^\"]*)\"$")
public void enter_ecard_details(String no, String pin) throws Throwable {
	Thread.sleep(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	Thread.sleep(5000);
	registrationPgObjects.enterGLVoucherNum2(no);
	registrationPgObjects.enterGLVoucherPIN2(pin);
	Thread.sleep(3000);
	registrationPgObjects.clickValidateBtn2();
	Thread.sleep(10000);
}
@When("^Enter Ecard two \"([^\"]*)\" \"([^\"]*)\"$")
public void enter_Ecard_two(String no, String pin) throws Throwable {
	Thread.sleep(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	Thread.sleep(5000);
	registrationPgObjects.enterGLVoucherNum2(no);
	registrationPgObjects.enterGLVoucherPIN2(pin);
	Thread.sleep(3000);
	registrationPgObjects.clickValidateBtn2();
	Thread.sleep(10000);
}

@When("^Click on confirm button(\\d+)$")
public void click_on_confirm_button(int arg1) throws Throwable {
	
	registrationPgObjects.clickConfirmBtn2();
	Thread.sleep(10000);
}
@When("^user click on forgot pwd$")
public void user_click_on_forgot_pwd() throws Throwable {
	driver.manage().window().maximize();
    logInPgObjects.clickForgotPass();
    
}

@When("^user enter customer IR ID \"([^\"]*)\"$")
public void user_enter_customer_IR_ID(String value) throws Throwable {
	forgotPasswordPgObjects.enterBAID(value);
    
}

@When("^click on submit button$")
public void click_on_submit_button() throws Throwable {
    forgotPasswordPgObjects.clickSubmit();
    Thread.sleep(3000);
    
}

@Then("^Click on countinue button$")
public void click_on_countinue_button() throws Throwable {
	Thread.sleep(3000);
	forgotPasswordPgObjects.clickContinue();
	 
    
}

@Then("^Click on Ok button on popup$")
public void click_on_Ok_button_on_popup() throws Throwable {
	Thread.sleep(3000);
	forgotPasswordPgObjects.clickOk();
	
}

@Then("^select delivery option kit \"([^\"]*)\"$")
public void select_delivery_option_kit(String arg1) throws Throwable {
	Thread.sleep(25000);
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
  checkOutPgObjects.selectDeliveryOption2(arg1);
  Thread.sleep(3000);
  checkOutPgObjects.clickCheckOutSelectPayment();
}

@Then("^select delivery option item \"([^\"]*)\"$")
public void select_delivery_option_item(String arg1) throws Throwable {
	 checkOutPgObjects.selectDeliveryOption2(arg1);
	 Thread.sleep(3000);
	 
}
@Then("^click on virtual office link$")
public void click_on_virtual_office_link() throws Throwable {
    homePgObjects.clickVirtualOffice();
    Thread.sleep(5000);
}

@Then("^user direct to the VO page \"([^\"]*)\"$")
public void user_direct_to_the_VO_page(String url) throws Throwable {
	Thread.sleep(10000);
	TabCatcher.setBaseTab();
   Assert.assertEquals("Validate VO2 Page", url, driver.getCurrentUrl());
}
@When("^remove Items from cart$")
public void remove_Items_from_cart() throws Throwable {
	if(homePgObjects.getItemValue()>0){
	productsPgObjects.clickCart();
	Thread.sleep(2000);
	homePgObjects.removeItems();
	}
}

@When("^Select chash payments$")
public void select_chash_payments() throws Throwable {
  checkOutPgObjects.clickCashPayment();
  Thread.sleep(5000);
}

@When("^Click on confirm cash payment$")
public void click_on_confirm_cash_payment() throws Throwable {
	checkOutPgObjects.ConfirmCashPayment();
}

@Then("^Validate Payment$")
public void validate_Payment() throws Throwable {
	 Thread.sleep(5000);
   Assert.assertEquals(checkoutConfirmationPgObjects.GetOrderDetails(), "ORDER DETAILS");
}
}
