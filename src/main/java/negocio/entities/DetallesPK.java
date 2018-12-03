package negocio.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "letra")
    private Character letra;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;

    public DetallesPK() {
    }

    public DetallesPK(Character letra, int numero, int codigo) {
        this.letra = letra;
        this.numero = numero;
        this.codigo = codigo;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (letra != null ? letra.hashCode() : 0);
        hash += (int) numero;
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesPK)) {
            return false;
        }
        DetallesPK other = (DetallesPK) object;
        if ((this.letra == null && other.letra != null) || (this.letra != null && !this.letra.equals(other.letra))) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entities.DetallesPK[ letra=" + letra + ", numero=" + numero + ", codigo=" + codigo + " ]";
    }
    
}
