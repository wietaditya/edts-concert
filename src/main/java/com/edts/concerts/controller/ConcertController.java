package com.edts.concerts.controller;

import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.concert.ConcertRespDto;
import com.edts.concerts.model.Concert;
import com.edts.concerts.service.concert.DetailConcertService;
import com.edts.concerts.service.concert.ListConcertService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/concert")
public class ConcertController {

    private final ListConcertService listConcertService;
    private final DetailConcertService detailConcertService;

    public ConcertController(ListConcertService listConcertService, DetailConcertService detailConcertService) {
        this.listConcertService = listConcertService;
        this.detailConcertService = detailConcertService;
    }

    @GetMapping("/list")
    @ResponseBody
    BaseResponse<List<ConcertRespDto>> listConcert() {
        return listConcertService.listConcert();
    }

    @GetMapping("/getById")
    @ResponseBody
    BaseResponse<Concert> getById(Long id) {
        return detailConcertService.getConcertDetail(id);
    }
}
