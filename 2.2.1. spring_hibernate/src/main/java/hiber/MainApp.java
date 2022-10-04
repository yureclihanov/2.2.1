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

      User sveta = new User("Sveta", "Lihanova", "user1@mail.ru");
      User yura = new User("Yura", "Lihanov", "user2@mail.ru");
      User mira = new User("Mira", "Lihanova", "user3@mail.ru");

      Car lada = new Car("Lada", 2109);
      Car mers = new Car("Mersedes", 2);
      Car volvo = new Car("Volvo", 219);

      userService.add(sveta.setCar(lada).setUser(sveta));
      userService.add(yura.setCar(mers).setUser(yura));
      userService.add(mira.setCar(volvo).setUser(mira));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }


 //     userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
 //     userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
 //     userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
 //     userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

 //     List<User> users = userService.listUsers();
 //     for (User user : users) {
 //        System.out.println("Id = "+user.getId());
 //        System.out.println("First Name = "+user.getFirstName());
 //        System.out.println("Last Name = "+user.getLastName());
 //        System.out.println("Email = "+user.getEmail());
 //        System.out.println();
 //     }

      context.close();
   }
}
