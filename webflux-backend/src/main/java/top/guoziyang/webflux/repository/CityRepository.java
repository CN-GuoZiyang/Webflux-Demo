package top.guoziyang.webflux.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import top.guoziyang.webflux.domain.City;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {

    @Tailable
    Flux<City> findBy();

}
