import java.io.IOException;
public class Main {
    public static void main(String[] args) throws Exception {
        /*Object[] obj1 = FormattedInput.sscanf("%d %s %s", "1 aaa fff");
        FormattedInput.print(obj1);
        System.out.println();
        Object[] obj2 = FormattedInput.scanf("%d %s %s");
        FormattedInput.print(obj2);*/

	    TranscriptWriter trs = null;
        try {
            trs = new TranscriptWriter("C:\\Users\\79112\\OneDrive\\Рабочий стол\\techprog\\laba6\\sound.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        trs.add("б","b");
        trs.add("ф","f");
        trs.add("н","n");
        trs.add("г","g");
        trs.add("ч","ch");
        try {
            trs.write("бчгфн");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}