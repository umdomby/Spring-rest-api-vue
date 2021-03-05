package letscode.sarafan.controller;

import letscode.sarafan.domain.User;
import letscode.sarafan.repo.ContactRepo;
import letscode.sarafan.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final MessageRepo messageRepo;
    private final ContactRepo contactRepo;

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    public MainController(MessageRepo messageRepo, ContactRepo contactRepo) {
        this.messageRepo = messageRepo;
        this.contactRepo = contactRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("messages", messageRepo.findAll());
        data.put("contacts", contactRepo.findAll());

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
