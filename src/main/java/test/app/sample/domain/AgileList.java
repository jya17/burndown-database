package test.app.sample.domain;


/**
* The AgileList Table.
*/
public class AgileList {

    private Long      key;
    private String    title;
    private Long      storyId;              //Cards/stories in the list

    public Long      getKey() { return key; }
    public void      setKey( Long value ) { key = value; }
    public String    getTitle() { return title; }
    public void      setTitle( String value ) { title = value; }
    public Long      getStoryId() { return storyId; }
    public void      setStoryId( Long value ) { storyId = value; }
    // PROTECTED CODE -->

}