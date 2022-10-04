import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {
        //DBUrl Database String
        //IP - name of the server
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        //Always protected by some kind of extra security layers so that no one can access
        //that database easily
        //Всегда защищен какими-то дополнительными уровнями безопасности, чтобы никто не мог получить доступ
        //этой базе данных легко
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            String query = "select * from person;";
            rs = statement.executeQuery(query);


            List<Map<String, String>> tableData = new ArrayList<>();

                tableData = DBUtils.getListOfMapFromRS(rs);


            System.out.println(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connection);
            DBUtils.closeStatement(statement);
            DBUtils.closeResultSet(rs);

        }
    }


}
