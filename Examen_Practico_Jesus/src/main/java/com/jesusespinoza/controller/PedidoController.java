package com.jesusespinoza.controller;

import com.jesusespinoza.dto.GenericResponse;
import com.jesusespinoza.dto.PedidoDTO;
import com.jesusespinoza.model.Pedido;
import com.jesusespinoza.service.IPedidoService;
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
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<PedidoDTO>> getPedidoById(@PathVariable("id") int id) {
        Pedido obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(convertToDto(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PedidoDTO dto) {
        Pedido obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPedido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<PedidoDTO>> update(@PathVariable("id") Integer id,@Valid @RequestBody PedidoDTO dto){
        Pedido obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PedidoDTO convertToDto(Pedido obj){
        return modelMapper.map(obj, PedidoDTO.class);
    }

    private Pedido convertToEntity(PedidoDTO dto){
        return modelMapper.map(dto, Pedido.class);
    }


}
