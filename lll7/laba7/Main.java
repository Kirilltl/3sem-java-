import java.io.IOException;
public class Main {
    public static void main(String[] args){
        Settings st1 = new Settings();
        Settings st2 = new Settings();
        st1.put("RED", 2);
		st1.put("BLUE", 1);
		st1.put("WHITE", 3);

		st2.put("BLACK", 2);
		st2.put("YELLOW", 1);
		st2.put("GREY", 3);

		String p11 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\laba7\\lab7_txt\\l711.txt";
        String p12 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\laba7\\lab7_txt\\l712.txt";
        String p21 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\laba7\\lab7_txt\\l721.bin";
		String p22 = "C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\laba7\\lab7_txt\\l722.bin";

        try {
            st2.saveToBinaryFile(p21);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            st1.saveToBinaryFile(p22);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}