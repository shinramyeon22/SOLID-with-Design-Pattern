public class AudioBook implements LibraryResource {
    private final String title;
    private boolean available = true;

    public AudioBook(String title) { this.title = title; }

    @Override
    public boolean borrow() {
        if (available) {
            available = false;
            System.out.println("AudioBook '" + title + "' has been borrowed (digital access granted).");
            return true;
        }
        return false;
    }

    @Override
    public String getTitle() { return title; }
}