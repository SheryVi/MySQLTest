import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeStatement(Statement statement){
        try{
            if(statement!=null){
                statement.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeResultSet(ResultSet rs){
        try {
            if (rs!= null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Map<String, String>> getListOfMapFromRS(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        List<Map<String, String>> tableData = new ArrayList<>();
        Map<String, String> row = new LinkedHashMap<>();
        //with wile loop we go through the rows one by one
        ////с помощью цикла while мы проходим строки одну за другой
        while (rs.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                //with for loop we go through all the columns one by one
                //с помощью цикла for мы проходим по всем столбцам один за другим
                String nameOfColumn = resultSetMetaData.getColumnLabel(i);
                String columnValue = rs.getString(nameOfColumn);
                row.put(nameOfColumn, columnValue);
            }
            tableData.add(row);
        }

        return tableData;
    }
}
