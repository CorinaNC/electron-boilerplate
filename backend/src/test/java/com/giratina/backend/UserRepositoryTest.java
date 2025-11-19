package com.giratina.backend;

import com.giratina.backend.models.User;
import com.giratina.backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Transactional
public class UserRepositoryTest {
    @TestConfiguration
    static class MongoTxConfig {
        @Bean
        MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {
            return new MongoTransactionManager(dbFactory);
        }
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        User user = User.builder()
                .setName("test_user")
                .setPassword("test_password")
                .setEmail("test_email@test_domain.com")
                .build();

        userRepository.save(user);
        Optional<User> userOptional = userRepository.findByEmail("test_email@test_domain.com");
        assertThat(userOptional).isPresent();
        assertThat(userOptional.get().getName()).isEqualTo("test_user");
        assertThat(userOptional.get().getPassword()).isEqualTo("test_password");
    }
}
