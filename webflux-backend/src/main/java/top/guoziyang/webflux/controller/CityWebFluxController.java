package top.guoziyang.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import top.guoziyang.webflux.domain.City;
import top.guoziyang.webflux.repository.CityRepository;

@RestController
public class CityWebFluxController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "/city", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin("http://localhost:8080")
    public Flux<City> geAllCity() {
        return cityRepository.findAll();
    }

}
