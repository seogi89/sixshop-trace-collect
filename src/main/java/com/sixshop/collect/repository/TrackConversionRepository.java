package com.sixshop.collect.repository;

import com.sixshop.collect.data.domain.TrackConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackConversionRepository extends JpaRepository<TrackConversion, Long> {


}
