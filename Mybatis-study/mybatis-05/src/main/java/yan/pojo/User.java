package yan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参
@NoArgsConstructor  //无参
public class User {
    private int id;
    private String name;
    private String password;

}
