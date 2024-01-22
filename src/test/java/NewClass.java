import org.h2.security.auth.Authenticator;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class NewClass {
   @Test
    public void MyTest() throws SQLException
    {

        int foodId;
        String foodName = null;
        String foodType = null;
        boolean foodExotic = true;

        Connection connection
        = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/mem:testdb", "user", "pass");

        Statement statement = connection.createStatement();


        String testData = "use PUBLIC;\n" +
                "\n" +
                "insert into FOOD values (NULL,'Мандаринка', 'FRUIT', 1);";


        statement.executeUpdate(testData);
        ResultSet resultSet = statement.executeQuery("Select FOOD_ID, FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC from FOOD");

        while (resultSet.next()){
            foodId = resultSet.getInt("FOOD_ID");
            foodName = resultSet.getString("FOOD_NAME");
            foodType = resultSet.getString("FOOD_TYPE");
            foodExotic = resultSet.getBoolean("FOOD_EXOTIC");

            System.out.printf("%d, %s, %s, %b%n",foodId, foodName, foodType, foodExotic);}
        if (foodName.equals("Мандаринка"))
            if (foodType.equals("FRUIT"))
                if (foodExotic){
                    //проверка прошла успешно
                    statement.executeUpdate("delete from food\n" +
                            "\n" +
                            "where food_name = 'Мандаринка';");
                }else Assert.fail();






    }
}
