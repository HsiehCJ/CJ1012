package tw.com.fcb.mimosa.examples.gettingstarted;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplaceUserDto {

  @NotBlank
  String userName;

}
