package com.tyeporter.halloffamers.repo;

import com.tyeporter.halloffamers.model.HallOfFamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallOfFamerRepo extends JpaRepository<HallOfFamer, Integer> {}
