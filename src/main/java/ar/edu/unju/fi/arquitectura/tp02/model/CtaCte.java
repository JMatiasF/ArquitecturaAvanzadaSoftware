package ar.edu.unju.fi.arquitectura.tp02.model;

import jakarta.persistence.Entity;

@Entity
public class CtaCte extends Cuenta{
    private double margen;
    private double comision;

    public CtaCte() {
    }

    public double getMargen() {
        return margen;
    }

    public void setMargen(double margen) {
        this.margen = margen;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
