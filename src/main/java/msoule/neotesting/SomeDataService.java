package msoule.neotesting;

import org.springframework.stereotype.Service;

@Service
public class SomeDataService {

    private final SomeDataRepository repository;

    public SomeDataService(SomeDataRepository repository) {
        this.repository = repository;
    }

    void save(SomeData someData) {
        repository.save(someData);
    }
}
