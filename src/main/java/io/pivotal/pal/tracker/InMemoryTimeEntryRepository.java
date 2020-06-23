package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry) {
        return timeEntry;
    }

    public TimeEntry find(long timeEntryId) {

        TimeEntry timeEntry = new TimeEntry(123L, 456L, LocalDate.parse("2017-01-08"), 8);
        return timeEntry;
    }

    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryList = asList(
                new TimeEntry(1L, 123L, 456L, LocalDate.parse("2017-01-08"), 8),
                new TimeEntry(2L, 789L, 654L, LocalDate.parse("2017-01-07"), 4));
        return timeEntryList;
    }

   public TimeEntry update(long id, TimeEntry timeEntry) {

       TimeEntry expected = new TimeEntry(5L, 321L, 654L, LocalDate.parse("2017-01-09"), 5);
       return expected;
    }

    public void delete(long id) {
    }
}
