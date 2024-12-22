package ru.otus.service;


import org.springframework.stereotype.Service;
import ru.otus.model.StringCache;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class TextFileCacheService {

    private File dir;

    private final StringCache stringCache = new StringCache();


    public void setDir(String path) {
        dir = Path.of(path).toFile();
    }


    public String getDir() {
        return (dir != null) ? dir.getAbsolutePath() : "Is null";
    }


    public boolean isCached(String filename) {
        return stringCache.isCached(filename);
    }


    private void addToCache(String name, List<String> data) {
        stringCache.addToCache(name, data);
    }


    public List<String> getFromCache(String name) {
        return
                stringCache.getFromCache(name);
    }


    public void addFileToCache(String filename) throws IOException {
        Path path = Path.of(dir.getAbsolutePath() + "\\" + filename);
        List<String> lines = getFileLines(path);
        addToCache(filename, lines);
    }


    private List<String> getFileLines(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}

