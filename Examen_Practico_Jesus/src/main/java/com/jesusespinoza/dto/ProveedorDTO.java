package com.jesusespinoza.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProveedorDTO {
    private Integer idProveedor;
    @NonNull
    @Size(min = 10, max = 100)
    private String razonSocial;
    @NonNull
    @Size(min = 12, max = 12)
    private String ruc;
    @NonNull
    @Size(min = 7, max = 9)
    private String telefono;
    @NonNull
    private boolean estado;
}
