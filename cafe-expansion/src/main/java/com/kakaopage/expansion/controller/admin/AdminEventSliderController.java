package com.kakaopage.expansion.controller.admin;

import com.kakaopage.expansion.domain.EventSlider;
import com.kakaopage.expansion.domain.Book;
import com.kakaopage.expansion.service.EventSliderService;
import com.kakaopage.expansion.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/event-slider")
public class AdminEventSliderController {

    @Autowired private EventSliderService eventSliderService;
    @Autowired private BookService bookService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("sliders", eventSliderService.findAll());
        return "admin/eventSliderList";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("slider", new EventSlider());
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/eventSliderForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute EventSlider slider) {
        eventSliderService.save(slider);
        return "redirect:/admin/event-slider";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("slider", eventSliderService.findById(id));
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/eventSliderForm";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute EventSlider slider) {
        slider.setId(id);
        eventSliderService.save(slider);
        return "redirect:/admin/event-slider";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        eventSliderService.delete(id);
        return "redirect:/admin/event-slider";
    }
}
