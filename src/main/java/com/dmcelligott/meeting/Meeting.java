package com.dmcelligott.meeting;

import com.dmcelligott.invitation.Invitation;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by David on 12/19/2016.
 */
@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private Long id;

    private String location;

    private Date startTime;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Invitation.class)
    private List<Invitation> invitees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public List<Invitation> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<Invitation> invitees) {
        this.invitees = invitees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting meeting = (Meeting) o;

        if (id != null ? !id.equals(meeting.id) : meeting.id != null) return false;
        if (location != null ? !location.equals(meeting.location) : meeting.location != null) return false;
        if (startTime != null ? !startTime.equals(meeting.startTime) : meeting.startTime != null) return false;
        return invitees != null ? invitees.equals(meeting.invitees) : meeting.invitees == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (invitees != null ? invitees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Meeting{");
        sb.append("id=").append(id);
        sb.append(", location='").append(location).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", invitees=").append(invitees);
        sb.append('}');
        return sb.toString();
    }
}
