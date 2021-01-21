package com.testautomationguru.container.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testautomationguru.container.pages.SearchPage;

public class SearchTest extends BaseTest throws MalformedURLException {

    private SearchPage google;

    @BeforeTest
    public void setUp()  {
        System.out.println("before test");  
     //  google = new SearchPage(driver);//= new SearchPage(driver)
    }

   @Test()
    public void googleTest() {
        super.setUp();
        driver.get("https://www.google.com");  
        // get the current URL of the page  
        String URL= driver.getCurrentUrl();  
        System.out.print(URL);  
        //get the title of the page  
        String title = driver.getTitle();                  
        System.out.println(title);  
        if(title.equals("Google"))
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);
   
    }
    /*@Test()
    public void googleTest() {
        if(google.checkTitle().equals("Google"))
        Assert.assertTrue(true);
        else
        Assert.assertTrue(false);
        
   
    }*/
    
    
   

}
