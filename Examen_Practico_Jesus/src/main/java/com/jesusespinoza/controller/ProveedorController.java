package com.jesusespinoza.controller;

import com.jesusespinoza.dto.GenericResponse;
import com.jesusespinoza.dto.ProveedorDTO;
import com.jesusespinoza.model.Proveedor;
import com.jesusespinoza.service.IProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {
    private final IProveedorService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<ProveedorDTO>> getAllProveedores() {
        List<ProveedorDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ProveedorDTO>> getProveedorById(@PathVariable("id") int id) {
        Proveedor obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(convertToDto(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProveedorDTO dto) {
        Proveedor obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProveedor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ProveedorDTO>> update(@PathVariable("id") Integer id,@Valid @RequestBody ProveedorDTO dto){
        Proveedor obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProveedorDTO convertToDto(Proveedor obj){
        return modelMapper.map(obj, ProveedorDTO.class);
    }

    private Proveedor convertToEntity(ProveedorDTO dto){
        return modelMapper.map(dto, Proveedor.class);
    }

}
