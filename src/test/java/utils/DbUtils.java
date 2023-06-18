package utils;

import java.sql.*;
import java.util.*;

public class DbUtils {

  public static Connection getConnection(){
      Connection connection=null;

      try {
          connection= DriverManager.getConnection(ConfigReader.getPropertyValue("dbUrl"),
                  ConfigReader.getPropertyValue("dbUserName"),
                  ConfigReader.getPropertyValue("dbPassword"));

      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    return connection;
  }

  public static ResultSet getResultSet( String query){
      ResultSet resultSet=null;

      try {
          resultSet=getConnection().createStatement().executeQuery(query);
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
   return resultSet;
  }

  public static List<Map<String, String>> getTableDataAsListOfMaps(String query){
      ResultSet resultSet=getResultSet(query);
      ResultSetMetaData resultSetMetaData;
      List<Map<String, String>>  tableData= new ArrayList<>();
      Map<String, String> row;

      try {
          resultSetMetaData=resultSet.getMetaData();
          while (resultSet.next()){
              row=new HashMap<>();
              for (int i=1; i<=resultSetMetaData.getColumnCount(); i++){
                  row.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
              }
             tableData.add(row);
          }

      } catch (SQLException e) {
          throw new RuntimeException(e);
      }finally {
          try {
              resultSet.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      return tableData;
  }

}
