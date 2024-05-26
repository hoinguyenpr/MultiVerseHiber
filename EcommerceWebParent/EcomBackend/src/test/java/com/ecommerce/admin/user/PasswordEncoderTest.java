package com.ecommerce.admin.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

    @Test
    public void testEnCoderPassword() {
        String rawPwd = "User123123";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encoder = bCryptPasswordEncoder.encode(rawPwd);

        boolean match = bCryptPasswordEncoder.matches(rawPwd, encoder);

        Assertions.assertThat(match)
                .isTrue();
    }

}
