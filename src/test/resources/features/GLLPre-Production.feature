Feature: GLL smoke test

@RegPre
Scenario Outline: Test case 01, 02, 03, 04
Given user direct to the staging site
When user click on Login or Register button
And user enter a valid ID or email "<email_ID>"
And user enter a password "<password>"
Then user click on login button
Then Validate the Auto Login "<Autologin>"


Examples:
    |email_ID| password |Autologin				  |
    |GL102223| T@stpw120 |Welcome! TRENTA ABRIL|
   |GL010456| T@stpw120 |Welcome! TEST|
   	
    
    
@RegPre
Scenario Outline: Test case 05
Given user direct to the staging site
When user click on Login or Register button
And user click on become a Bus Asso
And user select registration type "<Reg_Type>"
And user enter referrer ir id "<IR_ID>"
And user enter name "<Title>" "<FName>" "<Lname>"
And user select date of birth "<YEAR>" "<Month>" "<Date>"
And user select language "<Lang>"
And user enter mobile phone no "<Mob_no>" 
And user enter PWD "<PWD>" "<Re_PWD>" 
And user enter Address "<Address>" "<City>" "<PostCode>"
And user enter bank details "<BankName>" "<BranchName>" "<AccNo>" "<Email>"
Then Accept terms and conditions
And Enter ecard details and validate "<EcardNo>" "<PIN>"
And Click on confirm button
Then Validate the Auto Login "<Autologin>"

Examples:
    |IR_ID   |Reg_Type  |Title|FName|Lname|YEAR|Month|Date|Lang   |Mob_no     |PWD     |Re_PWD  |Address|City|PostCode|BankName           |BranchName|AccNo     |EcardNo       |PIN   |Autologin          |Email|
    |GL102223|Individual|Mr   |test |vikas|1988|05  |12  |English|94778186251|Test@135|Test@135|test   |test|0000    |MBSL - Savings Bank|Galle     |1596325874|TESTLKR0000017|QECTST|Welcome! TEST VIKAS|anidu@vikas.lk|
    
@RegPre
Scenario Outline: Test case 06
Given user direct to the staging site
When user click on Login or Register button
And user click on become a Bus Asso
And user select registration type "<Reg_Type>"
And user enter referrer ir id "<IR_ID>"
And user enter conpany details "<ComName>" "<Desig>" "<ContPer>"
And user select language "<Lang>"
And user enter mobile phone no "<Mob_no>" 
And user enter PWD "<PWD>" "<Re_PWD>" 
And user enter Address "<Address>" "<City>" "<PostCode>"
And user enter bank details "<BankName>" "<BranchName>" "<AccNo>" "<Email>"
Then Accept terms and conditions
And Enter ecard details and validate two "<EcardNo>" "<PIN>"
And Click on confirm button
Then Validate the Auto Login "<Autologin>"

Examples:
    |IR_ID   |Reg_Type|ComName     |Desig|ContPer|Lang   |Mob_no     |PWD     |Re_PWD  |Address|City|PostCode|BankName           |BranchName|AccNo     |EcardNo       |PIN   |Autologin          |Email|
    |GL010456|Company |Test Company|test |test   |English|94775841725|Test@135|Test@135|test   |test|0000    |MBSL - Savings Bank|Galle     |1596325874|TESTLKR0000017|QECTST|Welcome! TEST COMPANY|osura@vikas.lk|
        
@RegPre
Scenario Outline: Test case 07
Given user direct to the staging site
When user click on Login or Register button
And user click on become a Retail Customer
And user enter referrer ir id "<IR_ID>"
And user enter name "<Title>" "<FName>" "<Lname>"
And user select date of birth "<YEAR>" "<Month>" "<Date>"
And enter email "<Email>"
And user select language "<Lang>"
And user enter mobile phone no "<Mob_no>" 
And user enter PWD "<PWD>" "<Re_PWD>" 
And user enter Address "<Address>" "<City>" "<PostCode>"
And click continue btn
Then Accept terms
Then Validate the Auto Login "<Autologin>"


Examples:
    |IR_ID   |Title|FName|Lname  |YEAR|Month|Date|Lang   |Mob_no     |PWD     |Re_PWD  |Address|City|PostCode|Autologin            |Email|
    |GL102223|Mr   |test |vikasRC|1988|05  |12  |English|94775877588|Test@135|Test@135|test   |test|0000    |Welcome! TEST VIKASRC|osura2@vikas.lk|
 
@RegPre
Scenario Outline: Test case 14
Given user direct to the staging site
When user click on Login or Register button
And user click on forgot pwd
And user enter customer IR ID "<CUS_ID>"
And click on submit button 
Then Click on countinue button 
And Click on Ok button on popup
Examples:
    |CUS_ID   | 
	|GL102223 |
 
  
@RegPre
Scenario Outline: Test case 08
Given user direct to the staging site
When user click on Login or Register button
And user enter valid credentials "<IR_ID>" "<PWD>"
And remove Items from cart  
And user click on products tab
And user click on products link
And user add products to the cart
And user click on shopping cart
And user click on checkout button 
And select delivery option and click checkout preprod "<DE_OPTION>"
And User distribute the BVs and click on countinue
And Enter ecard details "<EcardNo>" "<PIN>"
And Click on confirm button2
Then Validate the Auto Login "<Autologin>"
 
