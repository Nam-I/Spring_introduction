package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
