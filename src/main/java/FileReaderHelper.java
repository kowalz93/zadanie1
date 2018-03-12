import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Marcin on 12.10.2017.
 */
public class FileReaderHelper {

    private static final String encodingType = "UTF-8";

    public String readFileContentFromClasspath(String filename) throws FileNotFoundException {
        InputStream inputStream = getInputStream(filename);
        if (inputStream == null) {
            throw new FileNotFoundException("File " + filename + " not found");
        }
        try {
            return IOUtils.toString(inputStream, encodingType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteFileWhiteSpaces(String file){
        return StringUtils.deleteWhitespace(file);
    }

    private InputStream getInputStream(String fileName){             // przetestowac ta metodę
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
