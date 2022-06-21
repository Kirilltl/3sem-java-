public class Book {
    private String name;
    private String authorName;
    private int yearValue;

    public Book(String name, String authorName, int yearValue) {
        this.name = name;
        this.authorName = authorName;
        this.yearValue = yearValue;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYearValue() {
        return yearValue;
    }

    public String toString() {
        return "Book {" + "name = " + name + ", authorName = " + authorName + ", yearValue = " + yearValue + "}";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setYearValue(int yearValue) {
        this.yearValue = yearValue;
    }
}