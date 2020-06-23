package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository ;
   // private InMemoryTimeEntryRepository inMemoryTimeEntryRepository ;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @GetMapping("{id}")
    public ResponseEntity read(@PathVariable long id) {

        TimeEntry createdTimeEntry = timeEntryRepository.find(id);
        if(null==createdTimeEntry)
            return new ResponseEntity<>(createdTimeEntry, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(createdTimeEntry, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = timeEntryRepository.update(timeEntryId, timeEntry);
        if(null==createdTimeEntry)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(createdTimeEntry, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry newTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(newTimeEntry, HttpStatus.CREATED);
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
