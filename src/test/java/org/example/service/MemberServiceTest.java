package org.example.service;

import org.example.domain.dto.MemberDto;
import org.example.domain.entity.Member;
import org.example.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberServiceTest {

    @Mock
    MemberRepository repository;
    ModelMapper modelMapper;
    MemberService memberService;

    @BeforeEach
    void setup() {
        this.modelMapper = new ModelMapper();
        this.memberService = new MemberService(repository, this.modelMapper);
    }

    @Test
    public void join() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("t1");
        memberDto.setAge(30);
        memberDto.setName("test");
        memberDto.setGroupId("64703f032ea7495a37566b23");

        when(repository.findById(anyString())).thenReturn(Optional.empty());
        assertEquals("t1", memberService.join(memberDto));
    }

    @Test
    public void join_exception() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("t1");
        memberDto.setAge(30);
        memberDto.setName("test");
        memberDto.setGroupId("64703f032ea7495a37566b23");

        Member member = modelMapper.map(memberDto, Member.class);
        Optional<Member> om = Optional.of(member);
        when(repository.findById(anyString())).thenReturn(om);

        Throwable throwable = catchThrowable(()-> memberService.join(memberDto));
        then(throwable).isInstanceOf(IllegalStateException.class).hasMessage("이미 존재하는 회원입니다.");
    }
}