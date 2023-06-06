package org.example.controllers;

import org.example.dao.GroupDAO;
import org.example.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
public class GroupsController {
    private GroupDAO groupDAO;

    @Autowired
    public GroupsController(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("groups", groupDAO.index());
        return "/groups/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupDAO.show(id));
        return "/groups/show";
    }

    @GetMapping("/new")
    public String newGroup(@ModelAttribute("group") Group group) {
        return "groups/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("group") Group group) {
        groupDAO.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupDAO.show(id));
        return "groups/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("group") Group group) {
        groupDAO.update(id, group);
        return "redirect:/groups";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        groupDAO.delete(id);
        return "redirect:/groups";
    }
}
