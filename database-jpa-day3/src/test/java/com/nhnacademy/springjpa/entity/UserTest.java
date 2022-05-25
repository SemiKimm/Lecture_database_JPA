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
        userType1.setCode(1);
        userType1.setValue("관리자");
        userTypeRepository.save(userType1);

        User admin = new User();
        admin.setId("admin1");
        admin.setNickname("관리자1");
        admin.setPassword("1234");
        admin.setType(userType1);
        userRepository.save(admin);

        assertThat(admin.getType().getValue()).isEqualTo(userType1.getValue());

    }
}