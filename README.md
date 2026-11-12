<div align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&weight=600&size=26&duration=3000&pause=1000&color=6DB33F&center=true&vCenter=true&width=720&height=55&lines=%F0%9F%8C%BF+Hi+Sir+Junz!+Welcome+to+my+Repository+%F0%9F%8C%BF;%F0%9F%8D%83+Campus+Cafe+Ordering+System+%F0%9F%8D%83" alt="Spring Green Leaf Typing Animation" />
</div>

<br>

<p align="center">
  🌿 <b>A console-based Java application implementing Object-Oriented Programming (OOP) principles, inheritance, validation logic, and precise receipt generation.</b> 🌿
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-6DB33F?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java Badge" />
  <img src="https://img.shields.io/badge/Ecosystem-Spring_Boot_Style-32CD32?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot Green Badge" />
  <img src="https://img.shields.io/badge/Data_Structure-Fixed_Composition-2E8B57?style=for-the-badge" alt="Data Structure Badge" />
  <img src="https://img.shields.io/badge/IDE-IntelliJ_IDEA-006400?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="IntelliJ Badge" />
</p>

---

## 🌿 About The Project
The **Campus Cafe System** is designed to manage customer orders, menu items (`Beverage`, `Pastry`, `Meal`), item validations, pricing rules, student discounts, vouchers, and loyalty points. It ensures precise console output formatting matching the laboratory requirements.

## 🍃 Core Data Structure & Object Architecture

### 1. Order Data Structure Diagram (No Collections/Arrays)
As per the laboratory specification prohibiting dynamic arrays or collections, the `Order` class uses a **fixed-capacity compositional data structure** containing dedicated field references (`item1`, `item2`, `item3`) governed by an `itemCount` tracking mechanism:

```mermaid
classDiagram
    class Order {
        -int orderId
        -Customer customer
        -MenuItem item1
        -MenuItem item2
        -MenuItem item3
        -int itemCount
        +addItem(MenuItem item) boolean
        +computeSubtotal() double
        +printReceipt(double voucher, MenuItem extraItem) void
    }

    class Customer {
        -String name
        -boolean isStudent
        -int loyaltyPoints
    }

    class MenuItem {
        <<abstract>>
        #String code
        #String name
        #double basePrice
    }

    Order "1" --> "1" Customer : references
    Order "1" --> "0..1" MenuItem : item1
    Order "1" --> "0..1" MenuItem : item2
    Order "1" --> "0..1" MenuItem : item3
