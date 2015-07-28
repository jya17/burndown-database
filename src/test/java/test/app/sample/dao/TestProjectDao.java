package test.app.sample.dao;

import java.util.Date;
import java.util.Random;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.*;
import org.apache.ibatis.session.SqlSession;
import test.app.sample.domain.*;

public class TestProjectDao {

    private static StringBuilder sb = new StringBuilder();
    private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static Random random = new Random();

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws Exception {

        SqlSession session = SessionFactory.getSession();
        ProjectDao projectDao = session.getMapper( ProjectDao.class );

        try {

            Project project = TestProjectDao.createProject();
            String where = "KEY='" + project.getKey() + "' ";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "where", where );

            int count = projectDao.create( project );
            assertEquals( 1, count );
            assertNotNull( project.getKey() );

            Project readRecord = projectDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( project, readRecord );

            List<Project> list1= projectDao.getListByBacklogId( project.getBacklogId() ) ; 
            assertEquals( 1, list1.size() );
            compareRecords( project, list1.get( 0 ) );

            modifyRecord( project );
            count = projectDao.update( project );
            assertEquals( 1, count );

            readRecord = projectDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( project, readRecord );

            count = projectDao.delete( map );
            assertEquals( 1, count );

            readRecord = projectDao.read( map );
            assertNull( readRecord );

        } finally {
            if ( session != null ) {
                session.rollback();
                session.close();
            }
        }
    }

    public static Project createProject() {
        Project project = new Project();

        project.setTitle( randomString( "title", 100 ) );
        project.setDescription( randomString( "description", 1000 ) );
        project.setBacklogId( (long) 0 );
        project.setStartDate( new Date() );
        project.setEndDate( new Date() );

        return project;
    }

    public static void compareRecords( Project project, Project readRecord ) {

        assertEquals( project.getTitle(), readRecord.getTitle() );
        assertEquals( project.getDescription(), readRecord.getDescription() );
        assertEquals( project.getBacklogId(), readRecord.getBacklogId() );
        assertNotSame( project.getStartDate(), readRecord.getStartDate() );
        assertNotSame( project.getEndDate(), readRecord.getEndDate() );

    }

    public static void modifyRecord( Project project ) {

        project.setTitle( randomString( "title", 100 ) );
        project.setDescription( randomString( "description", 1000 ) );
        project.setBacklogId( (long) 0 );
        project.setStartDate( new Date() );
        project.setEndDate( new Date() );

    }

    public static int randomNumber() {

        return (int) ( Math.random() * 10 ) + 0;

    }

    public static String randomString( String fldName, int length ) {

        if ( fldName.length() >= length ) {
            return fldName.substring( 0, length );
        }

        sb.setLength( 0 );
        sb.append( fldName );
        for ( int i = fldName.length(); i < length; i++ ) {
            sb.append( chars.charAt( random.nextInt( chars.length() ) ) );
        }
        return sb.toString();
    }

    public static byte[] randomByteArray( int length ) {

        byte[] byteArray = new byte[length];
        random.nextBytes( byteArray );
        return byteArray;
    }
    // PROTECTED CODE -->

}