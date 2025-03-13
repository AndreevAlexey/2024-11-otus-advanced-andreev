package ru.otus.otusnio.service;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class ByteBufferService {

    private int byteBufferSize = 1024;

    private final Map<String, ByteBuffer> fileStore = new HashMap<>();


    public String setByteBufferSize(int size) {
        this.byteBufferSize = size;
        return "success";
    }


    public String storeFile(String file) {
        Path path = getFilePath(file);
        if (!checkPath(path)) {
            return "Can't find file with name %s".formatted(file);
        }
        try (FileChannel fileChanel = FileChannel.open(path)) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byteBufferSize);
            fileChanel.read(byteBuffer);
            fileStore.put(file, byteBuffer);
            return "success";
        } catch (IOException exp) {
            return "Can't read file %s".formatted(exp.getMessage());
        }
    }


    public String getFileFromStore(String file) {
        if (!fileStore.containsKey(file)) {
            return "Can't find file with name %s in store".formatted(file);
        }
        ByteBuffer byteBuffer = fileStore.get(file);
        byteBuffer.flip();
        printBuffer(byteBuffer);
        byteBuffer.clear();
        fileStore.remove(file);
        return "success";
    }


    public String readFile(String file) {
        Path path = getFilePath(file);
        if (!checkPath(path)) {
            return "Can't find file with name %s".formatted(file);
        }
        try (FileChannel fileChanel = FileChannel.open(path)) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byteBufferSize);
            while (fileChanel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                printBuffer(byteBuffer);
                byteBuffer.clear();
            }
            return "success";
        } catch (IOException exp) {
            return "Can't read file %s".formatted(exp.getMessage());
        }
    }


    public String readFileBufferAutoSize(String file) {
        Path path = getFilePath(file);
        if (!checkPath(path)) {
            return "Can't find file with name %s".formatted(file);
        }
        try (FileChannel fileChanel = FileChannel.open(path)) {
            long fileSize = fileChanel.size();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int) fileSize);
            fileChanel.read(byteBuffer);

            byteBuffer.flip();
            printBuffer(byteBuffer);
            return "success";
        } catch (IOException exp) {
            return "Can't read file %s".formatted(exp.getMessage());
        }
    }


    public String readBigFile(String file) {
        Path path = getFilePath(file);
        if (!checkPath(path)) {
            return "Can't find file with name %s".formatted(file);
        }
        try (FileChannel fileChanel = FileChannel.open(path)) {
            long size = fileChanel.size();
            MappedByteBuffer mappedByteBuffer = fileChanel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            mappedByteBuffer.load();
            printBuffer(mappedByteBuffer);
            mappedByteBuffer.clear();
            return "success";
        } catch (IOException exp) {
            return "Can't read file %s".formatted(exp.getMessage());
        }
    }


    private void printBuffer(ByteBuffer byteBuffer) {
        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get());
        }
        System.out.println();
    }


    private Path getFilePath(String filepath) {
        return Paths.get(filepath);
    }


    public boolean checkPath(Path path) {
        File file = path.toFile();
        return file.exists() && file.isFile();
    }
}
