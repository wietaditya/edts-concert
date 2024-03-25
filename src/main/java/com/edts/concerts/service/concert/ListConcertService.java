package com.edts.concerts.service.concert;

import com.edts.concerts.Repository.ConcertRepository;
import com.edts.concerts.constant.ConcertStatusEnum;
import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.concert.ConcertRespDto;
import com.edts.concerts.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ListConcertService {

    private final ConcertRepository concertRepository;
    private final ModelMapper modelMapper;

    public ListConcertService(ConcertRepository concertRepository, ModelMapper modelMapper) {
        this.concertRepository = concertRepository;
        this.modelMapper = modelMapper;
    }

    public BaseResponse<List<ConcertRespDto>> listConcert() {
        log.info("start get list concert");
        var concerts = concertRepository.findAllByStatus(ConcertStatusEnum.AVAILABLE.getValue());

        List<ConcertRespDto> result = concerts
                .stream()
                .map(concert -> modelMapper.map(concert, ConcertRespDto.class))
                .collect(Collectors.toList());

        return ResponseUtil.success(result);
    }
}
