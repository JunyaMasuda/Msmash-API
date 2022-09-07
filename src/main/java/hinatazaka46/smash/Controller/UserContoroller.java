package hinatazaka46.smash.Controller;


import hinatazaka46.smash.Domain.User;
import hinatazaka46.smash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services/v1/user")
@RequiredArgsConstructor
public class UserContoroller {


    private final UserService userService;

    @PostMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody User user){
        this.userService.add(user);
    }
}
