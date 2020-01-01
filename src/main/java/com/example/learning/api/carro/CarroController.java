package com.example.learning.api.carro;

import com.example.learning.api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;


    @PostMapping
    public CarroDto create(@RequestBody CarroDto carroDto) {
        return carroService.create(new Carro(null, CarroTipo.getEnum(carroDto.tipo), carroDto.nome));
    }


    @PutMapping("/{id}")
    public CarroDto update(@RequestBody CarroDto carroDto, @PathVariable Long id) throws NotFoundException {
        return carroService.save(carroDto, id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<CarroDto> getByTipo(@PathVariable String tipo) {
        return carroService.findByTipo(tipo);
    }

    @GetMapping
    public List<CarroDto> get() {
        return carroService.getAll();
    }

    @GetMapping("id/{id}")
    public CarroDto get(@PathVariable Long id) throws NotFoundException {
        return carroService.getById(id);
    }


}
