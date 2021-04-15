package task3;

import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator<File> {

    public int compare(File f1, File f2) {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().compareTo(f2.getName());
            }
    }
}
