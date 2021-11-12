package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.http.APIRequest;
import tw.com.fcb.mimosa.http.APIResponse;
import tw.com.fcb.mimosa.tracing.Traced;

@Traced
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  static List<User> users = new ArrayList<User>();

  final UserDtoMapper mapper;
  final UserService service;
  final ErrorService errservice;

  @PostMapping("/names")
  APIResponse<User> getByName(@RequestBody APIRequest<String> name) {
	  return APIResponse.success(service.getByName(name.getBody()));
  }

  @GetMapping
  APIResponse<List<UserDto>> getUsers() {
	  
	  return APIResponse.success(service.getUsers().stream()
			  .map(mapper::from)
			  .collect(Collectors.toList()));
  }
  

  @PostMapping
  APIResponse<Long> createUser(@Validated @RequestBody APIRequest<CreateUserDto> user) {
	  return APIResponse.success(service.createUser(user.getBody()))
			  .map(User::getId);
  }

  // repository 2021-10-26 -> public

  // modify user
  // @PutMapping
  @PutMapping("/{id}")
  void replaceUser(@Min(0) @PathVariable("id") Long id,@Validated @RequestBody ReplaceUserDto user) {
    service.replaceUser(id, user);
  }

  // delete user
  // @DeleteMapping
  // delete user => DELETE /users/5
  @DeleteMapping("/{id}")
  void deleteUser(@PathVariable("id") Long id) {
    service.delete(id);
  }
}
