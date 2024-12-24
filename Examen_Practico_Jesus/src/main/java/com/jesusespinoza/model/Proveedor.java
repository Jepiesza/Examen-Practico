package com.jesusespinoza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(nullable = false, length = 100)
    private String razonSocial;

    @Column(nullable = false, length = 12)
    private String ruc;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false)
    private boolean estado;
}
