package org.zaichenko.services.impl;

import org.zaichenko.services.FileService;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> read(Path path) {
        try {
            return Files.lines(path).map(String::toString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void write(Path path, List<String> fileContent)  {
        try {
            Files.write(path, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
