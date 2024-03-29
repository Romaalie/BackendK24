package modelandview.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelandview.domain.Friend;
import modelandview.domain.Student;

@Controller
public class ModelandviewController {

    List<Friend> friends = new ArrayList<>();
    List<Friend> friendsC = new ArrayList<>();

    @RequestMapping("/hello")
    public String showHelloPage() {
        return "hello";
    }

    @RequestMapping("/agetest")
    public String showGreetingTest(@RequestParam String name, String age, Model modelName, Model modelAge) {
        modelName.addAttribute("name", name);
        modelAge.addAttribute("age", age);

        return "agetest";
    }

    @GetMapping("/studentlist")
    public String showStudentlist(Model modelStudent) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ali", "Romar"));
        students.add(new Student("Markku", "Mäkipelto"));
        students.add(new Student("Jaakko", "Seppälä"));

        modelStudent.addAttribute("students", students);

        return "studentlist";
    }

    //@RequestMapping
    @GetMapping("/friendlist")
    public String showFriendList(Model modelFriend) {
        //List<Friend> friends = new ArrayList<>();
        //friends.add(new Friend("Marco", "Polo"));
        //friends.add(new Friend("George", "Harrison"));
        //friends.add(new Friend("Aleksis", "Kivi"));
        System.out.println("Listan tuloste: " + friends);

        modelFriend.addAttribute("friends", friends);
        return "friendlist";
    }

    @GetMapping("/addFriend")
    public String showAddFriend(Model modelFriend) {
        modelFriend.addAttribute("friend", new Friend());
        return "addFriend";
    }

    
    @PostMapping("addFriend")
    public String addFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        System.out.println("Uusi ystävä: " + friend);

        return "redirect:/friendlist";
    }

    @GetMapping("/friendCombined")
    public String showfriendCombined(Model modelFriendC) {
        modelFriendC.addAttribute("friend", new Friend());
        //List<Friend> friendsC = new ArrayList<>();
        //friendsC.add(new Friend("Jukka", "Jekku"));
        //friendsC.add(new Friend("Matti", "Matikainen"));
        //friendsC.add(new Friend("Harald", "Gunnarsson"));
        System.out.println("Listan tuloste: " + friendsC);

        modelFriendC.addAttribute("friendsC", friendsC);

        return "friendCombined";
    }

    @PostMapping("friendCombined")
    public String addFriendCombined(Friend friend) {
        friendsC.add(friend);
        System.out.println("Uusi ystävä: " + friend);
        return "redirect:/friendCombined";
    }

}
