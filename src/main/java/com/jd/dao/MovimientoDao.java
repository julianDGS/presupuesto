package com.jd.dao;

import com.jd.domain.Movimiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovimientoDao extends JpaRepository<Movimiento, Long> {

    @Query("SELECT m FROM Movimiento m WHERE m.ing = 0")
    public List<Movimiento> listarEgresos();

    @Query("SELECT m FROM Movimiento m WHERE m.ing = 1")
    public List<Movimiento> listarIngresos();
}
