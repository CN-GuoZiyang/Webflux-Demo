package top.guoziyang.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.guoziyang.webflux.domain.City;
import top.guoziyang.webflux.repository.CityRepository;

import java.time.Duration;

@RestController
@CrossOrigin("http://localhost:8080")
public class CityWebFluxController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "/city", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<City> geAllCity() {
        return cityRepository.findBy().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(value = "/city", consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Void> saveCity(@RequestBody Flux<City> city) {
        return cityRepository.insert(city).then();
    }

}
