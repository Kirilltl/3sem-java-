import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class Settings {
    final private Map <String, Integer> Maps;
    public Settings() {
        Maps = new HashMap<>();
    }

    public void saveToBinaryFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buffer;
        for(Map.Entry i : Maps.entrySet()) {
            String s = i.getKey()+ " " + i.getValue() + '\n';
            buffer = s.getBytes();
            fos.write(buffer);
        }
        fos.close();
    }

    public void loadFromBinaryFile(String filename) throws  IOException{
        FileInputStream fis = new FileInputStream(filename);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer, 0, fis.available());
        int flag  = 0;
        StringBuilder key = new StringBuilder();
        StringBuilder sValue = new StringBuilder();
        int val;
        for (byte b : buffer) {
            if ((char) b == '\n') {
                flag = 0;
                val = Integer.parseInt(sValue.toString());
                Maps.put(key.toString(), val);
                key = new StringBuilder();
                sValue = new StringBuilder();
                continue;
            }
            if ((char) b == ' ') {
                flag = 1;
                continue;
            }
            if (flag == 0) {
                key.append((char) b);
                continue;
            }
            sValue.append((char) b);
        }
    }

    public void saveToTextFile(String filename) throws  IOException{
        FileWriter fw = new FileWriter(filename, false);
        for(Map.Entry i : Maps.entrySet()) {
            String s = i.getKey()+ " " + i.getValue() + '\n';
            fw.write(s);
        }
        fw.close();
    }

    public void loadFromTextFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        int flag  = 0;
        StringBuilder key = new StringBuilder();
        StringBuilder sValue = new StringBuilder();
        int val;
        int i;
        while((i = fr.read()) != -1) {
            if (i == '\n') {
                flag = 0;
                val = Integer.parseInt(sValue.toString());
                Maps.put(key.toString(), val);
                key = new StringBuilder();
                sValue = new StringBuilder();
                continue;
            }
            if (i == ' ') {
                flag = 1;
                continue;
            }
            if (flag == 0) {
                key.append((char) i);
                continue;
            }
            sValue.append((char) i);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry i : Maps.entrySet()){
            str.append(i.getKey()).append(": ").append(i.getValue()).append("\n");
        }
        return str.toString();
    }

    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Settings))
            return false;
        Settings o = (Settings) obj;
        if(Maps.size() != o.Maps.size())
            return false;
        for(Map.Entry i : Maps.entrySet()) {
            int flag  = 0;
            for(Map.Entry j : o.Maps.entrySet()) {
                if(i.getKey() == j.getKey() && i.getValue() == j.getValue()){
                    flag = 1;
                   break;
                }
            }
            if(flag == 0)
                return false;
        }
        return true;
    }

    public void put(String s, int Int) {
        Maps.put(s, Int);
    }

    public int get(String s){
        return Maps.get(s);
    }

    public void delete(String s) {
        Maps.remove(s);
    }
}