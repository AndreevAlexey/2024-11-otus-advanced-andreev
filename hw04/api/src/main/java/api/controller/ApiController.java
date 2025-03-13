package api.controller;

import data.producer.DataProducer;
import data.saver.DataSaverService;

import java.util.List;

public class ApiController {

    private final DataProducer dataProducer;

    private final DataSaverService dataSaver;

    public ApiController(DataProducer dataProducer, DataSaverService dataSaver) {
        this.dataProducer = dataProducer;
        this.dataSaver = dataSaver;
    }

    public List<String> getDataList(int size) {
        System.out.printf("Api getDataList size=%d%n", size);
        return dataProducer.generateDataList(size);
    }

    public void saveDataList(List<String> dataList) {
        System.out.println("Api saveDataList");
        dataList.forEach(dataSaver::save);
    }
}

