import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        //DBUrl Database String
        //IP - name of the server
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        //Always protected by some kind of extra security layers so that no one can access
        //that database easily
        //Всегда защищен какими-то дополнительными уровнями безопасности, чтобы никто не мог получить доступ
        //этой базе данных легко
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        Statement statement = connection.createStatement();
        String query = "select * from person;";
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.print(resultSetMetaData.getColumnLabel(i) + " ");

        }
        while (rs.next()) {
            //with wile loop we go through the rows one by one
            ////с помощью цикла while мы проходим строки одну за другой
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                //with for loop we go through all the columns one by one
                //с помощью цикла for мы проходим по всем столбцам один за другим
                String nameOfColumn = resultSetMetaData.getColumnLabel(i);
                String columnValue = rs.getString(nameOfColumn);
                System.out.print(columnValue+" ");
            }
            System.out.println();

        }
    }
}
