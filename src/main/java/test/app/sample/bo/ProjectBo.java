package test.app.sample.bo;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.*;
import test.app.sample.dao.*;
import test.app.sample.domain.Project;
import test.app.sample.util.BoException;

public class ProjectBo {

    private static ProjectBo instance = new ProjectBo();

    public static ProjectBo getInstance() {
        return instance;
    } 

    private ProjectBo() {
    } 

    public int create( Project value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            ProjectDao mapper = session.getMapper( ProjectDao.class );
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

    public int update( Project value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            ProjectDao mapper = session.getMapper( ProjectDao.class );
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
            ProjectDao mapper = session.getMapper( ProjectDao.class );
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

    public Project read( Long key ) throws BoException {
        SqlSession session = null;
        Project result;
        String where = "KEY='" + key + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            ProjectDao mapper = session.getMapper( ProjectDao.class );
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

    public List<Project> getListByBacklogId( Long key ) throws BoException {
        SqlSession session = null;
        List<Project> list;

        try {
            session = SessionFactory.getSession();
            ProjectDao mapper = session.getMapper( ProjectDao.class );
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

    // PROTECTED CODE -->

}