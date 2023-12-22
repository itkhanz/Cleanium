# Cleanium

This project showcases the clean coding best practices and design patterns for test automation using Java and Selenium WebDriver

## Design Patterns in Test Automation

* **Creational** - All about class and object instantiation
  * e.g. Builder, Factor
* **Structural** - Organising different classes and objects to form large structures and new functionality
  * e.g. Facade
* **Behavioral** - Common communication between objects
  * e.g. Observer, Chain of responsibility

## Builder Pattern

It is a creational design pattern

**Problem Statement**:

1. Number of parameters to constructors is more
2. Readability missing
3. Options to ignore some parameters needs additional efforts

**Usage**:

Constructing POJOs for request body in Rest Assured
* using Conventional approach
* using External Builder Class
* using Static Inner Class
* using Lombok with Builder

## Factory Pattern

Factory is a creational design pattern which is used to create different implementation objects of the same type.

**Problem Statement**:

1. A class/interface cannot anticipate the type of object it needs to create beforehand
2. A class/interface requires its subclasses to specify the object it creates

**Usage**:

* Factory Method
* Factory Method with Supplier Interface


## Resources

* [Design Patterns in Test Automation - Testing Mini Bytes](https://www.youtube.com/playlist?list=PL9ok7C7Yn9A8ewGj22MbLOyD9VCtZn7lF)
* https://medium.com/@bishu/understanding-design-patterns-in-test-automation-factory-method-pattern-54a68fbdfe00
* 
