package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //필드 주입 방식(별로 안좋음)
//    @Autowired private MemberService memberService;

    //setter 주입 방식
//    private MemberService memberService;
//
//    @Autowired //set이 public 이어야 하므로 보안상 안좋을 수 있음.
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    //생성자 주입 방식 (가장 권장하는 방식)
    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

//        System.out.println("member = " + member.getName()); //회원 출력해보기

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
