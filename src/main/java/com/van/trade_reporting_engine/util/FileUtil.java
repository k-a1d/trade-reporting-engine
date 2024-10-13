package com.van.trade_reporting_engine.util;

import java.io.File;
import java.net.URI;

public final class FileUtil {

    private FileUtil FileReader() {
        throw new IllegalStateException("Don't instantiate this util class. Use it's static method.");
    }

    public static File[] readFiles(URI directoryPath) {
        File directory = new File(directoryPath);
        return directory.listFiles();
    }
}
