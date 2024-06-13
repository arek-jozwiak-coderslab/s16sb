package pl.coderslab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

@Controller
@RequestMapping("drink")
@Slf4j
public class DrinkController {
    private final DrinkRepository drinkRepository;


    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;

    }

    @GetMapping("/list")
    public String listPaged(Model model, Pageable pageable) {
        Page<Drink> page = drinkRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "drink/list";
    }

    @GetMapping("/delete/{id}")
    public String list(Model model, @PathVariable int id, RedirectAttributes redirectAttributes) {
        log.info("id: {}", id);
        log.info("id: " + id);
        drinkRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Usunięty prawidłowo ");
        return "redirect:/drink/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("drink", new Drink());
        return "drink/add";
    }

    @PostMapping("/add")
    public String addPersonPerform(@RequestParam("file") MultipartFile file,
                                   @ModelAttribute @Valid Drink drink, BindingResult result,
                                   RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "drink/add";
        }
        redirectAttributes.addFlashAttribute("message", "Drink dodany prawidłowo ");

        drinkRepository.save(drink);
        return "redirect:/drink/list";
    }
}
