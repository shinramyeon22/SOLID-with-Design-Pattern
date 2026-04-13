public class TestProgram {
    public static void main(String[] args) {
        Student student = new Student("Claryss Mae P.");

        LibraryResource book = new Book("SOLID Principles in Object-oriented Programming");
        LibraryResource journal = new Journal("NEU Research Journal - April 2026");

        student.borrowResource(book);
        student.borrowResource(journal);

        LibraryResource audioBook = new AudioBook("Advanced SOLID Lecture Series");
        student.borrowResource(audioBook);

    }
}