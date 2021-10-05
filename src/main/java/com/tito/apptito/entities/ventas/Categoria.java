package com.tito.apptito.entities.ventas;

import com.tito.apptito.entities.enums.Estados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Table(name = "patbl_Categorias")
@Data @AllArgsConstructor @NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoria_id;

    @NotNull(message = "{categoria.categoria_nm.requerido}")
    @Column(name = "categoria_nm")
    private String categoria_nm;

    @Enumerated(value = EnumType.ORDINAL)
    private Estados estado_fl;
}
