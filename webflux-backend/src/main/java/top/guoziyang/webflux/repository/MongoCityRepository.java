package top.guoziyang.webflux.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import top.guoziyang.webflux.domain.City;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MongoCityRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    public List<City> getAllCities() {
        return mongoTemplate.findAll(City.class);
    }

}
