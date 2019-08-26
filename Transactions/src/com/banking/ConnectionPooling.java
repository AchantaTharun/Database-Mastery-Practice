package com.banking;
import java.sql.*;
public interface ConnectionPooling {
	Connection getConnection();
    boolean releaseConnection(Connection connection);

}
