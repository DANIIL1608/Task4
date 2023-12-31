package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Валера", "Подорожников", "valeraLoveWishAndFaith@mail.ru",
              new Car("Cherry Semerka", 2107));
      User user2 = new User("Виталя", "Дутиков", "trombone@gmail.com",
              new Car("Raspberry LADA", 2101));
      User user3 = new User("Максим", "Огузок", "cucumber@gmail.com",
              new Car("LADA", 1111));
      User user4 = new User("Михаил", "Новиков", "bear@gmail.com",
              new Car("TOYOTA CAMRY 3.5", 35));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();

      System.out.println(userService.getUserById("Raspberry LADA", 2101)+ "\n");

      for (User user : users) {
         System.out.println(user.toString() + "\n");
      }

      context.close();
   }
}
