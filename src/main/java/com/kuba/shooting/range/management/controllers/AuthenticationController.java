package com.kuba.shooting.range.management.controllers;

import com.kuba.shooting.range.management.controllers.utils.ModelUtils;
import com.kuba.shooting.range.management.services.AuthenticationService;
import com.kuba.shooting.range.management.services.UserService;
import com.kuba.shooting.range.management.session.SessionData;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.catalina.valves.rewrite.Substitution;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class AuthenticationController {

    private SessionData sessionData;
    private AuthenticationService authenticationService;

    @GetMapping(path = "/login")
    public String login(Model model) {
        ModelUtils.addCommonDataToModel(model, sessionData);
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        this.authenticationService.authenticate(login, password);
        if (this.sessionData.isLogged()) {
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        this.authenticationService.logout(request);
        return "redirect:/";
    }


}
