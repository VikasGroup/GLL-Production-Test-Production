package util;



import java.util.Set;

import org.openqa.selenium.WebDriver;

import net.gll.test.gll.test.steps.Gllsteps;






public class TabCatcher {
	
	public static void setBaseTab(){
		WebDriver driver=Gllsteps.driver;
			Set<String> set = driver.getWindowHandles();
			driver.switchTo().window((String) set.toArray()[1]);
			
	}
	

}
