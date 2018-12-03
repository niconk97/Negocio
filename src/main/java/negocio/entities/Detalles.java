package negocio.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "detalles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalles.findAll", query = "SELECT d FROM Detalles d")
    , @NamedQuery(name = "Detalles.findByLetra", query = "SELECT d FROM Detalles d WHERE d.detallesPK.letra = :letra")
    , @NamedQuery(name = "Detalles.findByNumero", query = "SELECT d FROM Detalles d WHERE d.detallesPK.numero = :numero")
    , @NamedQuery(name = "Detalles.findByCodigo", query = "SELECT d FROM Detalles d WHERE d.detallesPK.codigo = :codigo")
    , @NamedQuery(name = "Detalles.findByCantidad", query = "SELECT d FROM Detalles d WHERE d.cantidad = :cantidad")})
public class Detalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallesPK detallesPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumns({
        @JoinColumn(name = "letra", referencedColumnName = "letra", insertable = false, updatable = false)
        , @JoinColumn(name = "numero", referencedColumnName = "numero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Facturas facturas;

    public Detalles() {
    }

    public Detalles(DetallesPK detallesPK) {
        this.detallesPK = detallesPK;
    }

    public Detalles(DetallesPK detallesPK, int cantidad) {
        this.detallesPK = detallesPK;
        this.cantidad = cantidad;
    }

    public Detalles(Character letra, int numero, int codigo) {
        this.detallesPK = new DetallesPK(letra, numero, codigo);
    }

    public DetallesPK getDetallesPK() {
        return detallesPK;
    }

    public void setDetallesPK(DetallesPK detallesPK) {
        this.detallesPK = detallesPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesPK != null ? detallesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalles)) {
            return false;
        }
        Detalles other = (Detalles) object;
        if ((this.detallesPK == null && other.detallesPK != null) || (this.detallesPK != null && !this.detallesPK.equals(other.detallesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entities.Detalles[ detallesPK=" + detallesPK + " ]";
    }
    
}
