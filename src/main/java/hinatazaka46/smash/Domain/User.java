package hinatazaka46.smash.Domain;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class User {

    private int id;

    private String userName;

    private String password;

    private String image;
}
