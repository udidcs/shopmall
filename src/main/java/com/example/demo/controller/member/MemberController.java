package com.example.demo.controller.member;

import com.example.demo.dto.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRepository repository;
    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/memberForm")
    public String memberForm() {
        return "memberForm";
    }

    @GetMapping("/editForm")
    public String editForm() {
        return "editForm";
    }
    @GetMapping("/logout")
    public String logoutMember(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session != null)
            session.invalidate();
        return "redirect:/home";
    }
    @GetMapping("/manager")
    public String manager(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session == null)
            return "redirect:/home";
        session.setAttribute("manager", "True");
        return "redirect:/editForm";
    }

    @GetMapping("/managerout")
    public String managerout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session == null)
            return "redirect:/home";
        session.removeAttribute("manager");
        return "redirect:/editForm";
    }

    @Transactional
    @PostMapping("/memberForm")
    public String addMember(@ModelAttribute Member mem, HttpServletRequest req) {

        repository.save(mem);
        System.out.println("회원 가입 완료");
        HttpSession session = req.getSession(true);
        session.setAttribute("logged", "True");
        return "redirect:/home";
    }

    @PostMapping("/loginForm")
    public String loginMember(HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        session.setAttribute("logged", "True");
        return "redirect:/home";
    }





}
