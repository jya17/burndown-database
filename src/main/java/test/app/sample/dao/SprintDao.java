package test.app.sample.dao;

import java.util.List;
import java.util.Map;

import test.app.sample.domain.Sprint;
import test.app.sample.util.DaoException;

public interface SprintDao { 

    public int create( Sprint value ) throws DaoException;

    public int update( Sprint value ) throws DaoException;

    public int delete( Map<String, Object> map ) throws DaoException;

    public Sprint read( Map<String, Object> map ) throws DaoException;

    public List<Sprint> getListByBacklogId( Long key ) throws DaoException;
    public List<Sprint> getListByDoingId( Long key ) throws DaoException;
    public List<Sprint> getListByDoneId( Long key ) throws DaoException;

    // PROTECTED CODE -->

}