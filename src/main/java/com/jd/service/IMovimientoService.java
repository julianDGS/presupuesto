package com.jd.service;

import com.jd.domain.Movimiento;
import java.util.List;

public interface IMovimientoService {
    
    public List<Movimiento> listarMovimientos();
    
    public void guardar(Movimiento movimiento);
    
    public void eliminar(Movimiento movimiento);
    
    public Movimiento encontrarMovimiento(Movimiento movimiento);
    
    public List<Movimiento> ingresos();
    
    public List<Movimiento> egresos();
}
