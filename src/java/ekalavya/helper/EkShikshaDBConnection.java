/*
 * EkShikshaDBConnection.java
 *
 * Created on Jan 24, 2011, 11:29 AM
 */

package ekalavya.helper;

/**
 *
 * @author  ravi
 */

import java.sql.*;
public class EkShikshaDBConnection {



    /** Creates a new instance of oscarDBConnectionBean */
    public EkShikshaDBConnection() { }

    public synchronized static Connection getDBConnection()
    {
        Connection con = null;
        String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("Could not load driver class "+e);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test"+unicode,"","");
        } catch (SQLException e) {
            System.out.println("Could not get connection "+e);
        }
        return con;
    }

    public static void main(String[] args) {
        getDBConnection();
    }
    
    
    public synchronized static void closeDBConnection(Connection con)
    {
        if(con != null) {
            try{
                con.close();
                con = null;
            }
            catch (SQLException e) {
                System.out.println("Could not close Connection "+e);
            }
        }
    }

    public synchronized static void closeStatement(Statement stmt) {
        if(stmt != null) {
            try{
                stmt.close();
                stmt = null;
            }
            catch (SQLException e) {
                System.out.println("Could not close Statement "+e);
            }
        }
    }

    public synchronized static void closePStatement(PreparedStatement pstmt) {
        if(pstmt != null) {
            try{
                pstmt.close();
                pstmt = null;
            }
            catch (SQLException e) {
                System.out.println("Could not close Prepared Statement "+e);
            }
        }
    }

    public synchronized static void closeResultSet(ResultSet res) {
        if(res != null) {
            try{
                res.close();
                res = null;
            }
            catch (SQLException e) {
                System.out.println("Could not close ResultSet "+e);
            }
        }
    }
    public static synchronized boolean isClosed(Connection con) {
        boolean isClosed = false;
        try {
            if(con == null || con.isClosed()) {
                isClosed = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return isClosed;
    }
}
