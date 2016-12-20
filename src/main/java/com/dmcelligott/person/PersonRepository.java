package com.dmcelligott.person;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by David on 12/19/2016.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
