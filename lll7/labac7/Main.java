import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String p1 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\labac7\\books.txt";
        Library library = new Library();
        try {
            library.readFromFilePath(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String p2 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\labac7\\books2.txt";
        try {
            library.writeToFilePath(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Find The Invisible Man");
        System.out.println(" " + library.findByName("The Invisible Man"));
        System.out.println("Find > ");
        ArrayList<Book> bookArrayList = library.findAllYearNewerThan(1900);
        for (Book book : bookArrayList) {
            System.out.print(" ");
            System.out.println(book);
        }
    }
}















        /*Settings st1 = new Settings();//main task
        Settings st2 = new Settings();
        String p1 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\labac7\\l711.txt";
        String p2 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\labac7\\l712.txt";
        String p3 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\labac7\\l721.bin";
        String p4 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\labac7\\l722.bin";
        try {
            st1.loadFromBinaryFile(p3); st2.loadFromTextFile(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            st1.saveToBinaryFile(p4); st2.saveToTextFile(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /////////
        public Library(String path) throws IOException {
        books = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] strings = line.split(", ");
            books.add(new Book(strings[0], strings[1], Integer.parseInt(strings[2])));
        }
        bufferedReader.close();
        fileReader.close();
    }*/
