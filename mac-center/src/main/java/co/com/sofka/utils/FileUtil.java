package co.com.sofka.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {

    private static final Logger LOGGER = Logger.getLogger(FileUtil.class.getName());


    public static boolean verifyIfFileExists(String filePath) {
        File file = new File(filePath);
        LOGGER.info("**** File Verification ****");
        LOGGER.info("Provided path: " + filePath);
        LOGGER.info("Does the file or directory exist?: " + file.exists());
        LOGGER.info("Is it a file?: " + file.isFile());
        return file.isFile();
    }

    public static boolean deleteFileOrDirectory(String filePath) {
        File object = new File(filePath);
        LOGGER.info("**** File or Directory Deletion Verification ****");
        LOGGER.info("Provided path: " + filePath);
        LOGGER.info("Does the file or directory exist?: " + object.exists());

        boolean deleted = false;

        if (object.exists()) {
            deleted = object.delete();
        }

        LOGGER.info("Was it deleted?: " + deleted);
        return deleted;
    }

    public static String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, "There are problems with the specified path for reading the file", ioException);
        }
        return stringBuilder.toString();
    }
}