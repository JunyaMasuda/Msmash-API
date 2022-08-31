package hinatazaka46.smash.Controller;

import hinatazaka46.smash.Domain.User;
import hinatazaka46.smash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController
@RequiredArgsConstructor
public class HelloWorld {

    private final UserService userService;

    @GetMapping(value = "/hello")
    public String hello(){
        User user = new User();
        user.setUserName("aa");
        user.setPassword("bb");
        user.setImage("cc");
        this.userService.add(user);
        return "Hello hinatazaka";
    }
}
