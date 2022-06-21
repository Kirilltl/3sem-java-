import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
public class TranscriptWriter extends FileWriter {
    private final HashMap<String, String> MyMap;
    public TranscriptWriter(String file) throws IOException {
        super(file);
        MyMap = new HashMap<>();
    }

    public void add(String src, String data) {
        MyMap.put(src, data);
    }

    public void write(String s) throws IOException {
        String str;
        for(int i = 0; i < s.length(); i++) {
            if ((str = MyMap.get(String.valueOf(s.charAt(i)))) != null){
                super.write(str);
            }
            else{
                super.write(s.charAt(i));
            }
            super.flush();
        }
    }
}