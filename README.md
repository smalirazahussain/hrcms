JDK version used = 18.0.0.1

All config is in Base Class



================================================LOCATORS=============================================

//tagname[@class='value']

//tagname[contains(text(),'value')]

By.xpath("//android.widget.TextView[@text='"+songname+"']");

By.xpath("//android.widget.TextView[@text='Update']");



By.xpath("//android.widget.TextView[@text='Tap to See Transactions']");


BY INDEX
By.XPath("//android.view.ViewGroup[2]/android.widget.EditText[@index='0']");


By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")



RUNNING CUCUMBER JSON REPORT 
mvn clean verify
mvn verify -DskipTests
=====================================================================================================


Appium Inspector Properties

{
  "platformName": "Android",
  "platformVersion": "11",
  "deviceName": "Samsung Galaxy S5",
  "automationName": "Appium",
  "app": "C:\\Users\\abc\\Desktop\\apk\\KamelPay.apk"
}

===========================================================================
