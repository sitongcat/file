import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadTxt {

    public static void main(String args[]) throws Exception {
        readFile();
    }


    public static void readFile() {
        String pathname = "/input.txt";
        List<String> list = new ArrayList<String>();
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                //list.add(line);
                list.add(new String(line.getBytes(),"utf-8"));
            }
            //System.out.print(list);

            for (int i = 0; i < list.size(); i++) {
                deleteFile(list.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteFile(String pathname){
        pathname =pathname.replaceAll("\\\\", "/");
        //System.out.println(pathname);
        boolean result = false;
        File file = new File(pathname);
        //System.out.println(file.getPath() + ", " + file.exists());
        if (file.exists()) {
            file.delete();
            result = true;
            System.out.println(file.getPath() + " was already deleted!");
          //  System.out.println("deleted!");
        }
        return result;
    }

}