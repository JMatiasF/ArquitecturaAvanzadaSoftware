package ar.edu.unju.fi.arquitectura.tp02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity

public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;
    private Date fecha;
    private LocalTime hora;
    private double monto;
    private TipoTransaccion tipo;
    private EstadoTransaccion estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCuenta", nullable = false)
    private Cuenta cuenta;

    public Transaccion() {
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
