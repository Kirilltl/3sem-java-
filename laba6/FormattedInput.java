import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FormattedInput {
    public static Object[] scanf(String format) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Input data:");
        if (sc.hasNextLine()) {
            while (true) {
                try {
                    s = sc.nextLine();
                    return sscanf(format, s);
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        throw new Exception("No data was read");
    }

    public static Object[] sscanf(String format, String in) throws Exception{
        ArrayList<Object> res = new ArrayList<>();
        Pattern intPattern = Pattern.compile(intRegex);
        Matcher intMatcher = intPattern.matcher(in);
        Pattern doublePattern = Pattern.compile(doubleRegex);
        Matcher doubleMatcher = doublePattern.matcher(in);
        Pattern charPattern = Pattern.compile(charRegex);
        Matcher charMatcher = charPattern.matcher(in);
        Pattern stringPattern = Pattern.compile(stringRegex);
        Matcher stringMatcher = stringPattern.matcher(in);
        int lastGroupIndex = 0;
            for (int ind = 0; ind > - 1; ind = placeholderIndex(ind + 1, format)) {
                String intGroup = "", doubleGroup = "", charGroup = "", stringGroup = "";
                if (intMatcher.find(lastGroupIndex)) {
                    intGroup = intMatcher.group();
                }
                if (doubleMatcher.find(lastGroupIndex)) {
                    doubleGroup = doubleMatcher.group();
                }
                if (charMatcher.find(lastGroupIndex)) {
                    charGroup = charMatcher.group();
                }
                if (stringMatcher.find(lastGroupIndex)) {
                    stringGroup = stringMatcher.group();
                }
                switch (format.charAt(ind + 1)) {
                    case 'd' -> {
                        try {
                            res.add(Integer.parseInt(intGroup));
                            lastGroupIndex = in.indexOf(intGroup, lastGroupIndex) + intGroup.length();

                        } catch (Exception e) {
                            throw new Exception("Failed to parse integer literal");
                        }
                    }
                    case 'f' -> {
                        try {
                            res.add(Double.parseDouble(doubleGroup));
                            lastGroupIndex = in.indexOf(doubleGroup, lastGroupIndex) + doubleGroup.length();

                        } catch (Exception e) {
                            throw new Exception("Failed to parse double literal");
                        }

                    }
                    case 'c' -> {
                        try {
                            res.add(charGroup.charAt(0));
                            lastGroupIndex = in.indexOf(charGroup, lastGroupIndex) + charGroup.length();

                        } catch (Exception e) {
                            throw new Exception("Failed to parse char literal");
                        }

                    }
                    case 's' -> {
                        try {
                            res.add(stringGroup);
                            lastGroupIndex = in.indexOf(stringGroup, lastGroupIndex) + stringGroup.length();

                        } catch (Exception e) {
                            throw new Exception("Failed to parse string literal");

                        }
                    }
                    default -> throw new Exception("Unknown placeholder");
                }
            }
            if (lastGroupIndex != in.length()) throw new Exception("Given string is not eligible with format");
            return res.toArray();
    }

    private final static String intRegex = "\\d+";
    private final static String doubleRegex = "\\d+\\.\\d+";
    private final static String charRegex = "\\S";
    private final static String stringRegex = "\\w+";

    private static int mini(int a, int b, int c, int d){
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        if (d < min)
            min = d;
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    private static int placeholderIndex(int ch, String s){
        int intPlaceholder = s.indexOf("%d", ch);
        intPlaceholder = intPlaceholder==-1 ? Integer.MAX_VALUE : intPlaceholder;
        int doublePlaceholder = s.indexOf("%f", ch);
        doublePlaceholder = doublePlaceholder==-1 ? Integer.MAX_VALUE : doublePlaceholder;
        int charPlaceholder = s.indexOf("%c", ch);
        charPlaceholder = charPlaceholder==-1 ? Integer.MAX_VALUE : charPlaceholder;
        int stringPlaceholder = s.indexOf("%s", ch);
        stringPlaceholder = stringPlaceholder==-1 ? Integer.MAX_VALUE : stringPlaceholder;
        return mini(intPlaceholder, doublePlaceholder, charPlaceholder, stringPlaceholder);
    }

    public static void print(Object[] objects){
        for (Object object : objects) {
            System.out.print(object.toString() + " ");
        }
    }
}