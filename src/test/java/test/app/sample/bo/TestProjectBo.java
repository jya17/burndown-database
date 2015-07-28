package test.app.sample.bo;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;
import test.app.sample.domain.*;
import test.app.sample.dao.*;
import test.app.sample.util.*;

public class TestProjectBo {

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws BoException {

        ProjectBo projectBo = ProjectBo.getInstance();

        Project project = TestProjectDao.createProject();
        int count = projectBo.create( project );
        assertEquals( 1, count );

        Project readRecord = projectBo.read( project.getKey() );
        assertNotNull( readRecord.getKey() );

        TestProjectDao.compareRecords( project, readRecord );

        List<Project> list1= projectBo.getListByBacklogId( project.getBacklogId() ) ; 
        assertEquals( 1 , list1.size() );

        TestProjectDao.modifyRecord( project );
        count = projectBo.update( project );
        assertEquals( 1, count );

        count = projectBo.delete( project.getKey());
        assertEquals( 1, count );

        readRecord = projectBo.read( project.getKey());
        assertNull( readRecord );

    }
    // PROTECTED CODE -->

}