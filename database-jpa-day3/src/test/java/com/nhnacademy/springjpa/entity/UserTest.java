package com.nhnacademy.springjpa.entity;


import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.repository.UserRepository;
import com.nhnacademy.springjpa.repository.UserTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
class UserTest {
    @Autowired
    UserTypeRepository userTypeRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testUserEntityFind(){
        UserType userType1 = new UserType();
        userType1.setValue("관리자");

        User admin = User.create("admin", "1234", "관리자", userType1);
        userRepository.saveAndFlush(admin);

        User result = userRepository.findById(admin.getNo()).orElse(null);

        assertThat(result).isNotNull();
        assertThat(result.getNo()).isEqualTo(admin.getNo());
        assertThat(result.getId()).isEqualTo("admin");
    }
}