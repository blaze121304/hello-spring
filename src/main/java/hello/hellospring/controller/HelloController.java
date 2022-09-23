package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //static contents
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!"); //
        return "hello2";    // templates/hello2.html 호출
    }

    //template engine
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-test")
    public String helloTest(@RequestParam(name = "name_src", required = false) String name, //hello-test 페이지의 name_src파라미터에 name을 담음 - String name 변수
                            @RequestParam(name = "age_src", required = false) String age,
                            Model model){
        model.addAttribute("name_temp", name);   //hello-hey.html의 name_temp안에 담김 - String name 변수
        model.addAttribute("age_temp", age);    //hello-hey.html의 age_temp안에 담김 - String age 변수
        return "hello-hey";
    }

    //Api call
    @GetMapping("hello-string")
    @ResponseBody   //응답 body에 내용을 직접 넣겠다
    public String helloString(@RequestParam("name") String name){
        return "halo" + name;
    }

    //Api - json call
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
