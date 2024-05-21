package co.com.sofka.utils;

import org.jetbrains.annotations.NotNull;

import static co.com.sofka.utils.FileUtil.readFile;

public class XmlBody {

    public static @NotNull String getBody(int valueUno, int valueDos, String requiredFile) {
        String path = String.format("src/test/resources/xml/%s", requiredFile);
        return String.format(readFile(path), valueUno, valueDos);
    }
}
