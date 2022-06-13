package com.ifmo.report;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss.S");

    public static File generateFile(String format) {
        File dir = new File("./reports");
        if (!dir.exists()) {
            dir.mkdir();
        }
        return new File(dir, String.format("%s.%s", LocalDateTime.now().format(DATE_TIME_FORMATTER), format));
    }
}
