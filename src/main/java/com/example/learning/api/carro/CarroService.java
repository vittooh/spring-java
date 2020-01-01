package com.example.learning.api.carro;

import com.example.learning.api.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModelMapper modelMapper;


    public CarroDto create(Carro carro) {
        return convertToDto(carroRepository.save(carro));
    }

    public CarroDto save( CarroDto carro, Long id) throws NotFoundException {
        Carro carroInDb = convertToCarro(getById(id));
        carroInDb.setNome(carro.getNome());
        carroInDb.setTipo(CarroTipo.getEnum(carro.getTipo()));
        return convertToDto(carroRepository.save(carroInDb));
    }


    public List<CarroDto> findByTipo(String tipo) {
        return carroRepository.findByTipo(CarroTipo.getEnum(tipo))
                .stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<CarroDto> getAll() {
        return carroRepository.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CarroDto getById(Long id) throws NotFoundException {
        return convertToDto(carroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Id %d não encontrado!!", id))));
    }


    public CarroDto convertToDto(Carro carro) {
        return modelMapper.map(carro, CarroDto.class);
    }

    public Carro convertToCarro(CarroDto carroDto) {
        return modelMapper.map(carroDto, Carro.class);
    }
}
