package group3.edunext.controllers;

import group3.edunext.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final IUserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password) {
        if (userService.getUserByLoginInfo(username, password).isPresent()) {
            return "redirect:/coursesList";
        }
        return "redirect:/";
    }


}
