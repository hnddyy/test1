package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.domain.dto.MemberDto;
import org.example.domain.entity.Member;
import org.example.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository repository;
    private final ModelMapper modelMapper;

    String join(MemberDto memberDto) {
        Member member = modelMapper.map(memberDto, Member.class);
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    void validateDuplicateMember(Member member) {
        Optional<Member> optionalMember = repository.findById(member.getId());
        if (optionalMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
