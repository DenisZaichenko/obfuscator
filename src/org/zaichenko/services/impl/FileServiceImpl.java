package org.zaichenko.services.impl;

import org.zaichenko.services.FileService;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> read(Path path) {
        try(Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            return lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void write(Path path, List<String> fileContent)  {
        try (BufferedWriter writer=Files.newBufferedWriter(path)){
            for (String str :
                    fileContent) {
                writer.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
