package org.zaichenko;

import org.zaichenko.services.obuscation.Obfuscator;
import org.zaichenko.services.obuscation.impl.ObfuscatorImpl;
import org.zaichenko.services.obuscation.impl.SimpleObfuscationStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args) throws IOException {
        Path textFilePAth = Paths.get(args[1]);
        Path regexFilePath = Paths.get(args[0]);
        List<String> regexs = Files.lines(regexFilePath).collect(Collectors.toList());
        String fileContent = Files.lines(textFilePAth).collect(Collectors.joining());
        String newFileName = textFilePAth.getParent() +
                new SimpleDateFormat("MMdd_HHmmss").format(Calendar.getInstance().getTime()) +
                textFilePAth.getFileName();

        Obfuscator obfuscator= new ObfuscatorImpl(new SimpleObfuscationStrategy(), regexs);
        String content = obfuscator.obfuscate(fileContent);
        Files.write(Paths.get(newFileName), content.getBytes(UTF_8));
    }
}
