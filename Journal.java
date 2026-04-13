public class Journal implements LibraryResource {
    private final String title;
    private boolean available = true;

    public Journal(String title) {
        this.title = title;
    }

    @Override
    public boolean borrow() {
        if (available) {
            available = false;
            System.out.println("Journal '" + title + "' has been borrowed.");
            return true;
        }
        System.out.println("Journal '" + title + "' is not available.");
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }
}