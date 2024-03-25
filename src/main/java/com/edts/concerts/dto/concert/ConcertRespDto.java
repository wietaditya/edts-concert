package com.edts.concerts.dto.concert;


import lombok.Data;

import java.util.Date;

@Data
public class ConcertRespDto {
    private Long id;
    private String title;
    private String imageUrl;
    private Date schedule;
    private String location;
}
