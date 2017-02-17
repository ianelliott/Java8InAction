package ch01;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by ielliott on 2/16/17.
 */
public class FileFilterTest {

    private void printFiles(File[] files) {
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    @Test
    public void testFileFilterPreJava8() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        printFiles(hiddenFiles);
    }

    @Test
    public void testFileFilterJava8Lambda() {
        File[] hiddenFiles = new File(".").listFiles(file -> file.isHidden());

        printFiles(hiddenFiles);
    }

    @Test
    public void testFileFilterJava8MethodReference() {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        printFiles(hiddenFiles);
    }
}
