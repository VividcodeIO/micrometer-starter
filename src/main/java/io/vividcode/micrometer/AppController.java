package io.vividcode.micrometer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("/app")
public class AppController {
  private final Counter counter;

  public AppController(final MeterRegistry registry) {
    this.counter = registry.counter("greeting");
  }

  @RequestMapping("/greeting")
  public String greeting() {
    this.counter.increment();
    return "hello world #" + this.counter.count();
  }
}
