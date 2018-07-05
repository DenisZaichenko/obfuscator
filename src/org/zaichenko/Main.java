package org.zaichenko;

import org.zaichenko.services.FileService;
import org.zaichenko.services.impl.FileServiceImpl;
import org.zaichenko.services.obuscation.Obfuscator;
import org.zaichenko.services.obuscation.impl.ObfuscatorImpl;
import org.zaichenko.services.obuscation.impl.SimpleObfuscationStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        FileService fileService= new FileServiceImpl();
        Path textFilePAth = Paths.get(args[1]);
        List<String> regexs;
        List<String> fileContent;
        regexs = fileService.read(Paths.get(args[0]));
        fileContent = fileService.read(textFilePAth);
        String newFileName = textFilePAth.getParent() +
                new SimpleDateFormat("MMdd_HHmmss").format(Calendar.getInstance().getTime()) +
                textFilePAth.getFileName();

        Obfuscator obfuscator= new ObfuscatorImpl(new SimpleObfuscationStrategy(), regexs);
        List<String> result=obfuscator.obfuscate(fileContent);
        fileService.write(Paths.get(newFileName), result);
    }
}
