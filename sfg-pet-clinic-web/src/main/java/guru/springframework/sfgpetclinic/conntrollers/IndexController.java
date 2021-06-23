package guru.springframework.sfgpetclinic.conntrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/oups", "/oups.html"})
    public String oups() {
        return "notimplemented";
    }

}
