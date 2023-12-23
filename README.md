# Cleanium

This project showcases the clean coding best practices and design patterns for test automation using Java and Selenium WebDriver


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
* Use Switch statements instead of if-else conditions if the branches are more than two. Switch is also faster relatively.
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
* 

### Part 5 - How to write clean method | Clean code techniques | Rules to follow before writing a method

**Refactoring**

* Launch a separate browser driver session for each test method
* Quit the driver only if it exits
* Do not put conditional assertions
* Try to have a good readable name for methods
* Number of arguments to method should be minimal. Use Map, POJO, and Generics.
* Boolean as method argument should be avoided, instead create two separate methods
* Avoid try-catch block inside a method
* 
* 

### Part 6 | Using Inheritance in Selenium Framework | Open Closed Principle |

### Part 7 | What is Marker Interface | sneaky Throws | More about Open Close Principle |

### Part 8 - Config Service and Configuration Manager

### Part 9 - Managing Page Layers using Composition - Create Dynamic Xpath and avoid multiple elements

### Part 10 - Using Generics as Method Return Type

### Part 11 - Struggling to manage Test Data Effectively in Selenium - Learn it now in 30 min

### Part 12 - Polymorphism in Selenium Framework | Choose different behaviors at runtime | Clean code |

### Part 13 - Passing Behaviours To Test using Data Provider - Clean Code - Refactoring Selenium Code

### 

###

## Resources

* [Code Refactoring - Testing Mini Bytes](https://www.youtube.com/playlist?list=PL9ok7C7Yn9A9UGTiBDsbW9MZVHH_cgrDa)
* [Starter Framework](https://github.com/pavanoltraining/nopCommerceV1/tree/master)
* [Refactored Framework](https://github.com/amuthansakthivel/SeleniumFramework/tree/main)
* []()