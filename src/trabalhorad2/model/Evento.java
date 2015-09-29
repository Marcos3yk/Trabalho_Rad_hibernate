/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author USER
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    

})
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codEvento;
    @Column
    private String nomeEvento;

    public Integer getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(Integer codEvento) {
        this.codEvento = codEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
    @Override
    public String toString(){
        return this.getNomeEvento();
    }
    
}
