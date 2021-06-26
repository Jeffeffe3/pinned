package com.rochelle.pinned;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {


    @SuppressLint("NewApi")
    public static Connection CONN() {

        String _user = "user1";
        String _pass = "password1";
        String _DB = "Pinned";
        String _server = "192.168.0.104";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://" + _server + ";"
                    + "databaseName=" + _DB + ";user=" + _user + ";password="
                    + _pass + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERROR_SQL", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR_CLASS", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR_EXCEPTION", e.getMessage());
        }
        return conn;
    }
}