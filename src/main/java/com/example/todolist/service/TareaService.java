package com.example.todolist.service;

import  java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.todolist.model.Tarea;


@Service
public class TareaService {
    

    //simulacion a la base de datos en memoria
    private Map<String, Tarea> tareas = new HashMap<>();

    //Devuelve todas las tareas
    public Map<String, Tarea> obtenerTareas(){
        return tareas;
    }

    //Guardar una nueva tarea
    public void guardarTarea(Tarea tarea){
        tareas.put(tarea.getTitulo(), tarea);
    }

    //Eliminar una tarea por su titulo
    public void eliminarTarea(String titulo){
        tareas.remove(titulo);
    }

    //buscar una tarea por su titulo
    public Tarea obtenerTareaPorTitulo(String titulo){
        return tareas.get(titulo);
    }

    //Actualizar una tarea
    public void actualizarTarea(String tituloOriginal, Tarea tareaActualizada){
        if(!tituloOriginal.equals(tareaActualizada.getTitulo())){
            tareas.remove(tituloOriginal);
        }
        tareas.put(tareaActualizada.getTitulo(), tareaActualizada);
    }

    //Marcar o desmarcar una tarea como actualizada
    public void cambiarEstadoTarea(String titulo){
        Tarea tarea = tareas.get(titulo);
        if(tarea != null){
            tarea.setCompletada(!tarea.isCompletada());
        }
    }

}
