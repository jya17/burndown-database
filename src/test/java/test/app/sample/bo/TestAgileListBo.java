package test.app.sample.bo;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;
import test.app.sample.domain.*;
import test.app.sample.dao.*;
import test.app.sample.util.*;

public class TestAgileListBo {

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws BoException {

        AgileListBo agileListBo = AgileListBo.getInstance();

        AgileList agileList = TestAgileListDao.createAgileList();
        int count = agileListBo.create( agileList );
        assertEquals( 1, count );

        AgileList readRecord = agileListBo.read( agileList.getKey() );
        assertNotNull( readRecord.getKey() );

        TestAgileListDao.compareRecords( agileList, readRecord );

        List<AgileList> list1= agileListBo.getListByStoryId( agileList.getStoryId() ) ; 
        assertEquals( 1 , list1.size() );

        TestAgileListDao.modifyRecord( agileList );
        count = agileListBo.update( agileList );
        assertEquals( 1, count );

        count = agileListBo.delete( agileList.getKey());
        assertEquals( 1, count );

        readRecord = agileListBo.read( agileList.getKey());
        assertNull( readRecord );

    }
    // PROTECTED CODE -->

}