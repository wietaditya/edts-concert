package com.edts.concerts.service.concert;

import com.edts.concerts.Repository.ConcertRepository;
import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.model.Concert;
import com.edts.concerts.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DetailConcertService {

    private final ConcertRepository concertRepository;
    private final ModelMapper modelMapper;

    public DetailConcertService(ConcertRepository concertRepository, ModelMapper modelMapper) {
        this.concertRepository = concertRepository;
        this.modelMapper = modelMapper;
    }

    public BaseResponse<Concert> getConcertDetail(Long id) {
        log.info("getting concert detail id : {}", id);

        Optional<Concert> concert = concertRepository.findById(id);

        if (concert.isEmpty()) {
            throw new ObjectNotFoundException("Detail concert with id {} not found", id);
        }

        return ResponseUtil.success(concert.get());
    }
}
