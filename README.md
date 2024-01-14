# Java-Final-Assignment

Java assignment, Software Development

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

# Project Name

A brief description of your application, including its purpose and overall functionality.

## Table of Contents

- [Design Patterns](#design-patterns)
  - [Creational Patterns](#creational-patterns)
  - [Structural Patterns](#structural-patterns)
  - [Behavioral Patterns](#behavioral-patterns)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Contributions](#contributions)
- [Authors and Acknowledgments](#authors-and-acknowledgments)

## Design Patterns

### Creational Patterns

#### Factory Method

- _Description_: This pattern provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.
- _Implementation in the Project_:
  - _AdminFactory and StudentFactory_: These classes are responsible for creating instances of Admin and Student, respectively.
  - _Benefits_: Allows flexibility in creating different types of users and facilitates future expansion to new user types.

#### Singleton

- _Description_: Ensures a class has only one instance and provides a global point of access to it.
- _Implementation in the Project_:
  - _BookRequestManager_: This class manages all book requests and is implemented as a Singleton to ensure a single centralized instance.
  - _Benefits_: Maintains consistent state management of book requests across the application.

### Structural Patterns

#### Proxy

- _Description_: Provides a substitute or placeholder for another object to control access to it.
- _Implementation in the Project_:
  - _BookRequestProxy_: Controls access to operations in BookRequestManager, allowing only administrators to add requests.
  - _Benefits_: Enhances security by preventing unauthorized users from performing critical operations.

### Behavioral Patterns

#### Command

- _Description_: Turns a request or simple operation into an object.
- _Implementation in the Project_:
  - _LendBookCommand, ReturnBookCommand_: These commands encapsulate actions on books that can be executed later.
  - _Benefits_: Allows object parameterization based on an action and is useful for implementing functionalities like undo/redo.

#### State

- _Description_: Allows an object to alter its behavior when its internal state changes.
- _Implementation in the Project_:
  - _ApprovedState, PendingState, RejectedState_: Manage the state of book requests in BookRequestContext.
  - _Benefits_: Simplifies code by eliminating complex conditionals and clarifying state transitions.

#### Strategy

- _Description_: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
- _Implementation in the Project_:
  - _ApprovedRequestFilterStrategy, PendingRequestFilterStrategy, RejectedRequestFilterStrategy_: Strategies for filtering book requests in BookRequestManager.
  - _Benefits_: Offers flexibility by allowing the filtering algorithm to be changed at runtime.

## Project Structure

Describe how your project is organized. Include details about the directory structure and any relevant information on navigating the code.

## Authors

Spirow73
