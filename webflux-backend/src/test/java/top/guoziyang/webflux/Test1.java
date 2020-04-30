package top.guoziyang.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import top.guoziyang.webflux.domain.City;

import java.time.Duration;

public class Test1 {

    @Test
    public void insertFiveCity() {
        Flux<City> cityFlux = Flux.interval(Duration.ofSeconds(1))
                .map(l -> City.builder()
                        .id(System.currentTimeMillis())
                        .name("城市-" + l)
                        .description("介绍-" + l)
                        .build()).take(5);
        WebClient webClient = WebClient.create("http://localhost:8081");
        webClient
                .post().uri("/city")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(cityFlux, City.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
