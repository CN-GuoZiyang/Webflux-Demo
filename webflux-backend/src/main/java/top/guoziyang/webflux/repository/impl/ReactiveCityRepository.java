package top.guoziyang.webflux.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import top.guoziyang.webflux.domain.City;
import top.guoziyang.webflux.repository.CityRepository;
import top.guoziyang.webflux.repository.MongoCityRepository;

import java.time.Duration;
import java.util.List;

@Repository
public class ReactiveCityRepository implements CityRepository {

    @Autowired
    private MongoCityRepository mongoCityRepository;

    @Override
    public Flux<City> findAll() {
        return Flux.interval(Duration.ofSeconds(2))
                .onBackpressureDrop()
                .map(this::getAllCities)
                .flatMapIterable(x -> x);
    }

    private List<City> getAllCities(Long interval) {

        return mongoCityRepository.getAllCities();

    }
}
