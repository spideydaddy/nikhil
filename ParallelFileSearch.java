import java.io.*;
import java.util.concurrent.*;

public class ParallelFileSearch {

    private static ExecutorService executor;

    public static void main(String[] args) {

        if (args.length != 2) {

            System.out.println(
                    "Usage: java ParallelFileSearch <directory_path> <search_text>"
            );

            return;
        }

        String directoryPath = args[0];
        String searchText = args[1];

        File dir = new File(directoryPath);

        if (!dir.exists() || !dir.isDirectory()) {

            System.out.println("Invalid directory path.");

            return;
        }

        int threads = Runtime.getRuntime().availableProcessors();

        executor = Executors.newFixedThreadPool(threads);

        traverseDirectory(dir, searchText);

        executor.shutdown();
    }

    private static void traverseDirectory(File file, String searchText) {

        if (file.isDirectory()) {

            File[] files = file.listFiles();

            if (files != null) {

                for (File f : files) {

                    traverseDirectory(f, searchText);
                }
            }

        } else {

            executor.submit(() -> searchInFile(file, searchText));
        }
    }

    private static void searchInFile(File file, String searchText) {

        int count = 0;

        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(file)
                )
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                int index = 0;

                while ((index = line.indexOf(searchText, index)) != -1) {

                    count++;

                    index += searchText.length();
                }
            }

            System.out.println(
                    "File: " + file.getAbsolutePath()
                            + " | Count: " + count
            );

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: " + file.getAbsolutePath()
            );
        }
    }
}