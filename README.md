# Assignment 5 — Strategy Design Pattern

**Course:** Software Design Patterns (SDP)\
**Topic:** Strategy Behavioral Design Pattern\
**Project:** Calculator System\
**Language:** Java 17\
**IDE:** IntelliJ IDEA

## 1. Project Overview

This project demonstrates the implementation of the **Strategy Design Pattern** using a Calculator System.

The system supports addition, subtraction, multiplication, and division. Each operation is implemented in a separate strategy class.

The `Calculator` class delegates calculations to the selected strategy and allows operations to be changed at runtime.

## 2. Design Pattern — Strategy

The Strategy Pattern is a behavioral design pattern that places related algorithms in separate classes and makes them interchangeable through a common interface.

In this project, the Calculator uses the `OperationStrategy` interface instead of depending on concrete strategy classes.

**Without Strategy:** Operation selection would require an `if/else` or `switch` inside the Calculator.

**With Strategy:** The client selects the operation by providing a strategy:

```java
Calculator calculator = new Calculator(new AddStrategy());
calculator.calculate(8, 2);

calculator.setStrategy(new DivideStrategy());
calculator.calculate(8, 2);
```

New operations can be added by implementing `OperationStrategy` and selecting the new strategy in the client, without modifying the Calculator.

## 3. Project Structure

```text
calculator-strategy-pattern/
├── src/
│   ├── OperationStrategy.java
│   ├── AddStrategy.java
│   ├── SubtractStrategy.java
│   ├── MultiplyStrategy.java
│   ├── DivideStrategy.java
│   ├── Calculator.java
│   └── Main.java
│
├── .gitignore
└── README.md
```

## 4. Main Components

| **Component** | **Responsibility** |
| ------------- | ------------------ |
| `Main` | Selects strategies and checks calculation results |
| `Calculator` | Stores the current strategy and delegates calculations |
| `OperationStrategy` | Defines the common `execute()` method |
| `AddStrategy` | Performs addition |
| `SubtractStrategy` | Performs subtraction |
| `MultiplyStrategy` | Performs multiplication |
| `DivideStrategy` | Performs division and checks for a zero divisor |

## 5. System Workflow

To run the project, open it in IntelliJ IDEA, select JDK 17, and run `Main.java`.

The system performs the following operations:

1. Creates a Calculator with an initial strategy.
2. Calls `calculate()` with two numbers.
3. Delegates the calculation to the strategy's `execute()` method.
4. Returns and checks the result.
5. Switches strategies using `setStrategy()` and repeats the calculation.

### Division by Zero Handling

The division strategy validates the divisor before calculating.

- **Non-zero divisor:** Returns the division result.
- **Zero divisor:** Throws an `ArithmeticException` with the message `Division by zero is not allowed.`

This validation remains inside `DivideStrategy` and does not introduce operation-selection logic into the Calculator.