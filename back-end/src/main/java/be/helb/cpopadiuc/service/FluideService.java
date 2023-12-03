// CrewService.java
package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Fluide;
import be.helb.cpopadiuc.repository.FluideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FluideService {

    private final FluideRepository fruitRepository;

    @Autowired
    public FluideService(FluideRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fluide> getAllCrews() {
        return fruitRepository.findAll();
    }

    public void addFruit(Fluide fruit) {
        fruitRepository.save(fruit);
    }
}
