package filesystem;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class filereader {

    public static void main(String[] args) {
        // Define the directory to start the search
        Path startDir = Paths.get("C:\\work_workspace\\postbill_July24\\.ev2\\ServiceGroupRoot\\Parameters\\Prod");

        //fileReader1(startDir);
        try (Stream<Path> stream = Files.walk(startDir)) {
            stream.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error walking the file tree: " + e.getMessage());
        }

    }

    private static void fileReader1(Path startDir) {
        try {
            // Use Files.walkFileTree to recursively walk the file tree
            Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Print the file path
                    System.out.println(file.getFileName().toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // If a file visit fails, print the error and continue
                    System.err.println("Failed to visit file: " + file.toString() + " (" + exc.getMessage() + ")");
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            // Handle any IO exceptions
            System.err.println("Error walking the file tree: " + e.getMessage());
        }
    }
}
