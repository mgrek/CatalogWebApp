package com.dir.Db;

import java.sql.Connection;

public interface DatabaseConnection {    
    void createConnection();
    Connection getConnection();
    void closeConnection();
}
