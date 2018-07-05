package org.zaichenko.services;

import java.nio.file.Path;
import java.util.List;

public interface FileService {
    public List<String> read(Path path);
    public void write(Path path, List<String> fileContent);
}
