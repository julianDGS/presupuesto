package com.jd.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMovimiento;
    
    private String concepto;
    
    @NotNull
    private double cantidad;
    
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    
    @NotNull
    private boolean ing;
    
    @ManyToOne()
    @JoinColumn(name="id_categoria")
    private Categoria categorias;
}
