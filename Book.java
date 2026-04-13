public class Book implements LibraryResource {
    private final String title;
    private boolean available = true;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean borrow() {
        if (available) {
            available = false;
            System.out.println("Book '" + title + "' has been borrowed.");
            return true;
        }
        System.out.println("Book '" + title + "' is not available.");
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }
}