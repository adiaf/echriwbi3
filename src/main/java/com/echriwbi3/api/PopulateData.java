package com.echriwbi3.api;

import com.echriwbi3.api.repository.RoleRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class PopulateData {
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator(RoleRepository roleRepository) {
        roleRepository.deleteAll();
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[] { new ClassPathResource("data.json") });
        return factory;
    }
}