package test.app.sample.bo;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;
import test.app.sample.domain.*;
import test.app.sample.dao.*;
import test.app.sample.util.*;

public class TestSprintBo {

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws BoException {

        SprintBo sprintBo = SprintBo.getInstance();

        Sprint sprint = TestSprintDao.createSprint();
        int count = sprintBo.create( sprint );
        assertEquals( 1, count );

        Sprint readRecord = sprintBo.read( sprint.getBacklogId(), sprint.getDoingId(), sprint.getDoneId() );
        assertNotNull( readRecord.getBacklogId() );

        TestSprintDao.compareRecords( sprint, readRecord );

        List<Sprint> list1= sprintBo.getListByBacklogId( sprint.getBacklogId() ) ; 
        assertEquals( 1 , list1.size() );

        List<Sprint> list2= sprintBo.getListByDoingId( sprint.getDoingId() ) ; 
        assertEquals( 1 , list2.size() );

        List<Sprint> list3= sprintBo.getListByDoneId( sprint.getDoneId() ) ; 
        assertEquals( 1 , list3.size() );

        TestSprintDao.modifyRecord( sprint );
        count = sprintBo.update( sprint );
        assertEquals( 1, count );

        count = sprintBo.delete( sprint.getBacklogId(), sprint.getDoingId(), sprint.getDoneId());
        assertEquals( 1, count );

        readRecord = sprintBo.read( sprint.getBacklogId(), sprint.getDoingId(), sprint.getDoneId());
        assertNull( readRecord );

    }
    // PROTECTED CODE -->

}