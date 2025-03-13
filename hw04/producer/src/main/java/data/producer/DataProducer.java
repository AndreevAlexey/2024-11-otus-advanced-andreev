package data.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataProducer {


    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }


    public List<String> generateDataList(int size) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String generatedString = generateRandomString();
            System.out.printf("DataProducer generatedString=%s\n", generatedString);
            data.add(generatedString);
        }
        return data;
    }

}
