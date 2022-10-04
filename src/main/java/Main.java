import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //connection string usually provided by DBA
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        //jdbc java api that contains all the interface and classes
        //mysql This is the name of the database that we will be working with
        //3.237.189.167 Ip of the server where we have the database
        //3306 port on witch the database is active
        //syntaxhrm_mysql name of the database or schema

        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        // Username and passwords will be used to track and give different access levels
        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement =connection.createStatement();
        //Statement is responsible for taking your queries executing on database and bringing the result back
        //Оператор отвечает за выполнение ваших запросов в базе данных и возврат результата
        String query = "select * from employee";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
          String empid = resultSet.getString("empid");
          String salary = resultSet.getString("salary");
          String grade = resultSet.getString("grade");
          String department = resultSet.getString("department");
            System.out.println(empid+" "+salary+" "+grade+ " "+department);


        }


    }
}
