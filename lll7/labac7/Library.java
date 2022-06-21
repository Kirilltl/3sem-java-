import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
public class Library {
    private final ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }

    public void readFromFilePath(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] strings = line.split(", ");
            books.add(new Book(strings[0], strings[1], Integer.parseInt(strings[2])));
        }
        bufferedReader.close();
        fileReader.close();
    }

    public void writeToFilePath(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path,true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Book book : books) {
                printWriter.printf("%s, %s, %d\n", book.getName(), book.getAuthorName(), book.getYearValue());
            }
        printWriter.close();
        fileWriter.close();
    }

    public ArrayList<Book> findAllYearNewerThan(int year){
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book book : books){
            if (book.getYearValue() > year)
                bookList.add(book);
        }
        return bookList;
    }

    public Book findByName(String bookName){
        for (Book book : books){
            if (Objects.equals(book.getName(), bookName)){
                return book;
            }
        }
        return null;
    }

    public void printLibrary(){
        for (Book book : books){
            System.out.println(book);
        }
    }
}
