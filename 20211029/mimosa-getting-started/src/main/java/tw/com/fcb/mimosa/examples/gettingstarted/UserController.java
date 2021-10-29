package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  static List<User> users = new ArrayList<User>();

  @Autowired
  UserDtoMapper mapper;

  @GetMapping
  List<UserDto> getUsers() {
    //		User user = new User();
    //		user.setName("CJ");
    //		user.setAge(25);
    //		return user;
    //		return User.builder()
    //			   .age(25)
    //			   .name("CJ")
    //			   .build();

    List<UserDto> dtos = new ArrayList<>();
    for (User user : users) {
      //			UserDto dto = UserDto.builder()
      //					.name(user.getName()) // BeanUtils.copyProperties();
      //					.build();
      UserDto dto = mapper.from(user);
      dtos.add(dto);
      UserDto.builder();
    }

    //		List<UserDto> java8dto = users.stream()
    //		.map(user -> UserDto.builder().name(user.getName()).build())
    //		.collect(Collectors.toList());

    return dtos;
  }

  @PostMapping
  void createUser(@RequestBody User user) {
    int i = 0;
    var keyexist = 'N';
    for (User usr : users) {
      if (usr.getName().equals(user.getName())) {
        System.out.println("key exist!");
        keyexist = 'Y';
        break;
      }
      i++;
    }
    if (keyexist == 'N') {
      users.add(user);
    }
  }

  // repository 2021-10-26 -> public

  // modify user
  // @PutMapping
  @PutMapping
  void modifyUser(@RequestBody User user) {
    int i = 0;
    for (User usr : users) {
      if (usr.getName().equals(user.getName())) {
        User modifyuser = User.builder().name(user.getName()).age(user.getAge()).build();
        users.set(i, modifyuser);
      }
      i++;
    }
  }

  // delete user
  // @DeleteMapping
  @DeleteMapping
  void deleteUser(@RequestBody User user) {
    users.remove(user);
  }
}
