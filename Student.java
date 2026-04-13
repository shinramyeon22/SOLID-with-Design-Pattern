public class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowResource(LibraryResource resource) {
        System.out.println(getName() + " is attempting to borrow: " + resource.getTitle());
        if (resource.borrow()) {
            System.out.println("Borrowing successful for " + getName() + "!\n");
        } else {
            System.out.println("Borrowing failed for " + getName() + "!\n");
        }
    }
}