package com.dmcelligott.meeting;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by David on 12/19/2016.
 */
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
