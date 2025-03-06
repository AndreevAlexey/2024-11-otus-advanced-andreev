package api.controller;

import core.repository.DataRepository;
import data.producer.DataProducer;
import data.saver.DataSaverService;

import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ApiController controller = createController();
        Random random = new Random();
        Stream
                .generate(() -> random.nextInt(1, 10))
                .limit(5)
                .map(controller::getDataList)
                .forEach(controller::saveDataList);
    }


    private static ApiController createController() {
        DataRepository dataRepository = new DataRepository();
        DataProducer dataProducer = new DataProducer();
        DataSaverService dataSaver = new DataSaverService(dataRepository);

        return new ApiController(dataProducer, dataSaver);
    }

}
