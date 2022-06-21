package enccon.l6;
import java.io.*;
public class EncodingConverter {
    public static void main(String[] args) throws Exception {
        try
        {
            Reader buffRead = new InputStreamReader(new FileInputStream(args[0]), args[2]);
            Writer buffWrite = new OutputStreamWriter(new FileOutputStream(args[1]), args[3]);
            int s = 0;
            while((s = buffRead.read()) >= 0){
                buffWrite.write(s);
            }
            buffRead.close();
            buffWrite.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}