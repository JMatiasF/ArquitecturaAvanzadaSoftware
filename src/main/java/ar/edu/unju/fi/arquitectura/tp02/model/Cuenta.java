package ar.edu.unju.fi.arquitectura.tp02.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    private Integer cbu;
    private String alias;
    private double saldo;
    private EstadoCuenta estado;

    @OneToMany(
            mappedBy = "cuenta",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Transaccion> transacciones = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_cuenta",
            joinColumns = @JoinColumn(name = "idCuenta"),
            inverseJoinColumns = @JoinColumn(name = "idCliente")
    )
    private Set<Cliente> titulares = new HashSet<>();

    public Cuenta() {
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getCbu() {
        return cbu;
    }

    public void setCbu(Integer cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Set<Cliente> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<Cliente> titulares) {
        this.titulares = titulares;
    }
}

