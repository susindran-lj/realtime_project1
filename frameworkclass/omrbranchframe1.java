package frameworkclass;

import java.io.IOException;
import org.openqa.selenium.WebElement;

public class omrbranchframe1 extends baseclass1{

public static void main(String[] args) throws IOException {
	omrbranchframe1 of1=new omrbranchframe1();
	of1.productorder();
	
}
public void productorder() throws IOException {
	
	launchchrome();
	
	enterurl("https://omrbranch.com/");
	
	maximizewindow();
	
	implicitywait(30);
	
	WebElement txtmail=findlocatorbyid("email");
	elementsendkeys(txtmail, getcelldata("login", 1, 0));
	
	WebElement txtpass=findlocatorbyid("pass");
	elementsendkeys(txtpass, getcelldata("login", 1, 1));
	
	WebElement loginbut=findlocatorbyxpath("//button[text()='Login']");
	clickbutton(loginbut);
	
	implicitywait(30);
	
	WebElement element=findlocatorbyxpath("//a[contains(text(),'Welcome')]");
	System.out.println(gettext(element));
	
	WebElement search=findlocatorbyname("search");
	elementsendkeys(search, getcelldata("login", 1, 2)); 

	WebElement enter=findlocatorbyxpath("//button[@type='submit']");
	clickbutton(enter);
	
	WebElement searchresultnuts=findlocatorbyxpath("//h5[contains(text(),'Search Result - nuts')]");
	System.out.println(gettext(searchresultnuts));
	
	

}

}