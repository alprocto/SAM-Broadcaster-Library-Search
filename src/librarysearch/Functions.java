/*
 * Copyright (C) 2015 alprocto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package librarysearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alprocto
 */
class Functions {

   static Connection sqlCon = null;
   static PreparedStatement sqlPst = null;

    //database login info
    private static String url = null;
    private static String user = null;
    private static String passwd = null;
    
    static void setDBInfo(String inputFile) {
        Properties props = new Properties();
        FileInputStream in = null;

        try {
            in = new FileInputStream(inputFile);
            props.load(in);

        } catch (FileNotFoundException ex) {

            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (IOException ex) {

            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger lgr = Logger.getLogger(Functions.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        url = props.getProperty("db.url");
        user = props.getProperty("db.user");
        passwd = props.getProperty("db.passwd");

    }
    
    static void setDBInfo(String url, String user, String passwd) {
        Functions.url = url;
        Functions.user = user;
        Functions.passwd = passwd;
        
    }

    static ResultSet sqlSelect(String statement) {
        if (url == null || user == null || passwd == null) {
            return null;
        }

        sqlCon = null;
        sqlPst = null;
        ResultSet rs = null;
        try {
            sqlCon = DriverManager.getConnection(url, user, passwd);
            sqlPst = sqlCon.prepareStatement(statement);
            rs = sqlPst.executeQuery();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return rs;
    }

    static void sqlCloseResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (sqlPst != null) {
                sqlPst.close();
                sqlPst = null;
            }
            if (sqlCon != null) {
                sqlCon.close();
                sqlCon = null;
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }

    }

    static void sqlUpdate(String statement) {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DriverManager.getConnection(url, user, passwd);

            pst = con.prepareStatement(statement);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Functions.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

 
    static String searchFunctions(String input) {
        ResultSet rs;
        int count = 0;

        String statement = "SELECT COUNT(*) FROM `users` WHERE name LIKE '%" + input + "%'";
        rs = Functions.sqlSelect(statement);
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
        Functions.sqlCloseResultSet(rs);

        statement = "SELECT * FROM `users` WHERE name LIKE '%" + input + "%' ORDER BY name";
        int[] onecardResults = new int[count];
        String[] nameResults = new String[count];
        String[] emailResults = new String[count];

        ResultSet rs2 = Functions.sqlSelect(statement);

        try {
            for (int i = 0; i < count && rs2.next(); i++) {
                onecardResults[i] = rs2.getInt("onecard");
                nameResults[i] = rs2.getString("name");
                emailResults[i] = rs2.getString("email");
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Functions.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
        Functions.sqlCloseResultSet(rs2);

        String output = "";

        for (int i = 0; i < onecardResults.length; i++) {
            output = output + onecardResults[i] + "\t" + nameResults[i] + "\t" + emailResults[i] + "\n";
        }

        return output;
    }

}
