package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private HashMap<Long,TimeEntry>  timeEntryStore= new HashMap<>();

    private Long initialId = 1L;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = initialId++;
  TimeEntry newTimeEntry = new TimeEntry(
                      id,
                      timeEntry.getProjectId(),
                      timeEntry.getUserId(),
                      timeEntry.getDate(),
          timeEntry.getHours()
          )      ;


        timeEntryStore.put(id, newTimeEntry);
        //id = initialId ++;
        return newTimeEntry;
    }
    @Override
    public TimeEntry find(long timeEntryId) {

        System.out.println("timeEntryId->"+timeEntryId);
        System.out.println("timeEntryStore->"+timeEntryStore);
        return timeEntryStore.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryList = new ArrayList<TimeEntry>();
        timeEntryList.addAll(timeEntryStore.values());
        return timeEntryList;
    }
    @Override
   public TimeEntry update(long id, TimeEntry timeEntry) {
        if(timeEntryStore.containsKey(id)) {
            TimeEntry newTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours() );
            timeEntryStore.put(id, newTimeEntry);
            return newTimeEntry;
        }
        else {
            return  null;
        }
    }

    @Override
    public void delete(long id) {
        timeEntryStore.remove(id);
    }
}
