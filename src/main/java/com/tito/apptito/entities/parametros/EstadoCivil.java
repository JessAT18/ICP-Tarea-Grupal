package com.tito.apptito.entities.parametros;

import com.tito.apptito.entities.enums.Estados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity @Table(name = "patbl_ECiviles")
@Data @AllArgsConstructor @NoArgsConstructor
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ecivil_id;

    
    @NotEmpty(message = "{estadoCivil.ecivil_desc.requerido}")
    @Column(name = "ecivil_desc") 
    private String ecivil_desc;

    @Enumerated(value = EnumType.ORDINAL)
    private Estados estado_fl;
}