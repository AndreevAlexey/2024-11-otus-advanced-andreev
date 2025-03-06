package data.saver;

import core.repository.DataRepository;

public class DataSaverService {

    private final DataRepository repository;

    public DataSaverService(DataRepository repository) {
        this.repository = repository;
    }

    public void save(String value) {
        repository.addData(value);
        System.out.printf("DataSaver saved value=%s\n", value);
    }
}
