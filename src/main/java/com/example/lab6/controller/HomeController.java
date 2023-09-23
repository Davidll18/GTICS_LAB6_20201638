package com.example.lab6.controller;

import com.example.lab6.entity.Device;
import com.example.lab6.repository.DeviceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    final DeviceRepository deviceRepository;

    public HomeController(DeviceRepository deviceRepository){

        this.deviceRepository = deviceRepository;
    }
    @RequestMapping(value = "/")
    public String paginaPrincipal(){
        return "pagina/gticsf";
    }
    @RequestMapping("/equipos")
    public String equipos(Model model){
        List<Device> deviceList = deviceRepository.findAll();
        model.addAttribute("deviceList", deviceList);

        return "pagina/equipos";


    }

    @GetMapping("/new")
    public String nuevoEquipo() {
        return "pagina/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoEquipo(Device device) {

        deviceRepository.save(device);
        return "redirect:/pagina/newFrm";

    }
    @GetMapping("/delete")
    public String borrarEquipo(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Device> optD = deviceRepository.findById(id);

        if (optD.isPresent()) {
            deviceRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Transportista borrado exitosamente");
        }
        return "redirect:/equipos";

    }
}
