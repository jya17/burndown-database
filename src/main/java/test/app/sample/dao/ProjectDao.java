package test.app.sample.dao;

import java.util.List;
import java.util.Map;

import test.app.sample.domain.Project;
import test.app.sample.util.DaoException;

public interface ProjectDao { 

    public int create( Project value ) throws DaoException;

    public int update( Project value ) throws DaoException;

    public int delete( Map<String, Object> map ) throws DaoException;

    public Project read( Map<String, Object> map ) throws DaoException;

    public List<Project> getListByBacklogId( Long key ) throws DaoException;

    // PROTECTED CODE -->

}