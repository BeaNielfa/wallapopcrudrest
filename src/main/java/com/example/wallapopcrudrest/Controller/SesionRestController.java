package com.example.wallapopcrudrest.Controller;


import com.example.wallapopcrudrest.DAO.SesionDao;
import com.example.wallapopcrudrest.Models.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class SesionRestController {


    @Autowired
    private SesionDao sesionDao;


    /**
     * METODO QUE INSERTA UNA NUEVA SESION
     * @param sesion
     * @return
     */
    @RequestMapping(value="sesiones/nueva", method = RequestMethod.POST)
    public ResponseEntity<Sesion> insertarSesion(@RequestBody Sesion sesion){
        Sesion s = sesionDao.save(sesion);
        return ResponseEntity.ok(s);
    }

    /**
     * METODO QUE ELIMINA UNA SESION
     * @param id
     * @return
     */
    @RequestMapping(value="sesiones/cerrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Sesion> borrarSesion(@PathVariable("id") Integer id){
        //Buscamos por id primero
        Optional<Sesion> op = sesionDao.findById(id);
        if(op.isPresent()){
            Sesion s = op.get();
            sesionDao.deleteById(id);
            return ResponseEntity.ok(s);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
