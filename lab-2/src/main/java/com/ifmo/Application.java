package com.ifmo;

import com.ifmo.math.Function;
import com.ifmo.report.FileWriter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Application {

    private final Function system;
    private final FileWriter fileWriter;

    @SneakyThrows
    public void evaluate(double x) {
        double result = system.calculate(x);
        String[] data = {String.valueOf(x), String.format("Результат работы модуля %s", result)};
        fileWriter.write(data);
    }
}
