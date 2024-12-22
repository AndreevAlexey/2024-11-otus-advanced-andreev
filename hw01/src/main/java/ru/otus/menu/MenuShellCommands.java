package ru.otus.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.service.FileByteCacheService;
import ru.otus.service.TextFileCacheService;


@ShellComponent
@RequiredArgsConstructor
public class MenuShellCommands {

    private final TextFileCacheService textFileCacheService;

    private final FileByteCacheService fileByteCacheService;


    @ShellMethod(value = "Set directory for cache(example D:\\temp)", key = "byte_set_dir")
    public String setDirForByteCache(String dir) {
        try {
            fileByteCacheService.setDir(dir);
            return "successful";
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }

    @ShellMethod(value = "Get cached directory", key = "byte_get_dir")
    public String getDirForByteCache() {
        return fileByteCacheService.getDir();
    }

    @ShellMethod(value = "Add file to cache", key = "byte_cache")
    public String addFileToByteCache(String filename) {
        try {
            fileByteCacheService.addFileToCache(filename);
            return "successful";
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }

    @ShellMethod(value = "Get file from cache", key = "byte_get")
    public String getFileFromByteCache(String filename) {
        try {
            if (!fileByteCacheService.isCached(filename)) {
                return "File not cached!";
            }
            byte[] bytes = fileByteCacheService.getFromCache(filename);
            System.out.println(new String(bytes));
            return null;
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }


    @ShellMethod(value = "Set directory for cache(example D:\\temp)", key = "text_set_dir")
    public String setDirForTextCache(String dir) {
        try {
            textFileCacheService.setDir(dir);
            return "successful";
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }

    @ShellMethod(value = "Get cached directory", key = "text_get_dir")
    public String getDirForTextCache() {
        return textFileCacheService.getDir();
    }

    @ShellMethod(value = "Add file to cache", key = "text_cache")
    public String addFileToTextCache(String filename) {
        try {
            textFileCacheService.addFileToCache(filename);
            return "successful";
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }

    @ShellMethod(value = "Get file from cache", key = "text_get")
    public String getFileFromTextCache(String filename) {
        try {
            if (!textFileCacheService.isCached(filename)) {
                return "File not cached!";
            }
            textFileCacheService.getFromCache(filename).forEach(System.out::println);
            return "successful";
        } catch (Exception exp) {
            return exp.getMessage();
        }
    }
}