Examples:
    |IR_ID   |PWD| DE_OPTION|EcardNo|PIN|Autologin|
	|GL102223|T@stpw120|	Global Lifestyle Lanka Head Office|TESTLKR0000020|QECTST|Welcome! TRENTA ABRIL|
  
  
@RegPre
Scenario Outline: Test case 09
Given user direct to the staging site
When user click on Login or Register button
And user enter valid credentials "<IR_ID>" "<PWD>"  
And remove Items from cart  
And user click on products tab
And user click on products link
And user add products to the cart
And user click on shopping cart
And user click on checkout button 
And select delivery option and click checkout preprod "<DE_OPTION>"
And User distribute the BVs and click on countinue
And Enter ecard details "<EcardNo>" "<PIN>"
And Click on confirm button2
Then Validate the Auto Login "<Autologin>"

  
Examples:
 	|IR_ID   |PWD| DE_OPTION|EcardNo|PIN|Autologin|
   |GL010456|T@stpw120|	Global Lifestyle Lanka Head Office|TESTLKR0000021|QECTST|Welcome! TEST|
  
    
@RegPre! 
Scenario Outline: Test case 10
Given user direct to the staging site
When user click on Login or Register button
And user enter valid credentials "<IR_ID>" "<PWD>"  
And user click on products tab
And user click on products link
And user add products to the cart
And user click on shopping cart
And user click on checkout button 
And select delivery option and click checkout preprod "<DE_OPTION>"  
And User distribute the BVs and click on countinue
And user choose credit card option
And enter Credit card details "<C_Holder>"  "<C_Num>"  "<C_Month>" "<C_Year>"  "<C_Sec_Cord>" 
Then Validate the Auto Login "<Autologin>"
    
 Examples:
    |IR_ID   |PWD|  DE_OPTION|C_Holder|C_Num|C_Month|C_Year|C_Sec_Cord|   
 
@RegPre! 
Scenario Outline: Test case 11
Given user direct to the staging site
When user click on Login or Register button
And user enter valid credentials "<IR_ID>" "<PWD>"  
And user click on products tab
And user click on products link
And user add products to the cart
And user click on shopping cart
And user click on checkout button 
And select delivery option and click checkout "<DE_OPTION>"  
And User distribute the BVs and click on countinue
And user choose Q Account option
And User enter Q Account Pin "<QA_Pin>" 
And user click on confirm button
Then Validate the Auto Login "<Autologin>"
 
  Examples:
    |IR_ID   |PWD|  DE_OPTION|QA_Pin|Autologin|
 
@RegPre
Scenario Outline: Test case 14
Given user direct to the staging site
When user click on Login or Register button
And user click on forgot pwd
And user enter customer IR ID "<CUS_ID>"
And click on submit button 
Then Click on countinue button 
And Click on Ok button on popup
Examples:
    |CUS_ID   | 
	|GL102223|
	
@RegPre
Scenario Outline: Test case 13
Given user direct to the staging site
And user click on products tab
And user click on products link
And user add products to the cart
And user click on shopping cart
And user click on checkout button
And user click on become a Bus Asso
And user select registration type "<Reg_Type>"
And user enter referrer ir id "<IR_ID>"
And user enter name "<Title>" "<FName>" "<Lname>"
And user select date of birth "<YEAR>" "<Month>" "<Date>"
And user select language "<Lang>"
And user enter mobile phone no "<Mob_no>" 
And user enter PWD "<PWD>" "<Re_PWD>" 
And user enter Address "<Address>" "<City>" "<PostCode>"
And user enter bank details "<BankName>" "<BranchName>" "<AccNo>" "<Email>"
Then Accept terms and conditions
And select delivery option kit "<DE_OPTION>"
And User distribute the BVs and click on countinue
And Enter ecard details "<EcardNo>" "<PIN>"
And Click on confirm button2
Then Validate the Auto Login "<Autologin>"	

Examples:
    |IR_ID   |Reg_Type  |Title|FName|Lname|YEAR|Month|Date|Lang   |Mob_no     |PWD     |Re_PWD  |Address|City|PostCode|BankName           |BranchName|AccNo     |EcardNo       |PIN   |Autologin          |Email|DE_OPTION|
    |GL102223|Individual|Mr   |test |vikass|1988|06  |12  |English|94763557189|Test@135|Test@135|test   |test|0000    |MBSL - Savings Bank|Galle     |1596325874|TESTLKR0000022|QECTST|Welcome! TEST VIKASS|osura@vikas.lk|Global Lifestyle Lanka Head Office|
 
 
@RegPre
Scenario Outline: Test case 16 
Given user direct to the staging site 
When user click on Login or Register button
And user enter valid credentials "<IR_ID>" "<PWD>"  
Then click on virtual office link 
And user direct to the VO page "<URL>" 

Examples:
    |IR_ID   |PWD     |URL|
    |GL102223|T@stpw120|https://portal.[myqweb.biz/VO2GLLNS4S]/#/DashBoard |
    
    