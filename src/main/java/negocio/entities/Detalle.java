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
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByLetra", query = "SELECT d FROM Detalle d WHERE d.detallesPK.letra = :letra")
    , @NamedQuery(name = "Detalle.findByNumero", query = "SELECT d FROM Detalle d WHERE d.detallesPK.numero = :numero")
    , @NamedQuery(name = "Detalle.findByCodigo", query = "SELECT d FROM Detalle d WHERE d.detallesPK.codigo = :codigo")
    , @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePK detallesPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumns({
        @JoinColumn(name = "letra", referencedColumnName = "letra", insertable = false, updatable = false)
        , @JoinColumn(name = "numero", referencedColumnName = "numero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Factura facturas;

    public Detalle() {
    }

    public Detalle(DetallePK detallesPK) {
        this.detallesPK = detallesPK;
    }

    public Detalle(DetallePK detallesPK, int cantidad) {
        this.detallesPK = detallesPK;
        this.cantidad = cantidad;
    }

    public Detalle(Character letra, int numero, int codigo) {
        this.detallesPK = new DetallePK(letra, numero, codigo);
    }

    public DetallePK getDetallesPK() {
        return detallesPK;
    }

    public void setDetallesPK(DetallePK detallesPK) {
        this.detallesPK = detallesPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFacturas() {
        return facturas;
    }

    public void setFacturas(Factura facturas) {
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
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
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
