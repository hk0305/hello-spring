package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 컴포넌트 스캔
@Controller
public class MemberController {

     private final MemberService memberService;

     @Autowired
     public MemberController(MemberService memberService) {
          this.memberService = memberService;
     }

}