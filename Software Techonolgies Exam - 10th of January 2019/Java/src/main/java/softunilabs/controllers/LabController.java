package softunilabs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import softunilabs.bindingModels.LabBindingModel;
import softunilabs.entities.Lab;
import softunilabs.repositories.LabRepository;

import java.util.List;

@Controller
public class LabController {
    private final LabRepository labRepository;

    @Autowired
    public LabController(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Lab> labs = this.labRepository.findAll();
        model.addAttribute("labs",labs);
        model.addAttribute("view","lab/index");

        return "base-layout";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("view","lab/create");
        return "base-layout";
    }

    @PostMapping("/create")
    public String create(LabBindingModel bindingModel) {
        Lab lab = new Lab();
        lab.setName(bindingModel.getName());
        lab.setCapacity(bindingModel.getCapacity());
        lab.setStatus(bindingModel.getStatus());
        labRepository.saveAndFlush(lab);

        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,
                       @PathVariable(value = "id") Integer id) {
        Lab lab = labRepository.findOne(id);
        model.addAttribute("lab",lab);
        model.addAttribute("view","lab/edit");
        return "base-layout";
    }

    @PostMapping("/edit/{id}")
    public String edit(LabBindingModel bindingModel,
                       @PathVariable(value = "id") Integer id) {
        Lab lab = labRepository.findOne(id);
        lab.setName(bindingModel.getName());
        lab.setCapacity(bindingModel.getCapacity());
        lab.setStatus(bindingModel.getStatus());
        labRepository.saveAndFlush(lab);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable(value = "id") Integer id) {
        Lab lab = labRepository.findOne(id);
        model.addAttribute("lab",lab);
        model.addAttribute("view","lab/delete");
        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        Lab lab =labRepository.findOne(id);
        labRepository.delete(lab);
        return "redirect:/";
    }
}
