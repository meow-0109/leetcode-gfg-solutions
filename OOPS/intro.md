Introduction to OOPs in Java
What is OOP?

OOP (Object-Oriented Programming) is a programming paradigm where programs are designed using objects and classes.

Java is mainly based on OOP concepts.

Instead of writing everything as functions, we model real-world entities like:

Student
Car
Bank Account
Employee

as objects.
```
Real Life Example

Think about a Car.

A car has:

Properties (Data)
color
brand
speed
Behaviors (Functions)
start()
brake()
accelerate()

In Java:

Class → Blueprint of a car
Object → Actual car created from blueprint
Class and Object
Class
```
A class is a blueprint/template.
```java
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Car is driving");
    }
}
```
Object

Object is an instance of a class.
```java
public class Main {
    public static void main(String[] args) {

        Car c1 = new Car();

        c1.color = "Red";
        c1.speed = 120;

        c1.drive();
    }
}
```
4 Main Pillars of OOP
1. Encapsulation
Meaning

Wrapping data and methods together into a single unit.

Also used for data hiding using private variables.

Example
```java
class Student {

    private int marks;

    public void setMarks(int m) {
        marks = m;
    }

    public int getMarks() {
        return marks;
    }
}
```
Why?
Security
Controlled access
Better maintainability
2. Inheritance
Meaning

One class acquires properties and methods of another class.

Example
```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}


class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```
Benefit
Code reusability
Reduces duplication
3. Polymorphism
Meaning

"Many forms"

Same method behaves differently.

Method Overloading (Compile Time)
```java
class MathOp {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
Method Overriding (Runtime)
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```
4. Abstraction
Meaning

Hiding implementation details and showing only essential features.

Achieved using:

Abstract classes
Interfaces
Abstract Class Example
```java
abstract class Vehicle {

    abstract void start();
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car starts with key");
    }
}
```
Interface Example
```java
interface Animal {

    void sound();
}

class Dog implements Animal {

    public void sound() {
        System.out.println("Bark");
    }
}
```
OOP Concepts Summary
Concept	Purpose
Class	Blueprint
Object	Instance of class
Encapsulation	Data hiding
Inheritance	Reuse code
Polymorphism	Multiple behaviors
Abstraction	Hide complexity
Why OOP is Important
Advantages
Reusable code
Easy maintenance
Better structure
Scalable applications
Real-world modeling
Security using encapsulation
Small Complete Example
```java
class Person {

    String name;

    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Rutuja");

        p1.display();
    }
}
```
Important Interview Question
Difference Between Class and Object
Class	Object
Blueprint	Real instance
Logical entity	Physical entity
No memory allocated	Memory allocated
Java OOP Flow
```
Class → Object → Methods → Interaction
```
Next Topics You Should Learn
Constructor
this keyword
static keyword
Access modifiers
Inheritance types
super keyword
Abstract class vs Interface
Method overriding
Runtime polymorphism
Exception handling
