package Utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseUtils {
    Connection connect;
    WebDriver driver;

    public DatabaseUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    public static Connection ConnectToDatabase() throws IOException, SQLException {
        Properties propDB = new Properties();
        FileInputStream fisDB = new FileInputStream(System.getProperty("user.dir")
                + "//src///main//resources/Global.properties");
        propDB.load(fisDB);
        String DBurl = propDB.getProperty("url");
        String DBUsername = propDB.getProperty("Username");
        String DBPassword = propDB.getProperty("Password");
        Connection connect = DriverManager.getConnection(DBurl,DBUsername,DBPassword);
        return connect;
    }
    public static ArrayList ExecuteQuery(String Query) throws SQLException, IOException {
        ArrayList DBResult = new ArrayList();
        Statement stmnt = ConnectToDatabase().createStatement();
        ResultSet Data = stmnt.executeQuery(Query);
        ResultSetMetaData metaData = Data.getMetaData();
        int Columncount = metaData.getColumnCount();
        while (Data.next())
        {
            String[] row = new String[Columncount];
            for(int i=1;i<=Columncount;i++)
            {
                row[i-1] = Data.getString(i);
            }
            DBResult.add(row);
        }
       return DBResult;
    }
    public void CloseConnection() throws SQLException {
        try
        {
            if(connect!=null && !connect.isClosed())
            {
                connect.close();
                System.out.println("Connectio has been closed");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("There is some error while closing the connection");
        }
    }
}
