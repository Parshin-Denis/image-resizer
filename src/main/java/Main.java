import java.io.File;

public class Main {
    public static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\denis\\OneDrive\\Рабочий стол\\src";
        String dstFolder = "C:\\Users\\denis\\OneDrive\\Рабочий стол\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int  quarter = files.length / 4;

        File[] files1 = new File[quarter];
        File[] files2 = new File[quarter];
        File[] files3 = new File[quarter];
        File[] files4 = new File[files.length - quarter * 3];

        System.arraycopy(files, 0, files1, 0, quarter);
        System.arraycopy(files, quarter, files2, 0, quarter);
        System.arraycopy(files, quarter * 2, files3, 0, quarter);
        System.arraycopy(files, quarter * 3, files4, 0, files.length - quarter * 3);

        ImageResizer resizer1 = new ImageResizer(files1, dstFolder, newWidth, start);
        new Thread(resizer1).start();

        ImageResizer resizer2 = new ImageResizer(files2, dstFolder, newWidth, start);
        new Thread(resizer2).start();

        ImageResizer resizer3 = new ImageResizer(files3, dstFolder, newWidth, start);
        new Thread(resizer3).start();

        ImageResizer resizer4 = new ImageResizer(files4, dstFolder, newWidth, start);
        new Thread(resizer4).start();

        System.out.println("Duration Main: " + (System.currentTimeMillis() - start));
    }
}
