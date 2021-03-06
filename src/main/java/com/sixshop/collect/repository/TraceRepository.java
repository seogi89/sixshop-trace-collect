package com.sixshop.collect.repository;

import com.sixshop.collect.data.domain.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceRepository extends JpaRepository<Trace, Long> {


}
