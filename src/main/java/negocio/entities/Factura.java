package negocio.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByLetra", query = "SELECT f FROM Facturas f WHERE f.facturasPK.letra = :letra")
    , @NamedQuery(name = "Facturas.findByNumero", query = "SELECT f FROM Facturas f WHERE f.facturasPK.numero = :numero")
    , @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Facturas.findByMonto", query = "SELECT f FROM Facturas f WHERE f.monto = :monto")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPK facturasPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente codigocliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas")
    private Collection<Detalle> detallesCollection;

    public Factura() {
    }

    public Factura(FacturaPK facturasPK) {
        this.facturasPK = facturasPK;
    }

    public Factura(Character letra, int numero) {
        this.facturasPK = new FacturaPK(letra, numero);
    }

    public FacturaPK getFacturasPK() {
        return facturasPK;
    }

    public void setFacturasPK(FacturaPK facturasPK) {
        this.facturasPK = facturasPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Cliente getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(Cliente codigocliente) {
        this.codigocliente = codigocliente;
    }

    @XmlTransient
    public Collection<Detalle> getDetallesCollection() {
        return detallesCollection;
    }

    public void setDetallesCollection(Collection<Detalle> detallesCollection) {
        this.detallesCollection = detallesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturasPK != null ? facturasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturasPK == null && other.facturasPK != null) || (this.facturasPK != null && !this.facturasPK.equals(other.facturasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entities.Facturas[ facturasPK=" + facturasPK + " ]";
    }
    
}
