package com.dir.Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.dir.Catalog.Organization;
import com.dir.Db.DatabaseConnection;
import com.dir.Db.Repository;
import com.dir.Db.Impl.DatabaseConnectionImpl;
import com.dir.Db.Impl.RepositoryImpl;

public class RepositoryTest {
    
    @Test
    public void OrganizationTest() {
	Organization organization = Organization.newBuilder()
		.setName("ИП Тест")
		.setINN("1234567890")
		.setOGRN("45545")
		.setAdress("ул. Тестовая")
		.build();
	assertNotNull(organization);
    }
    
    @Test
    public void DatabaseConnectionTest() {
	DatabaseConnection dbConnection = DatabaseConnectionImpl.newInstance()
		.setClassName("org.h2.Driver")
		.setUrl("jdbc:h2:mem:")
		.build();
	assertNotNull(dbConnection);
	
	dbConnection.createConnection();
	assertNotNull(dbConnection.getConnection());
	dbConnection.closeConnection();
	assertNotNull(dbConnection.getConnection());
	Repository repository = RepositoryImpl.newBuilder()
		.setConnection(dbConnection.getConnection()).build();
	assertNotNull(repository);
    }

}
