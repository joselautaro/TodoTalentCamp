package com.example.todolist.controller;

import com.example.*;
import com.example.todolist.service.TareaService;

import org.springframework.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {
    private final TareaService tareaService;

    public TodoController(TareaService tareaService){
        this.tareaService = tareaService;
    }

    @GetMapping("/")
    public String mostrarTareas(Model model, @ModelAttribute("message") String message){
        model.addAttribute("tareas", tareaService.obtenerTareas());
        model.addAttribute("message", message);
        return "todo";
    }
}
