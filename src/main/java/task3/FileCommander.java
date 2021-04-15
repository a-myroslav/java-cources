package task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileCommander {

    private File root;

    public FileCommander() {
        root = new File(System.getProperty("user.dir"));
    }

    public FileCommander(File root) {
        this.root = root;
    }

    public File getRoot() {
        return root;
    }

    public void setRoot(File root) {
        this.root = root;
    }

    public void getDir(String dirName) {
        if (dirName.equals("..")) {
            getParentDir();
            return;
        }

        File[] fileList = root.listFiles();
        if (fileList == null) {
            System.out.println("No directories found.");
            return;
        }

        File dir = Arrays.stream(fileList)
                .filter(f -> f.isDirectory() && f.getName().equals(dirName)).findFirst().orElse(null);
        if (dir != null && dir.canRead()) {
            root = dir;
        } else {
            System.out.println("Directory not found.");
        }
    }

    public void getParentDir() {
        try {
            File parentFile = root.getParentFile();
            if (parentFile != null) {
                root = parentFile;
            }
        } catch (Exception e) {
            System.err.println("Error during reading file system");
        }
    }

    public void listDir() {
        File[] fileList = root.listFiles();

        if (fileList == null) {
            System.out.println("No files found.");
            return;
        }

        Stream<File> fileStream = Stream.of(fileList);

        fileStream
                .sorted(new FileNameComparator())
                .forEach(f -> System.out.println(f.getName()));
    }

    public void readFile(String filePath) {
        Path path = Paths.get(root.getAbsolutePath() + "/" + filePath);
        try (Stream<String> stream = Files.lines(path)) {

            stream.forEach(System.out::println);

        } catch (NoSuchFileException e) {
            System.err.println("No such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFiles(String... files) {
        if (files == null || files.length < 2) {
            System.err.println("Invalid arguments");
            return;
        }

        Path source = Paths.get(root.getAbsolutePath() + "/" + files[0]);
        Path target = Paths.get(root.getAbsolutePath() + "/" + files[1]);

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (NoSuchFileException e) {
            System.err.println("No such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FileCommander{");
        sb.append("root=")
                .append(root)
                .append('}');
        return sb.toString();
    }
}
