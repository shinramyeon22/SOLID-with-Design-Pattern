# NEU Library System - Refactored with SOLID Principles (DIP)

## Problem Statement
The NEU Library offers books, journals, theses, capstones, internet access, newspapers, etc.  
The original `Student` class had methods like `borrowBook()` and `borrowJournal(title)` that **directly depended on concrete resource types**. This violates the **Dependency Inversion Principle (DIP)** and makes it impossible to add new resource types (e.g., AudioBook, EJournal) without modifying the Student class.

## Solution (using exact same DIP pattern as reference repo)
- High-level module (`Student`) now depends only on the **abstraction** `LibraryResource`.
- Concrete classes (`Book`, `Journal`) implement the interface.
- New resource types can be added **without changing any existing code**.

This follows the **exact structure** of https://github.com/JerryEsperanza/dependency:
- Interface + Concrete implementations + High-level class depending on abstraction.

## UML Class Diagram

```mermaid
classDiagram
    class LibraryResource {
        <<interface>>
        +boolean borrow()
        +String getTitle()
    }

    class Book {
        -String title
        -boolean available
        +Book(String title)
        +boolean borrow()
        +String getTitle()
    }

    class Journal {
        -String title
        -boolean available
        +Journal(String title)
        +boolean borrow()
        +String getTitle()
    }

    class Student {
        -String name
        +Student(String name)
        +String getName()
        +void borrowResource(LibraryResource resource)
    }

    class TestProgram {
        +main(String[] args)
    }

    %% Relationships (same style as your reference)
    LibraryResource <|.. Book : implements
    LibraryResource <|.. Journal : implements
    Student ..> LibraryResource : depends on
    TestProgram --> Student : uses
