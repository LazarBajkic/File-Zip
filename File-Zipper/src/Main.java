import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("input file path");
        String path1=s.nextLine();
        System.out.println("input file name after zipping");
        String path2=s.nextLine();
        Compress(path1, path2);
    }

    public static void Compress(String path1,String path2) throws IOException{
        FileOutputStream fos = new FileOutputStream(path2);
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(path1);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.close();
        fis.close();
        fos.close();
    }

    public static void Decompress(String path1,String path2) throws IOException{
        FileOutputStream fos = new FileOutputStream(path2);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fiuz = new File(path1);
        FileInputStream fis = new FileInputStream(fiuz);
        ZipEntry zipEntry = new ZipEntry(fiuz.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.close();
        fis.close();
        fos.close();
    }
   
}
