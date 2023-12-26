# Cleanium

This project showcases the clean coding best practices and design patterns for test automation using Java and Selenium
WebDriver

## Code Refactoring - Testing Mini Bytes

Checkout the branch `tmb/code-refactoring` to see the learnings summary and code.

Site under test: https://demo.nopcommerce.com/

### Part 1 - What and Why | Code Refactoring | Selenium Test Automation Framework - Java |

**Code Refactoring**

* Improves Readability
* Reduces the maintenance cost
* More control to the developers
* Reduced Complexity
* Working Code -> Clean and Readable Working Code

**What We Will Learn**

* Code Refactoring Techniques
* How to understand and work with existing techniques
* IntelliJ tips and tricks
* Approaching a problem
* Intricacies of Basics of Programming

### Part 2 - Getting Started with Code refactoring | Understanding if else block in detail | Cool Tricks

**BAD Practices**

* Poor naming conventions for packages and class names
* Missing .gitignore file
* All code under test package
* Vague variable names
* Over Commenting makes the code difficult to read
* Usage of Log4J is not required when you can log directly to extent reports.
    * Handling log4j in multi threaded environment is complex
    * Use log4j if you are using any monitoring and observability tools like ELK stack

**Refactoring**

* Use IntelliJ shortcut `Shift + f6` to rename all the instances of variable
* Use IntelliJ templates to auto-fill certain texts or dependencies
* Use IntelliJ local history to undo any lost changes
* Use intelliJ shortcut `Alt + Enter` and select the code block to extract it as a separate method

**Takeaways**

* Change a little - Test a little
* Keep readability, reusability as a thumb rule
* Do everything with a reason behind it
* Think about longer run
* Use the more often used conditions on top of the if-else conditional logic
* Live Templates, Local History, and other IntelliJ tricks

### Part 3 - If Else Vs Switch - Adding abstract layer to use Third Party Libraries - Avoid Negations

**Refactoring**

* Use IntelliJ shortcut `Ctrl + Alt + O` to optimize imports
* Click on package folder ans use above shortcut to optimize imports for entire package
* Use Switch statements instead of if-else conditions if the branches are more than two. Switch is also faster
  relatively.
* Use IntelliJ shortcut `Alt + Enter` to replace the if with switch statements, and selecting replace if to switch
* Use Enums or toUpperCase() for switch statement
* Remember Single Responsibility Principle for any class or method
* Avoid negation in conditionals for better readability
* Use IntelliJ shortcut `Alt + F7` to look for method or property usage inside the project
* Create a private constructor so the usage of static methods via class instantiation can be prevented
* Make the class final so it cannot be extended
* No need to create a variable when it is not used inside method, better to return directly
* Use third party libraries with an abstract layer for easier maintenance

### Part 4 - When to use Static Methods - Pros and Cons - All you need to know

**Refactoring**

* use static methods when behavior of method is same for all threads.
* scope of static methods is tied to class, it starts when JVM starts and end when your program finishes
* static methods does not support inheritance and overriding
* you can replace constructors with static methods to initialize classes
* Create a factory class with static method to create driver

### Part 5 - How to write clean method | Clean code techniques | Rules to follow before writing a method

**Refactoring**

* Launch a separate browser driver session for each test method
* Quit the driver only if it exits
* Do not put conditional assertions
* Try to have a good readable name for methods
* Number of arguments to method should be minimal. Use Map, POJO, and Generics.
* Boolean as method argument should be avoided, instead create two separate methods
* Avoid try-catch block inside a method
* Do not call a complex method calls inside if() statement

### Part 6 | Using Inheritance in Selenium Framework | Open Closed Principle |

**Refactoring**

* Prefer to save the screenshot as Base64 Image and attach to report
* Do not use hard-coded paths
* Make the Utils Package Private so that only the abstract service layer class within same package can access these
  methods
* Start the interface name with `I` so the reader can see it as interface, and append the `Impl` to implementing classes
* A class should be open for extension but closed for modification. Therefore we created interface for config files
  reading, so each file type can implement this interface separately.

### Part 7 | What is Marker Interface | sneaky Throws | More about Open Close Principle |

**Refactoring**

* create POJO with lombok
* Use Jackson data-format to map properties to POJOs
* Use IntelliJ to surround exception throwing code block with try-catch
* Use `SneakyThrows` from lombok for managing exceptions thrown
* Use `Owner` library to read properties files
* Create Interfaces for reading configuration files and write type specific implementations to read config from Json,
  Properties and Yaml

