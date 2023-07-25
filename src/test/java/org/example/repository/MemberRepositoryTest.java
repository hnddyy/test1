package org.example.repository;

import org.example.domain.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void save() {
        Member member = new Member();
        member.setId("test");
        member.setAge(10);
        member.setName("fdsafdsafa");
        repository.save(member);
    }

    @Test
    void selectOne() {
        Optional<Member> member = repository.findById("646b38efdeb81f4756cfc87a");
        System.out.println(member.toString());
        assertEquals("김정주", member.get().getName());
    }

}