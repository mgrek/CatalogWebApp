package com.dir.Db.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.dir.Catalog.Organization;
import com.dir.Db.Repository;
import com.dir.Exceptions.CatalogException;
import com.dir.Parameters.ParametersDb;

public class RepositoryImpl implements Repository {

    private Connection connection;
    private final String CREATE_CATALOG = "CREATE TABLE IF NOT EXISTS CATALOG (ID INT PRIMARY KEY AUTO_INCREMENT,"
	    + " NAME VARCHAR2(100) NOT NULL," 
	    + " INN VARCHAR2(100) NOT NULL," 
	    + " OGRN VARCHAR2(100) NOT NULL, " 
	    + " ADRESS VARCHAR2 (100) NOT NULL)";
    private final String INSERT_CATALOG = "INSERT INTO CATALOG (NAME, INN, OGRN, ADRESS) VALUES (?,?,?,?)";
    private final String SELECT_CATALOG = "SELECT * FROM CATALOG ";
    private final String DELETE_CATALOG = "DELETE FROM CATALOG ";
    private final String UPDATE_CATALOG = "UPDATE CATALOG SET ";
    private final String WHERE_CATALOG = "WHERE 1=1 ";
    private final String AND = "AND ";

    private RepositoryImpl() {
    }

    public static Builder newBuilder() {
	return new RepositoryImpl().new Builder();
    }

    public boolean addInformation(Map<?, ?> catalog) {
	// TODO Auto-generated method stub
	PreparedStatement stmnt;
	try {
	    stmnt = connection.prepareStatement(INSERT_CATALOG);
	    stmnt.setString(1, (String) catalog.get(ParametersDb.NAME));
	    stmnt.setString(2, (String) catalog.get(ParametersDb.INN));
	    stmnt.setString(3, (String) catalog.get(ParametersDb.OGRN));
	    stmnt.setString(4, (String) catalog.get(ParametersDb.ADRESS));
	    stmnt.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    throw new CatalogException(e.toString());
	}
	return false;
    }

    public boolean createRepository() {
	// TODO Auto-generated method stub
	try {
	    PreparedStatement stmnt = connection.prepareStatement(CREATE_CATALOG);
	    stmnt.execute();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    throw new CatalogException(e.toString());
	}
	return false;
    }

    public List<?> findInformation() {
	return findInformation(Collections.emptyMap());
    }
    
    public List<?> findInformation(Map<?, ?> conditions) {
	// TODO Auto-generated method stub
	List<Organization> organizations = new LinkedList<>();
	StringBuilder sqlRequest = new StringBuilder(SELECT_CATALOG);
	if (!conditions.isEmpty()) {
	    sqlRequest.append(getCondition(conditions));
	}
	try (PreparedStatement stmnt = connection.prepareStatement(sqlRequest.toString())) {
	    ResultSet result = stmnt.executeQuery();
	    while (result.next()) {
		Organization organization = Organization.newBuilder()
			.setName(result.getString(ParametersDb.NAME.toString()))
			.setINN(result.getString(ParametersDb.INN.toString()))
			.setOGRN(result.getString(ParametersDb.OGRN.toString()))
			.setAdress(result.getString(ParametersDb.ADRESS.toString()))
			.build();
		organizations.add(organization);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    throw new CatalogException(e.toString());
	}
	return organizations;
    }

    public boolean removeInformation(Map<?, ?> conditions) {
	// TODO Auto-generated method stub
	StringBuilder sqlRequest = new StringBuilder(DELETE_CATALOG);
	if (!conditions.isEmpty()) {
	    sqlRequest.append(getCondition(conditions));
	}
	try (PreparedStatement stmnt = connection
		.prepareStatement(sqlRequest.toString())){
	    stmnt.executeUpdate();
	} catch(SQLException e) {
	    throw new CatalogException(e.toString());
	}
	return false;
    }

    public boolean updateInformation(Map<?, ?> conditions) {
	// TODO Auto-generated method stub
	StringBuilder sqlRequest = new StringBuilder(UPDATE_CATALOG);
	if (!conditions.isEmpty()) {
	    sqlRequest.append(getCondition(conditions));
	}
	try (PreparedStatement stmnt = connection
		.prepareStatement(sqlRequest.toString())){
	    stmnt.executeUpdate();
	} catch(SQLException e) {
	    throw new CatalogException(e.toString());
	}
	return false;
    }

    private String getCondition(Map<?,?> conditions) {
	StringBuilder sqlRequest = new StringBuilder(WHERE_CATALOG);
	if (conditions.containsKey(ParametersDb.NAME))
	    sqlRequest.append(AND).append(ParametersDb.NAME).append('=')
	    	.append('\'')
	    	.append(conditions.get(ParametersDb.NAME)).append("\' ");
	if (conditions.containsKey(ParametersDb.INN))
	    sqlRequest.append(AND).append(ParametersDb.INN).append('=')
	    	.append('\'')
	    	.append(conditions.get(ParametersDb.INN)).append("\' ");
	if (conditions.containsKey(ParametersDb.OGRN))
	    sqlRequest.append(AND).append(ParametersDb.OGRN).append('=')
	    	.append('\'')
	    	.append(conditions.get(ParametersDb.OGRN)).append("\' ");
	if (conditions.containsKey(ParametersDb.ADRESS))
	    sqlRequest.append(AND).append(ParametersDb.ADRESS).append('=')
	    	.append('\'')
	    	.append(conditions.get(ParametersDb.ADRESS)).append('\'');
	return sqlRequest.toString();
    }

    public class Builder {
	private Builder() {
	}

	public Builder setConnection(Connection connection) {
	    RepositoryImpl.this.connection = connection;
	    return this;
	}

	public Repository build() {
	    Objects.requireNonNull(RepositoryImpl.this.connection, "Connection with DB is null");
	    return RepositoryImpl.this;
	}
    }

}
