package com.tito.apptito.entities.ventas;

import com.tito.apptito.entities.enums.Estados;
import com.tito.apptito.entities.enums.UnidadesMedida;
import com.tito.apptito.entities.parametros.EstadoCivil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity @Table(name = "ivtbl_Productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int producto_id;

    @NotNull(message = "{producto.producto_nm.requerido}")
    @Column(name = "producto_nm")
    private String producto_nm;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "categoria_id", nullable = false)
//    @Column(name = "categoria_id")
//    private Categoria categoria;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "unidad_medida")
    private UnidadesMedida unidad_medida;

    @Column(name = "stock_actual")
    @NotEmpty(message = "{producto.stock_actual.requerido}")
    private int stock_actual;

    @Column(name = "precio_vta")
    @NotEmpty(message = "{producto.precio_vta.requerido}")
    private int precio_vta;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "estado_fl")
    private Estados estado_fl;
}
