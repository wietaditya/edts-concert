package com.edts.concerts.Repository;

import com.edts.concerts.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    List<Concert> findAllByStatus(String status);

}
