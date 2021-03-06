package test.app.sample.domain;
import java.util.Date;



/**
* The Sprint Table.
*/
public class Sprint {

    private Long      key;
    private String    title;
    private String    description;
    private Long      backlogId;            //Backlog list
    private Long      doingId;              //Doing list
    private Long      doneId;               //Done list
    private Date      startDate;
    private Date      endDate;

    public Long      getKey() { return key; }
    public void      setKey( Long value ) { key = value; }
    public String    getTitle() { return title; }
    public void      setTitle( String value ) { title = value; }
    public String    getDescription() { return description; }
    public void      setDescription( String value ) { description = value; }
    public Long      getBacklogId() { return backlogId; }
    public void      setBacklogId( Long value ) { backlogId = value; }
    public Long      getDoingId() { return doingId; }
    public void      setDoingId( Long value ) { doingId = value; }
    public Long      getDoneId() { return doneId; }
    public void      setDoneId( Long value ) { doneId = value; }
    public Date      getStartDate() { return startDate; }
    public void      setStartDate( Date value ) { startDate = value; }
    public Date      getEndDate() { return endDate; }
    public void      setEndDate( Date value ) { endDate = value; }
    // PROTECTED CODE -->

}