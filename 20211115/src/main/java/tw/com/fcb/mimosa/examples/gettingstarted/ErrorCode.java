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
@Table(name = "errorcode")
public class ErrorCode {
	
  @Id
  @GeneratedValue
  String code;
  @Column
  String category, translation;
  

}
