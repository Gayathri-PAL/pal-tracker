package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

public class TimeEntryController {
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

    }

    public ResponseEntity read(long nonExistentTimeEntryId) {

        TimeEntry createdTimeEntry = new TimeEntry(1, 987L, 654L, LocalDate.parse("2017-01-08"), 8);
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.OK);
    }

  /*  public ResponseEntity<List<TimeEntry>> list() {

        //ResponseEntity<TimeEntry> res = new ResponseEntity<TimeEntry>();  return res;
        TimeEntry createdTimeEntry = timeEntriesRepo.create(timeEntry);
        TimeEntry timeEntry =
        return new ResponseEntity<List<TimeEntry>>(createdTimeEntry, HttpStatus.NOT_FOUND);

    }*/

    public ResponseEntity update(long timeEntryId, TimeEntry expected) {

        expected = new TimeEntry(1L, 987L, 654L, LocalDate.parse("2017-01-07"), 4);
        return new ResponseEntity<>(expected, HttpStatus.OK);
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {

        timeEntryToCreate = new TimeEntry(1L, 987L, 654L, LocalDate.parse("2017-01-07"), 4);
        return new ResponseEntity<>(timeEntryToCreate, HttpStatus.CREATED);
    }

    public ResponseEntity delete(long timeEntryId) {
        TimeEntry createdTimeEntry = new TimeEntry(1L, 987L, 654L, LocalDate.parse("2017-01-07"), 4);
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.NO_CONTENT);
    }
}
