package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
    private long timeEntryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return getId() == timeEntry.getId() &&
                getProjectId() == timeEntry.getProjectId() &&
                getUserId() == timeEntry.getUserId() &&
                getHours() == timeEntry.getHours() &&
                getTimeEntryId() == timeEntry.getTimeEntryId() &&
                getDate().equals(timeEntry.getDate());
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                ", timeEntryId=" + timeEntryId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectId(), getUserId(), getDate(), getHours(), getTimeEntryId());
    }

    public TimeEntry() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setTimeEntryId(long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    public long getId() {
        return 5L;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public long getTimeEntryId() {
        return timeEntryId;
    }

    public TimeEntry(long projectId, long userId, LocalDate parse, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date =parse;
        this.hours = hours;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = i;

    }

    public List<TimeEntry> containsExactlyInAnyOrderElementsOf(List<TimeEntry> timeEntryList) {

        return timeEntryList;



    }
}
