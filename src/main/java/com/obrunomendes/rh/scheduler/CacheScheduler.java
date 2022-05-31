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
    private static final long CINCO_MINUTOS = Timer.ONE_MINUTE * 5;
    private static final long DEZ_MINUTOS = Timer.ONE_MINUTE * 10;

    @Scheduled(initialDelay = CINCO_MINUTOS, fixedDelay = DEZ_MINUTOS)
    @CacheEvict(value = "viaCepCache")
    public void limpaCache() {
        LOGGER.info("limpando cache ....");
    }
}