### Part 8 - Config Service and Configuration Manager

**Refactoring**

* create an abstraction utility (service layer) for the properties configuration
* create a ConfigManager for all kind of configuration files
* create a thread-safe Driver Manager to manage the driver instance throughout framework

### Part 9 - Managing Page Layers using Composition - Create Dynamic Xpath and avoid multiple elements

**Refactoring**

* Improve naming conventions
* create manageable page layers (use design patterns like facade, composition)
* Do not use Selenium PageFactory (it prevents building dynamic xpath locators, and causes StaleElementException)
* Abstract the element actions inside page layers and focus on user action in tests
* create WaitFactory to handle explicit waits and waiting strategies with different wait durations
* create element actions class to handle WebElement actions with waiting
* Use IntelliJ context menu to generate Getters for By locators with builder pattern
* split page into reusable components e.g. header, leftmenu, footer

### Part 10 - Enhanced Boilerplate Framework

**Refactoring**

* This section introduced some further enhancements to the existing framework by myself
* created core framework structure which can be reused across projects
* created Element actions, driver manager, waits, and other interaction utility classes
* TODO: still needs lots of refinements like proper configuration, logging management, reporting etc.

```java
//***************************************************************
//***************** Finding Element(s) **************************
//***************************************************************
By byLocator=By.xpath("//a");
//By Default WaitStrategy.VISIBLE and WaitDuration.WAIT_MEDIUM are applied while finding the element
//Supported Wait Durations are LONG (15s), MEDIUM (10s), and SHORT (5s)
//******************* WebElement ********************************
//Supported Wait Strategies for getElement() are PRESENCE,VISIBLE, CLICKABLE, NONE, HANDLE_STALE_ELEMENT
  Find.withLocator(byLocator).getElement();
  Find.withLocator(byLocator).getElement(WaitDuration.LONG);
  Find.withLocator(byLocator).getElement(ElementWaitStrategy.CLICKABLE);
  Find.withLocator(byLocator).getElement(ElementWaitStrategy.PRESENCE,WaitDuration.SHORT);
//******************* List<WebElement> ***************************
//Supported Wait Strategies for getAllElements() are PRESENCE, VISIBLE, NONE. Default is VISIBLE
  Find.withLocator(byLocator).getAllElements();
  Find.withLocator(byLocator).getAllElements(WaitDuration.MEDIUM);
  Find.withLocator(byLocator).getAllElements(ElementsWaitStrategy.PRESENCE);
  Find.withLocator(byLocator).getAllElements(ElementsWaitStrategy.PRESENCE,WaitDuration.SHORT);

//***************************************************************
//***************** Element Actions *****************************
//***************************************************************
  By elementLocator=By.id("xyz");
  Actions.onElement(elementLocator).click();
  Actions.onElement(elementLocator).clear();
  Actions.onElement(elementLocator).type();
  String attribute=Actions.onElement(elementLocator).getAttribute("href");
  String text=Actions.onElement(elementLocator).getText();
  boolean isDisplayed=Actions.onElement(elementLocator).isDisplayed();
  boolean isEnabled=Actions.onElement(elementLocator).isEnabled();
  boolean isSelected=Actions.onElement(elementLocator).isSelected();

//****************************************************************
//***************** Dropdown (Select) Actions ********************
//****************************************************************
  By colors=By.id("oldSelectMenu");
  List<WebElement> allOptions=Actions.onDropdown(colors).getOptions();
  List<WebElement> allSelectedOptions=Actions.onDropdown(colors).getAllSelectedOptions();
  WebElement option=Actions.onDropdown(colors).getFirstSelectedOption();
  Actions.onDropdown(colors).selectByIndex(4);
  Actions.onDropdown(colors).selectByValue("6");
  Actions.onDropdown(colors).selectByText("Magenta");

//****************************************************************
//***************** Alerts Actions *****************************
//****************************************************************
  Interactions.alerts().accept();
  Interactions.alerts().dismiss();
  Interactions.alerts().type("hello");
  Interactions.alerts().getText();

//****************************************************************
//***************** Frames Actions *****************************
//****************************************************************
  Interactions.frames().switchToFrameByID("email");
  Interactions.frames().switchToFrameByName("email");
  Interactions.frames().switchToFrameByIndex(2);
  Interactions.frames().switchToFrameByElement(By.xpath("//iframe"));

//****************************************************************
//***************** Navigation Actions *****************************
//****************************************************************
  Interactions.navigation().loadUrl(ConfigService.getBaseUrl());
  Interactions.navigation().refresh();
  Interactions.navigation().navigateBackward();
  Interactions.navigation().navigateForward();

//****************************************************************
//***************** Windows Actions *****************************
//****************************************************************
  Interactions.windows().getHandles();
  Interactions.windows().getHandle();
  Interactions.windows().switchTo("handleName");
  Interactions.windows().createAndSwitchToNewWindow();
  Interactions.windows().createAndSwitchToNewTab();
  Interactions.windows().maximize();
  Interactions.windows().minimize();
  Interactions.windows().fullscreen();
  Interactions.windows().setSize(1024,768);
  Interactions.windows().getSize();
  Interactions.windows().close();


//****************************************************************
//***************** Mouse Actions *****************************
//****************************************************************
  Interactions.mouse().click(By.id("locator"));
  Interactions.mouse().doubleClick(By.id("locator"));
  Interactions.mouse().contextClick(By.id("locator"));
  Interactions.mouse().clickAndHold(By.id("locator"));
  Interactions.mouse().hover(By.id("locator"));

//****************************************************************
//***************** Keyboard Actions *****************************
//****************************************************************
// Select the Current Address using CTRL + A
  Interactions.keyboard().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).performActions();
// Copy the Current Address using CTRL + C
  Interactions.keyboard().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).performActions();
//Press the TAB Key to Switch Focus to Permanent Address
  Interactions.keyboard().sendKeys(Keys.TAB).performActions();
//Paste the Address in the Permanent Address field using CTRL + V
  Interactions.keyboard().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).performActions();

//****************************************************************
//***************** Javascript Executor Utils *****************************
//****************************************************************
  JSUtils.scrollToBottomOfPage();
  JSUtils.scrollElementIntoView(By.id("Syntax"));
  JSUtils.scrollByPixel(0,300);
```

