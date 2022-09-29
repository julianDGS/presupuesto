package com.jd.web;

import com.jd.domain.Movimiento;
import com.jd.service.IMovimientoService;
import static java.lang.Double.isNaN;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private IMovimientoService movimientoServ;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var ingresos = movimientoServ.ingresos();
        var egresos = movimientoServ.egresos();
        var mov = new Movimiento();
        mov.setIng(true);
        log.info("Usuario que hizo LOGIN: " + user);
        var saldoIngreso = 0D;
        var saldoEgreso = 0D;
        for (var movimiento : movimientoServ.listarMovimientos()) {
            if(movimiento.isIng()){
                saldoIngreso += movimiento.getCantidad();
            } else {
                saldoEgreso += movimiento.getCantidad();
            }
        }
        var saldoTotal = saldoIngreso - saldoEgreso;
        var porcentaje = isNaN(saldoEgreso/saldoTotal) ? 0D : saldoEgreso/(saldoIngreso + saldoEgreso);
        var nf = java.text.NumberFormat.getPercentInstance();
        //nf.setMinimumFractionDigits(2);
        model.addAttribute("ingreso", ingresos);
        model.addAttribute("egreso", egresos);
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("porcentaje", porcentaje);
        model.addAttribute("nf", nf);
        model.addAttribute("saldoIngreso", saldoIngreso);
        model.addAttribute("saldoEgreso", saldoEgreso);
        model.addAttribute("movimiento", mov);
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Movimiento movimiento, BindingResult errores) { //La validacion del tipo de variable y errors deben estar juntos
        if (errores.hasErrors()) {
            return "redirect:/";
        }
        movimientoServ.guardar(movimiento);
        return "redirect:/";
    }

//    @GetMapping("/editar/{idMovimiento}")
//    public String editar(Movimiento movimiento, Model model) {
//        movimiento = movimientoServ.encontrarMovimiento(movimiento);
//        model.addAttribute("movimiento", movimiento);
//        return "modificar"; //Por cómo se construyo modificar.html si encuentra un objeto de tipo movimiento ya existente pone los datos, si no, lo crea
//    }

    @GetMapping("/eliminar")
    public String eliminar(Movimiento movimiento) {
        movimientoServ.eliminar(movimiento);
        return "redirect:/";
    }
}
