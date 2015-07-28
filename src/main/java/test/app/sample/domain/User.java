package test.app.sample.domain;


//sprintId constrainsTo Sprint.key
public class User {

    private Long      key;
    private String    username;
    private String    password;
    private String    firstName;
    private String    lastName;
    private String    email;
    private Long      projectId;
    private Long      sprintId;

    public Long      getKey() { return key; }
    public void      setKey( Long value ) { key = value; }
    public String    getUsername() { return username; }
    public void      setUsername( String value ) { username = value; }
    public String    getPassword() { return password; }
    public void      setPassword( String value ) { password = value; }
    public String    getFirstName() { return firstName; }
    public void      setFirstName( String value ) { firstName = value; }
    public String    getLastName() { return lastName; }
    public void      setLastName( String value ) { lastName = value; }
    public String    getEmail() { return email; }
    public void      setEmail( String value ) { email = value; }
    public Long      getProjectId() { return projectId; }
    public void      setProjectId( Long value ) { projectId = value; }
    public Long      getSprintId() { return sprintId; }
    public void      setSprintId( Long value ) { sprintId = value; }
    // PROTECTED CODE -->

}