### Part 11 - Using Generics as Method Return Type

**Refactoring**

* Use a single locator and construct XPath based on the dynamic value to fill form fields and locate the element
* Return a Generic method from the Page method that returns different page depending upon the passed class
    * This helps to get different pages based on different submenus
* Make the locators static and final to save the memory in case of parallel execution
* Add @Optional annotation to TestNG parameter to provide the default value to browser

### Part 12 - Struggling to manage Test Data Effectively in Selenium

**Refactoring**

* Provide the data to TestNG Test via DataProvider.

#### Approach 01

* Pass the data using Object[][].
* The problem with this approach is that if your test data has 100 columns/fields, then the test method parameters will
  be 100.
* This approach is therefore not good.

```java
  @DataProvider
public static Object[][]getLoginData(){
  return new Object[][]{
  {"admin@yourstore.com","admin"}
  };
  }

@Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
public void addCustomerTest(String email,String password){
  System.out.println(String.format("Email: %s, Password: %s",email,password));
  }
```

#### Approach 02

* Second approach is to return the HashMap or Map of key-value pairs. This helps to limit the number of method arguments
  to 01 as all the fields will be stored in Map itself.
* The problem with this approach is that,to fetch the value, you need to know the exact key.
* Another problem is that the type of value could be int, String or another. To solve this, you can make it as `Object`
  but then you need to be careful in future for operations such as typecasting etc.
* Therefore, this approach is also not ideal

````java
  @DataProvider
public static Object[][]getLoginData(){

  Map<String, Object> loginDataMap=Map.ofEntries(
  Map.entry("email","admin@yourstore.com"),
  Map.entry("password","admin")
  );

  return new Object[][]{
  {loginDataMap}
  };
  }

@Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
public void addCustomerTest(Map<String, Object> loginDataMap){
  System.out.printf("Email: %s, Password: %s%n",loginDataMap.get("email"),loginDataMap.get("password"));
  }
````

#### Approach 03

* Another approach is to create a POJO (with builder pattern), and pass the POJO as method argument

```java
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class UserData {
  private String email;
  private String password;
}
```

* This helps to solve the problem of knowing beforehand the key, or return type as we can simply call the getter
  rmethods.

