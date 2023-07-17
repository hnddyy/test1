package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Log4j2
@Transactional
@RequiredArgsConstructor
@Service
public class FitrockrBodyService {


    public void getFirockrBodyToday() {
//        FitrockrBody data = repository.findByNo(1L);
        log.debug("test");
    }
}
