package negocio.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodigo", query = "SELECT c FROM Cliente c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findLikeNombre", query = "SELECT c FROM Cliente c WHERE c.nombre like :nombre")
    , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cliente.findLikeApellido", query = "SELECT c FROM Cliente c WHERE c.apellido like :apellido")
    , @NamedQuery(name = "Cliente.findLikeApellidoNombre", query = "SELECT c FROM Cliente c WHERE c.apellido like :apellido and c.nombre like :nombre")
    , @NamedQuery(name = "Cliente.findByCuit", query = "SELECT c FROM Cliente c WHERE c.cuit = :cuit")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cliente.findByComentarios", query = "SELECT c FROM Cliente c WHERE c.comentarios = :comentarios")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "comentarios")
    private String comentarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigocliente")
    private Collection<Factura> facturasCollection;

    public Cliente() {
    }

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente(Integer codigo, String nombre, String apellido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String nombre, String apellido, String cuit, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuit = cuit;
        this.direccion = direccion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public Collection<Factura> getFacturasCollection() {
        return facturasCollection;
    }

    public void setFacturasCollection(Collection<Factura> facturasCollection) {
        this.facturasCollection = facturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cuit=" + cuit + ", direccion=" + direccion + '}';
    }

    
}