```java
@DataProvider
public static Object[][]getLoginData(){

  UserData userData=UserData
  .builder()
  .setEmail("admin@yourstore.com")
  .setPassword("admin")
  .build();

  return new Object[][]{
  {userData}
  };
  }

@Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
public void addCustomerTest(UserData userData){
  System.out.printf("Email: %s, Password: %s%n",userData.getEmail(),userData.getPassword());
  }
```

* You can also optimize this entity by creating a POJO with nested classes. For example, here a UserData parent class
  consists of two entities LoginData, and CustomerData.

```java

@Getter
@Builder(setterPrefix = "set")
public class UserData {
  private LoginData loginData;
  private CustomerData customerData;
}
```

* You can create the data for both and pass the parent class as a Test method argument.

```java
@DataProvider
public static Object[][]getLoginData(){

  LoginData loginData=LoginData.builder().setEmail("admin@yourstore.com").setPassword("admin").build();
  CustomerData customerData=CustomerData.builder().setEmail("abc@gmail.com").setPassword("xxx").setGender("male").build();
  UserData userData=UserData
  .builder()
  .setLoginData(loginData)
  .setCustomerData(customerData)
  .build();

  return new Object[][]{
  {userData}
  };
  }

@Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
public void addCustomerTest(UserData userData){
  System.out.printf("Email: %s, Password: %s%n",userData.getLoginData().getEmail(),userData.getLoginData().getPassword());
  }
```

* To keep the methods clean, instead of passing the email, and password separately to the page method of performing
  login, just pass the entity, and then extract the email and password within the login method itself.

```java
  public DashboardPage performLogin(LoginData loginData){
  return setEmail(loginData.getEmail()).setPassword(loginData.getPassword()).clickLogin();
  }
```

```java
  @Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
public void test_add_customer(UserData userData){
  String alertText=new LoginPage()
  .performLogin(userData.getLoginData())
  .navigateCustomersPage()
  .navigateToAddNewCustomerPage()
  .addNewCustomer(userData.getCustomerData())
  .getAlertText();

  assertThat(alertText).contains("The new customer has been added successfully");
  }
```

* It is always good to create methods that does not accept any parameters. To refactor the existing `setEmail(String
  email)`, and `setPassword(String password)` methods in our `LoginPage`, we create a parameterized constructor of
  LoginPage
  and pass the test data at the time of creation of the LoginPage, so that the login data is accessible to the whole
  page.
* This allows all the methods in this page to have access to email and password without needing to pass them explicitly
  as parameter.
* You can also go a step ahead, and create a helper static method that returns the new instance of LoginPage to make
  code more readable.

```java
public final class LoginPage {
  private String email;
  private String password;

  private LoginPage(LoginData loginData) {
    this.email = loginData.getEmail();
    this.password = loginData.getPassword();
  }

  public static LoginPage createUsing(LoginData loginData) {
    return new LoginPage(loginData);
  }

  //locators and methods
}
```

```java
  @Test(dataProvider = "getLoginData", dataProviderClass = UserDataProvider.class)
public void test_add_customer(UserData userData){
  String alertText=LoginPage.createUsing(userData.getLoginData())
  .performLogin()
  .navigateCustomersPage()
  .navigateToAddNewCustomerPage()
  .addNewCustomer(userData.getCustomerData())
  .getAlertText();

  assertThat(alertText).contains("The new customer has been added successfully");
  }
```

* Add a new customer data using faker library to create fake email and passwords
* To generate the gender(Male/Female), make use of java Random util to create random gender.
* You can further optimize the DataProvider and Excel test data with the usage of libraries:
    * [Test Data Supplier](https://github.com/sskorol/test-data-supplier) helps to supply test data in a more flexible
      way.
    * [Poiji](https://github.com/ozlerhakan/poiji) is a tiny thread-safe Java library that provides one way mapping from
      Excel sheets to Java classes.

### Part 13 - Polymorphism in Selenium Framework | Choose different behaviors at runtime

**Refactoring**

* 

### Part 14 - Passing Behaviours To Test using Data Provider

###         

###

## Resources

* [Code Refactoring - Testing Mini Bytes](https://www.youtube.com/playlist?list=PL9ok7C7Yn9A9UGTiBDsbW9MZVHH_cgrDa)
* [Starter Framework](https://github.com/pavanoltraining/nopCommerceV1/tree/master)
* [Refactored Framework](https://github.com/amuthansakthivel/SeleniumFramework/tree/main)
* []()