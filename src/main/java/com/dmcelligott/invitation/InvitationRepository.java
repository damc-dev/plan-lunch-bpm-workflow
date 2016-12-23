package com.dmcelligott.invitation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by David on 12/19/2016.
 */
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    @Query("SELECT i FROM Invitation i WHERE i.meeting.id = :meetingId AND i.person.id = :personId")
    List<Invitation> findByMeetingIdAndPersonId(@Param("meetingId") long meetingId, @Param("personId") long personId);
}
