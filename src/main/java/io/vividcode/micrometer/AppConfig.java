package io.vividcode.micrometer;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = AppConfig.class)
class AppConfig {
  @Bean
  MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
    return registry -> registry.config().commonTags("tag1", "a", "tag2", "b");
  }
}
