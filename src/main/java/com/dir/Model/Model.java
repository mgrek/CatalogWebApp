package com.dir.Model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.dir.Catalog.Organization;
import com.dir.Db.DatabaseConnection;
import com.dir.Db.Repository;
import com.dir.Db.Impl.DatabaseConnectionImpl;
import com.dir.Db.Impl.RepositoryImpl;

public class Model {
    private static Model instance;
    private Repository repository;
    private DatabaseConnection dbConnection;
    
    private final static String CLASSNAME = "org.h2.Driver";
    private final static String URL = "jdbc:h2:mem:";
    
    private Model() {
	dbConnection = DatabaseConnectionImpl.newInstance()
		.setClassName(CLASSNAME)
		.setUrl(URL)
		.build();
	dbConnection.createConnection();
	repository = RepositoryImpl.newBuilder()
		.setConnection(dbConnection.getConnection())
		.build();
	repository.createRepository();
    }
    
    public static Model getInstance() {
	if (instance == null)
	    instance = new Model();
	return instance;
    }
    
    public void add(Organization organization) {
	repository.addInformation(organization.getOrganization());
    }
    
    @SuppressWarnings("unchecked")
    public List<Organization> show() {
	return (List<Organization>) repository.findInformation();
    }
    
    @SuppressWarnings("unchecked")
    public List<Organization> find(Map<?,?> conditions) {
	return (List<Organization>) repository.findInformation(conditions);
    }
    
    public void delete() {
	repository.removeInformation(Collections.emptyMap());
    }
    
    public void create() {
	repository.createRepository();
    }
}
