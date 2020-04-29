package top.guoziyang.webflux.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import top.guoziyang.webflux.domain.City;

public interface CityRepository {

    Flux<City> findAll();

}
