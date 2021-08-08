package com.pagesPF;

import com.dataproviderUtilities.ConfigFileReader;
import com.helperUtilities.LoggerHelper;
import com.managersUtilities.CommonFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DIL_loginpage {

    WebDriver driver;
    public ConfigFileReader configFileReader;
    Logger log = LoggerHelper.getLogger(DIL_loginpage.class);

    public DIL_loginpage(WebDriver driver) {
        this.driver = driver;
        configFileReader = new ConfigFileReader();

    }

    @FindBy(how = How.XPATH, using = "//*[text()='User name']/following-sibling::input")
    WebElement dilUserName;
    @FindBy(how = How.XPATH, using = "//*[text()='Password']/following-sibling::input")
    WebElement dilPassword;
    @FindBy(how = How.XPATH, using = "//*[text()=' Login ']")
    WebElement loginBtn;

    String userName="document.querySelector(\"body > div > div:nth-child(2) > div > div > div.login-section-field > div:nth-child(1) > scale-text-field > div\")";

    public void loginToDIL() throws InterruptedException {

        System.out.println(driver.manage().window().getSize());
         dilUserName.sendKeys(configFileReader.getProperties().getProperty("dilUsrNm"));
         CommonFunction.waitForElementToAppear(driver, dilPassword);
         dilPassword.sendKeys(configFileReader.getProperties().getProperty("dilPwd"));
         CommonFunction.waitForElementToAppear(driver, loginBtn);
         CommonFunction.clickForceFully(driver,loginBtn);
         log.info("User is logged into DIL UI with userId-->" + configFileReader.getProperties().getProperty("dilUsrNm"));


    }

}
