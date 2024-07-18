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

      userService.add(new User("Иван", "Иванов", "user1@mail.ru", new Car("BMW", 3)));
      userService.add(new User("Петр", "Петров", "user2@mail.ru", new Car("AUDI", 7)));
      userService.add(new User("Заур", "Трегулов", "user3@mail.ru", new Car("PORSHE", 911)));
      userService.add(new User("Алекс", "Алишев", "user4@mail.ru", new Car("ВАЗ", 2101)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      context.close();
   }
}
