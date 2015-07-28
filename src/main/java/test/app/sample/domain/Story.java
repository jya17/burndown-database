package test.app.sample.domain;


/**
* The Story Table.
*/
public class Story {

    private Long      key;
    private String    description;
    private Integer   estimatedHours;       //Total time it will take to complete
    private Integer   remainingHours;       //Remaining time it will take to complete
    private Integer   projectId;            //Project's backlog

    public Long      getKey() { return key; }
    public void      setKey( Long value ) { key = value; }
    public String    getDescription() { return description; }
    public void      setDescription( String value ) { description = value; }
    public Integer   getEstimatedHours() { return estimatedHours; }
    public void      setEstimatedHours( Integer value ) { estimatedHours = value; }
    public Integer   getRemainingHours() { return remainingHours; }
    public void      setRemainingHours( Integer value ) { remainingHours = value; }
    public Integer   getProjectId() { return projectId; }
    public void      setProjectId( Integer value ) { projectId = value; }
    // PROTECTED CODE -->

}