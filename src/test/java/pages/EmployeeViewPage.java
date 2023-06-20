package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeViewPage extends CommonMethods {

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//table[@id='table']/tbody/tr/td[2]")
    public WebElement tableDta;
    @FindBy(xpath = "//table[@id='table']/tbody/tr/td[2]")
    public WebElement fullName;
    public EmployeeViewPage(){
        PageFactory.initElements(driver, this);
    }

}


