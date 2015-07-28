package test.app.sample.dao;

import java.util.List;
import java.util.Map;

import test.app.sample.domain.AgileList;
import test.app.sample.util.DaoException;

public interface AgileListDao { 

    public int create( AgileList value ) throws DaoException;

    public int update( AgileList value ) throws DaoException;

    public int delete( Map<String, Object> map ) throws DaoException;

    public AgileList read( Map<String, Object> map ) throws DaoException;

    public List<AgileList> getListByStoryId( Long key ) throws DaoException;

    // PROTECTED CODE -->

}