/**
 * @author masterlinnn
 * @project Sudoku Solver
 */
package util;

/*====================Imports=====================*/
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import javax.swing.JOptionPane;
/*====================Imports=====================*/

public class DatabaseConnection {//Database Connection Class

    private String sql;
    private Statement st;
    private ResultSet rs;
    private Connection con;

    /*==================== Get Access Database Path =====================*/
    private Path relativeDBPath = Paths.get("Lin_IT_PAT_2021.accdb");
    private Path abosluteDBPath = relativeDBPath.toAbsolutePath();

    private final String DBPATH = "" + abosluteDBPath;
    private final String DBURL = "jdbc:ucanaccess://" + DBPATH;
    /*==================== Get Access Database Path =====================*/

    /*====================  Database Connection =====================*/
    public DatabaseConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(DBURL);
            System.out.println("Connected To DataBase: \t" + relativeDBPath);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*====================  Database Connection =====================*/

     /*====================  Execute Update =====================*/
    public void executeUpdate(String inSQL) // run update query  without returning result set
    {
        sql = inSQL;
        try {
            st = con.createStatement();
            st.executeUpdate(inSQL);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /*====================  Execute Update =====================*/

    /*====================  Execute SQL And Return Result Set=====================*/
    public ResultSet getRs(String inSQL) // attempt to run query and return result set
    {
        sql = inSQL;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    /*====================  Execute SQL And Return Result Set=====================*/

    /*====================  Determine If Username Exist =====================*/
    public boolean findUser(String inUsername) {
        boolean userFound = true;
        sql = "SELECT Username From tblAccount WHERE StrComp(Username," + "'" + inUsername + "'" + ", 0) = 0";

        try {
            userFound = getRs(sql).next();//Get FirstRole Of Result Set(Will Give Back True/False)
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return userFound;
    }
    /*====================  Determine If Username Exist =====================*/

    /*====================  Get Account Username =====================*/
    public String getAccUsername(int inAccNumber) {
        String username = "";
        sql = "SELECT Username From tblAccount WHERE AccountNumber = " + inAccNumber;
        rs = getRs(sql);//Get FirstRole Of Result Set(Will Give Back True/False)
        try {
            while (rs.next()) {
                username = rs.getString("Username");
            }
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception : " + sqlEx.getMessage());
        }
        return username;
    }
    /*====================  Get Account Username =====================*/

    /*====================  Update Best Time=====================*/
    public void updateBestTime(int inAccNum, String inTime) {
        sql = "SELECT BestTime "
                + "FROM tblAccount "
                + "WHERE AccountNumber = " + inAccNum;
        java.util.List<String> BestTimeList = new java.util.ArrayList<>();
        try {
            rs = getRs(sql);
            while (rs.next()) {
                BestTimeList.add(rs.getString("BestTime"));
            }
            rs.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        String[] arrOldTime = (BestTimeList.get(0)).split(":");
        String[] arrNewTime = inTime.split(":");
        int oldTime = 0; //In Seconds
        int newTime = 0; //In Seconds
        oldTime = (Integer.parseInt(arrOldTime[0]) * 3600)
                + (Integer.parseInt(arrOldTime[1]) * 60)
                + (Integer.parseInt(arrOldTime[2]));
        newTime = (Integer.parseInt(arrNewTime[0]) * 3600)
                + (Integer.parseInt(arrNewTime[1]) * 60)
                + (Integer.parseInt(arrNewTime[2]));

        if (newTime < oldTime) {
            String newSql;
            newSql = "UPDATE tblAccount "
                    + "SET BestTime = '" + inTime + "' "
                    + "WHERE AccountNumber = " + inAccNum;

            try {
                st = con.createStatement();
                st.executeUpdate(newSql);
            } catch (SQLException e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "You Have Achived New Best Time!");
        }

    }
    /*====================  Update Best Time=====================*/

}//Database Connection Class

