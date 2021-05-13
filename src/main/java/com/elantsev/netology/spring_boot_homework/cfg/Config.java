package com.elantsev.netology.spring_boot_homework.cfg;

import com.elantsev.netology.spring_boot_homework.DevProfile;
import com.elantsev.netology.spring_boot_homework.ProductionProfile;
import com.elantsev.netology.spring_boot_homework.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
