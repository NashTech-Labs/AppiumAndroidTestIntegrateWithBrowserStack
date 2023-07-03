# Appium Android Test Integrate With BrowserStack

# Introduction
This template will help you implement how to run and test their automated Android Appium tests through a BrowserStack. In this project, I also implement Page Object Model, also known as POM, because it helps to reduce code duplication and improves test case maintenance.
# What is the Browserstack, and why do we need to run our test on Browserstack?
This is a basic question that almost everyone has, such as why we need and utilize them; therefore, let's just define it in one sentence: "BrowserStack is an Indian cloud web and mobile testing platform that provides developers with the ability to test their websites and mobile applications across on-demand browsers, operating systems, and real mobile devices".

# Technologies Used
> Programming language - Java

> Automation tool - Appium, Selenium, Junit, and Cucumber

> IDE - Intellij 
# Libraries Used
# Appium 
    import io.appium.java_client.TouchAction;
    import io.appium.java_client.android.AndroidDriver;
# Cucumber
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
# Junit    
    import org.junit.Assert;   
# Selenium    
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;   
    
# Steps for execution
Clone the repository on your local system. Intellij will resolve all the required dependencies.
# Create a BrowserStack account
To begin the setup first, You will require an **access key** and a BrowserStack **username**. You must register for a free trial or buy a plan in order to get your access credentials
# Run the Android test with the maven command like this:
    mvn -Dtest=cucumberOptions.TestRunner  test
Once the test execution begins, either locally or through an IDE, you can view the live execution on the BrowserStack dashboard.    

you can change the code and target the website as per your needs.

For a better understanding please refer to this blog:- [click here](https://blog.nashtechglobal.com/how-to-write-your-first-android-appium-test-on-browserstack-a-step-by-step-guide/)
