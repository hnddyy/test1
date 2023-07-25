package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.domain.dto.HeartRate;
import org.example.domain.dto.SearchDto;
import org.example.domain.dto.Stress;
import org.example.domain.entity.FitrockrBody;
import org.example.domain.entity.FitrockrBodyId;
import org.example.repository.FitrockrBodyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;


@Log4j2
@Transactional
@RequiredArgsConstructor
@Service
public class FitrockrBodyService {

    private final FitrockrBodyRepository repository;
    private final ModelMapper modelMapper;

    public void addHeartRate(Mono<HeartRate[]> heartRateFlux) {
        heartRateFlux.subscribe(heartRates -> {
                    for(HeartRate heartRate : heartRates) {
                        FitrockrBody bodyData = modelMapper.map(heartRate, FitrockrBody.class);
                        repository.save(bodyData);
                    }
                });
    }

    public void addStress(Mono<Stress[]> stressFlux) {
        stressFlux.subscribe(stresses -> {
           for(Stress stress : stresses) {
               FitrockrBody bodyData = modelMapper.map(stress, FitrockrBody.class);
               var data = repository.findById(new FitrockrBodyId(bodyData.getUserId(), bodyData.getStartDateTime()));
               if (data.isPresent())  {
                   var f = data.get();
                   f.setSource(bodyData.getSource());
                   f.setStressLevelValue(bodyData.getStressLevelValue());
                   f.setAverageIntensity(bodyData.getAverageIntensity());
                   f.setBodyBattery(bodyData.getBodyBattery());
                   f.setBodyBatteryStatus(bodyData.getBodyBatteryStatus());
                   repository.save(f);
               } else {
                   repository.save(bodyData);
               }
           }
        });
    }

    public String getData(SearchDto searchDto) {
        return repository.findById(new FitrockrBodyId(searchDto.getSearchUserId(), searchDto.getSearchStartDate())).get().toString();
    }

}
