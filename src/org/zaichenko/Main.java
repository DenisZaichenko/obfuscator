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
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Incorrect count of arguments");
            System.exit(0);
        }

        Path textFilePAth = Paths.get(args[1]);
        Path regexFilePath = Paths.get(args[0]);
        String regex = Files.lines(regexFilePath).collect(Collectors.joining("|"));
        String fileContent = Files.lines(textFilePAth).collect(Collectors.joining("\n"));
        String newFileName = textFilePAth.getParent() + "/" +
                new SimpleDateFormat("MM dd_HH:mm:ss").format(Calendar.getInstance().getTime()) +
                textFilePAth.getFileName();

        Obfuscator obfuscator = new ObfuscatorImpl(new SimpleObfuscationStrategy(), Pattern.compile(regex));
        String content = obfuscator.obfuscate(fileContent);
        Files.write(Paths.get(newFileName), content.getBytes(UTF_8));
    }
}
