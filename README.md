# ShoppingCartCheckout

A simple checkout system for a shop selling **apples** and **oranges**, implemented in Java with **TDD approach**.
---
## Project Structure
ShoppingCartCheckout/
 src/main/java/com/example/checkout/core/Checkout.java          # Interface

 src/main/java/com/example/checkout/impl/SimpleCheckout.java    # Implementation

 src/test/java/com/example/checkout/CheckoutTest.java           # Unit tests
 
## Features

- Calculate total cost of items in the cart.
- Supports two types of fruits:
  - **Apple**: £0.60
  - **Orange**: £0.25
- Simple offers applied:
  - **Buy One Get One Free (BOGO)** on Apples
  - **3 for 2** on Oranges
- Edge cases handled:
  - Empty cart returns £0.00
  - Unknown items are ignored
  - Case-insensitive item names
  - Large mixed carts with multiple offers
  - Odd number of apples for BOGO offer

---

## Requirements / Software Needed

To run this project, you will need:

1. **Java JDK 17 or higher** – for compiling and running the Java code.  
   [Download JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  

2. **Apache Maven 3.6+** – for building the project and running tests.  
   [Download Maven](https://maven.apache.org/download.cgi)  

3. **IntelliJ IDEA (Community or Ultimate Edition)** – recommended IDE for development and running tests.  
   [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

---

## Steps to Run the Project

### 1. Clone the Repository

git clone https://github.com/prasadduddi/ShoppingCartCheckout.git

cd ShoppingCartCheckout

### Build the Project

mvn clean compile

### Run Unit Tests
All functionality and offers are tested using JUnit 5:

mvn test