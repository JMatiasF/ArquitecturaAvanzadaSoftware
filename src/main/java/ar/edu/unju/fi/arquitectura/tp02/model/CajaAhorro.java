package ar.edu.unju.fi.arquitectura.tp02.model;

import jakarta.persistence.Entity;

@Entity
public class CajaAhorro extends Cuenta{
    private Integer cantextraccion;
    private double tasainteres;

    public CajaAhorro() {
    }

    public Integer getCantextraccion() {
        return cantextraccion;
    }

    public void setCantextraccion(Integer cantextraccion) {
        this.cantextraccion = cantextraccion;
    }

    public double getTasainteres() {
        return tasainteres;
    }

    public void setTasainteres(double tasainteres) {
        this.tasainteres = tasainteres;
    }
}
