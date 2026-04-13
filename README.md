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
```plantuml
@startuml
interface LibraryResource {
  + boolean borrow()
  + String getTitle()
}

class Book implements LibraryResource
class Journal implements LibraryResource

class Student {
  - name: String
  + borrowResource(LibraryResource resource)
}

Student ..> LibraryResource : depends on
Book --|> LibraryResource
Journal --|> LibraryResource
@enduml