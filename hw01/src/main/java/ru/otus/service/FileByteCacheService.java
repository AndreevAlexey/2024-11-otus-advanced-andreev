package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.model.ByteCache;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

@Service
public class FileByteCacheService {

    private File dir;

    private final ByteCache byteCache = new ByteCache();


    public void setDir(String path) {
        dir = Path.of(path).toFile();
    }


    public String getDir() {
        return (dir != null) ? dir.getAbsolutePath() : "Is null";
    }


    public boolean isCached(String filename) {
        return byteCache.isCached(filename);
    }


    private void addToCache(String name, Byte[] data) {
        byteCache.addToCache(name, data);
    }


    public byte[] getFromCache(String name) {
        return
                fromObjects(byteCache.getFromCache(name));
    }


    public void addFileToCache(String filename) throws IOException {
        Path path = Path.of(dir.getAbsolutePath() + "\\" + filename);
        byte[] fileBytes = getFileBytes(path);
        Byte[] bytes = toObjects(fileBytes);
        addToCache(filename, bytes);
    }


    private Byte[] toObjects(byte[] bytes) {
        return IntStream.range(0, bytes.length)
                .mapToObj(i -> bytes[i])
                .toArray(Byte[]::new);
    }

    private byte[] fromObjects(Byte[] bytes) {
        byte[] result = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = bytes[i];
        }
        return result;
    }

    private byte[] getFileBytes(Path path) throws IOException {
        return Files.readAllBytes(path);
    }
}

