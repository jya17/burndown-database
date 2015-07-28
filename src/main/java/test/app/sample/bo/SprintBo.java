package test.app.sample.bo;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.*;
import test.app.sample.dao.*;
import test.app.sample.domain.Sprint;
import test.app.sample.util.BoException;

public class SprintBo {

    private static SprintBo instance = new SprintBo();

    public static SprintBo getInstance() {
        return instance;
    } 

    private SprintBo() {
    } 

    public int create( Sprint value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            result = mapper.create( value );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public int update( Sprint value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            result = mapper.update( value );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public int delete( Long key ) throws BoException {
        SqlSession session = null;
        int result = 0;
        String where = "KEY='" + key + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            result = mapper.delete( map );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public Sprint read( Long key ) throws BoException {
        SqlSession session = null;
        Sprint result;
        String where = "KEY='" + key + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            result = mapper.read( map );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public List<Sprint> getListByBacklogId( Long key ) throws BoException {
        SqlSession session = null;
        List<Sprint> list;

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            list = mapper.getListByBacklogId( key );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return list;
    }

    public List<Sprint> getListByDoingId( Long key ) throws BoException {
        SqlSession session = null;
        List<Sprint> list;

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            list = mapper.getListByDoingId( key );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return list;
    }

    public List<Sprint> getListByDoneId( Long key ) throws BoException {
        SqlSession session = null;
        List<Sprint> list;

        try {
            session = SessionFactory.getSession();
            SprintDao mapper = session.getMapper( SprintDao.class );
            list = mapper.getListByDoneId( key );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return list;
    }

    // PROTECTED CODE -->

}