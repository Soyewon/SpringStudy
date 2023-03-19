package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // "hello!!"로 직접받기
        return "hello";
    }

    @GetMapping("hello-mvc") // command+p : required 볼 수 있음
    public String helloMVC(@RequestParam("name") String name, Model model) { // Requestparam으로 받기
        model.addAttribute("name", name);
        // localhost:8080/hello-mvc?name=spring!!!! 일 때, spring!!!!이 name에 담기고, model로 넘어감
        //* html에서 ${name} => $표시 : model에서 꺼내는 것. model의 key값에서 name인것 꺼내서 가져옴
        return "hello-template"; // templates >> hello-template로 이동
    }

    @GetMapping("hello-string")
    @ResponseBody // http method body 부분에 데이터 직접 넣겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody

    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); // name 넘겨주기
        return hello;
    }

    static class Hello{
        private String name;

        // 꺼낼때
        public String getName(){
            return name;
        }

        // 넣을때
        public void setName(String name) {
            this.name = name;
        }
    }
}

