package com.xavi.rockets;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketsRepository extends CrudRepository<Rocket, Long> {

}
