package com.ifmo.report;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public static File generateFile(String format) {
        return new File(String.format("./reports/%s.%s", LocalDateTime.now().format(DATE_TIME_FORMATTER), format));
    }
}
