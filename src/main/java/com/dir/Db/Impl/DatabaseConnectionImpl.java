package com.dir.Db.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import com.dir.Db.DatabaseConnection;

public class DatabaseConnectionImpl implements DatabaseConnection {
    
    private Connection connection;
    private String className;
    private String url;
    private String userName;
    private String password;
    private static Builder instance;

    private DatabaseConnectionImpl() {
    }
    
    public static Builder newInstance() {
	if (instance == null)
	    instance = new DatabaseConnectionImpl().new Builder();
	return instance;
    }
    
    public void createConnection() {
	// TODO Auto-generated method stub
	try {
	    Class.forName(className);
	    connection = DriverManager.getConnection(url, userName, password);
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public Connection getConnection() {
	// TODO Auto-generated method stub
	return connection;
    }

    public void closeConnection() {
	// TODO Auto-generated method stub
	try {
	    if (connection != null)
		connection.close();
	} catch (SQLException e) {
	    System.out.println(e.toString());
	}
    }

    public class Builder {
	private Builder() {	    
	}
	
	public Builder setClassName(String className) {
	    DatabaseConnectionImpl.this.className = className;
	    return this;
	}

	public Builder setUrl(String url) {
	    DatabaseConnectionImpl.this.url = url;
	    return this;
	}

	public Builder setUserName(String userName) {
	    DatabaseConnectionImpl.this.userName = userName;
	    return this;
	}

	public Builder setPassword(String password) {
	    DatabaseConnectionImpl.this.password = password;
	    return this;
	}

	public DatabaseConnection build() {
	    if (Objects.isNull(className))
		throw new NullPointerException("ClassName is null. Please, check it!");
	    return DatabaseConnectionImpl.this;
	}
    }
}
