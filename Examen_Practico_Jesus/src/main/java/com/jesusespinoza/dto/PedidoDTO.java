package com.jesusespinoza.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jesusespinoza.model.Proveedor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Integer idPedido;
    @NonNull
    @Size(min = 10, max = 50)
    private String descripcion;
    @NotNull
    private LocalDateTime fechaPedido;
    @NotNull
    private Proveedor proveedor;
    @NotNull
    private boolean estado;
}
