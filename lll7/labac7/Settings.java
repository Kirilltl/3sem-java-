import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Settings {
    final private Map <String, Integer> Maps;
    public Settings() {
        Maps = new HashMap<>();
    }

    public void loadFromTextFile(String filename) throws IOException{
        Reader rd = new InputStreamReader(new FileInputStream(filename));
        Scanner sn = new Scanner(rd);
        while (true) {
            if (!sn.hasNext())
                break;
            String line = sn.nextLine();
            Scanner lsn = new Scanner(line);
            String str = lsn.next();
            int tmp = lsn.nextInt();
            this.put(str, tmp);
            rd.close();
        }
    }

    public void saveToTextFile(String filename) throws IOException{
        Writer wr = new OutputStreamWriter(new FileOutputStream(filename));
        wr.write(this.toString());
        wr.close();
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        Reader rd = new InputStreamReader(new FileInputStream(filename));
        StringBuilder sb = new StringBuilder();
        int r;
        while ((r = rd.read()) >= 0){
            sb.append((char) r);
        }
        rd.close();
        Scanner sn = new Scanner(sb.toString());
        while (sn.hasNext()) {
            String line = sn.nextLine();
            Scanner lsn = new Scanner(line);
            String str = lsn.next();
            int tmp = lsn.nextInt();
            this.put(str, tmp);
        }
    }

    public void saveToBinaryFile(String filename) throws IOException {
            RandomAccessFile file = new RandomAccessFile(new File(filename), "rw");
            Set<String> k = Maps.keySet();
            Object[] mass = k.toArray();
            for (int i = 0; i < Maps.size(); i++) {
                String tmp = mass[i].toString();
                file.writeBytes(tmp);
                file.writeBytes(" ");
                file.writeBytes(Maps.get(tmp).toString());
                file.writeBytes("" + '\n');
            }
            file.close();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry i : Maps.entrySet()){
            str.append(i.getKey()).append(" ").append(i.getValue()).append("\n");
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