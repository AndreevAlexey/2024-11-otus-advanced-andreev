package ru.otus.otusnio.shell;


import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.otusnio.service.ByteBufferService;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommands {

    private final ByteBufferService byteBufferService;


    @ShellMethod(value = "Read file to off heap memory", key = "read_file")
    public String readFile(String file) {
        return byteBufferService.readFile(file);
    }


    @ShellMethod(value = "Read file to off heap memory", key = "read_file_full")
    public String readFileFull(String file) {
        return byteBufferService.readFileBufferAutoSize(file);
    }


    @ShellMethod(value = "Read big file to off heap memory", key = "read_big_file")
    public String readBigFile(String file) {
        return byteBufferService.readBigFile(file);
    }


    @ShellMethod(value = "Set off heap size", key = "set_buff_size")
    public String setBufferSize(int size) {
        return byteBufferService.setByteBufferSize(size);
    }


    @ShellMethod(value = "Store file to off heap memory", key = "store_file")
    public String storeFile(String file) {
        return byteBufferService.storeFile(file);
    }


    @ShellMethod(value = "Get file form off heap memory store", key = "get_file")
    public String getFile(String file) {
        return byteBufferService.getFileFromStore(file);
    }

}
