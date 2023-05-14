package org.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.GuestService;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestController {

    private final GuestService service;

    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO dto, Model model){
        log.info("=================list=========================");
        model.addAttribute("result",service.getList(dto));
    }

    @GetMapping("/register")
    public void register(){
        log.info("=================register=========================");
    }

    @PostMapping("/register")
    public String registerPost(GuestBookDTO dto, RedirectAttributes redirectAttributes){
        log.info("=================registerPost=========================");
        Long gno = service.register(dto);
        redirectAttributes.addFlashAttribute("msg",gno);
        return "redirect:/guestbook/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("=================read=========================");
        GuestBookDTO dto = service.read(gno);
        log.info("content : "+dto.getContent());
        model.addAttribute("dto",dto);
    }
    @PostMapping("/modify")
    public String modify(GuestBookDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){

        log.info("============modifyPost=================");
        service.modify(dto);
        redirectAttributes.addFlashAttribute("page",requestDTO.getPage());
        redirectAttributes.addFlashAttribute("gno",dto.getGno());

        return "redirect:/guestbook/read";
    }

    @PostMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes){
        log.info("================remove===================");
        service.remove(gno);
        redirectAttributes.addFlashAttribute("msg",gno);
        return "redirect:/guestbook/list";
    }






}