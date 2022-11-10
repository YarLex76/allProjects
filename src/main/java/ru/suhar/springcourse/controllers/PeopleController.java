package ru.suhar.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.suhar.springcourse.dao.PersonDAO;
import ru.suhar.springcourse.model.Person;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping() // в методе получим всех людей из DAO и передадим на отображение в представление
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}") // получим одного человека по id из DAO и передадим его в отображение
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }
    @GetMapping("/new") // метод создания нового человека
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new"; // возвращаем название таймлив шаблона, где будет лежать форма для создания человека
    }

    @PostMapping
    public String create(@ModelAttribute ("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }
}
