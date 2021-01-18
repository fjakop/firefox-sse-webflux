package de.jakop.firefoxssewebflux;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@RestController
@RequestMapping("api/eventsource")
public class EventSourceWebService {

    @GetMapping(path = "timestamps", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> timestamps() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> LocalTime.now().toString());
    }

    @GetMapping(path = "timestamp", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String timestamp() {
        return LocalTime.now().toString();
    }
}
