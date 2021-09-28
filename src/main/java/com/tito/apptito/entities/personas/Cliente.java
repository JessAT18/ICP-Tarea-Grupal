package com.tito.apptito.entities.personas;


import com.tito.apptito.entities.enums.Estados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity @Table(name = "petbl_Clientes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotNull(message = "El nombre del cliente no debe ser nulo") //Opcion 1
    @NotEmpty(message = "{cliente.cliente_nm.requerido}") //Opcion 2

    @Column(name = "cliente_nm") //Nombre del atributo tal cual está en la Tabla de la BD
    private String cliente_nm;

    @NotNull(message = "{cliente.cliente_app.requerido}")
    private String cliente_app;

    @NotNull(message = "{cliente.cliente_apm.requerido}")
    private String cliente_apm;

    private String direccion_desc;

    /*@Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/
    private Date fch_nacimiento;

    private String telefono_desc;

    @Enumerated(value = EnumType.ORDINAL)
    private Estados estado_fl;
}
