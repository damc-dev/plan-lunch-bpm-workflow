package com.dmcelligott.invitation;

import com.dmcelligott.invitation.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by David on 12/19/2016.
 */
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}
