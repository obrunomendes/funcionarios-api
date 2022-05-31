package com.obrunomendes.rh.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.timer.Timer;

@Component
@EnableScheduling
public class CacheScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheScheduler.class);

    @Scheduled(fixedRate = Timer.ONE_MINUTE * 5)
    @CacheEvict(value = "viaCepCache")
    public void limpaCache() {
        LOGGER.info("limpando cache ....");
    }
}