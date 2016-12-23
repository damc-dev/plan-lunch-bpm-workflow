package com.dmcelligott.invitation;

import com.dmcelligott.meeting.Meeting;
import com.dmcelligott.person.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by David on 12/19/2016.
 */
@Entity
public class Invitation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Meeting.class)
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
    private Person person;

    private Boolean isGoing;

    private Date updatedDate;

    public Invitation() {
    }

    public Invitation(Meeting meeting, Person person) {
        this.meeting = meeting;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getGoing() {
        return isGoing;
    }

    public void setGoing(Boolean going) {
        isGoing = going;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invitation that = (Invitation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (meeting != null ? !meeting.equals(that.meeting) : that.meeting != null) return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (isGoing != null ? !isGoing.equals(that.isGoing) : that.isGoing != null) return false;
        return updatedDate != null ? updatedDate.equals(that.updatedDate) : that.updatedDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (meeting != null ? meeting.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (isGoing != null ? isGoing.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invitation{");
        sb.append("id=").append(id);
        sb.append(", meeting=").append(meeting);
        sb.append(", person=").append(person);
        sb.append(", isGoing=").append(isGoing);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append('}');
        return sb.toString();
    }
}
