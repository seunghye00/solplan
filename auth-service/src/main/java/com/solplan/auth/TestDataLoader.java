package com.solplan.auth;

import com.solplan.auth.domain.User;
import com.solplan.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        // 테스트용 유저 저장
        userRepository.save(User.builder()
                .email("test@solplan.com")
                .name("테스트유저")
                .build());

        System.out.println("✅ 테스트 유저 저장 완료!");
    }
}