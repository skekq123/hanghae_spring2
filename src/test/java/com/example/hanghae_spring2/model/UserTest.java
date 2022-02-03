package com.example.hanghae_spring2.model;

import com.example.hanghae_spring2.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {

    @Nested
    @DisplayName("회원 아이디")
    class CreateUser {
        private Long id;
        private String username;
        private String password;
        private String email;
        private UserRoleEnum role;
        private Long kakaoId;

        @BeforeEach
        void setup() {
            id = 10L;
            username = "가나다";
            password = "12344";
            email = "abc@naver.com";
            role = UserRoleEnum.USER;
            kakaoId = 100L;
        }
        @Test
        @DisplayName("정상 케이스")
        void createUser_Normal() {
            SignupRequestDto signupRequestDto = new SignupRequestDto(
                    username,
                    password,
                    email,
                    false,
                    "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC"
            );

            username = signupRequestDto.getUsername();
            password = signupRequestDto.getPassword();
            email = signupRequestDto.getEmail();
            User user = new User(username, password, email, UserRoleEnum.USER, 0L);

            assertNull(user.getId());
            assertEquals(username, user.getUsername());
            assertEquals(email, user.getEmail());
            assertEquals(role, user.getRole());
            assertEquals(kakaoId, user.getKakaoId());
        }


    }
}
