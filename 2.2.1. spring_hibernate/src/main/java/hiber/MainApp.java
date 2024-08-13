package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      CarService carService = context.getBean(CarService.class);

      carService.add(new Car("Car1", 1));
      carService.add(new Car("Car2", 2));
      carService.add(new Car("Car3", 3));
      carService.add(new Car("Car4", 4));

      User user0 = userService.listUsers().get(0);
      Car car0 = carService.listCar().get(0);
      user0.setCar(car0);
      userService.update(user0);

      User user1 = userService.listUsers().get(1);
      Car car1 = carService.listCar().get(1);
      user1.setCar(car1);
      userService.update(user1);


      User user2 = userService.listUsers().get(2);
      Car car2 = carService.listCar().get(2);
      user2.setCar(car2);
      userService.update(user2);

      User user3 = userService.listUsers().get(3);
      Car car3 = carService.listCar().get(3);
      user3.setCar(car3);
      userService.update(user3);

      User user4 = userService.getUserByCar("Car1", 1);
      System.out.println("Найденный владелец автомобиля - " + user4.toString());

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }
   }
}
