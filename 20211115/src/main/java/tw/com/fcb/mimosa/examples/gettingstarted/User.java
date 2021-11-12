package tw.com.fcb.mimosa.examples.gettingstarted;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
//
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  Long id;
  @Column(name = "user_name")
  String name;
  int age;

  //	public String getName() {
  //		return name;
  //	}
  //	public void setName(String name) {
  //		this.name = name;
  //	}
  //	public int getAge() {
  //		return age;
  //	}
  //	public void setAge(int age) {
  //		this.age = age;
  //	}

}
