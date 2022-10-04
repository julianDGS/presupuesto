package com.jd.service;

import com.jd.domain.Categoria;
import java.util.List;

public interface ICategoriaService {
    
    public void guardar(Categoria categoria);
    
    public List<Categoria> listar();
    
    public void eliminar(Categoria categoria);
    
    public Categoria encontrar(Categoria categoria);
    
}
