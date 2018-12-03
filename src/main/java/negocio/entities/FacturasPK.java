package negocio.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacturasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "letra")
    private Character letra;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;

    public FacturasPK() {
    }

    public FacturasPK(Character letra, int numero) {
        this.letra = letra;
        this.numero = numero;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (letra != null ? letra.hashCode() : 0);
        hash += (int) numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasPK)) {
            return false;
        }
        FacturasPK other = (FacturasPK) object;
        if ((this.letra == null && other.letra != null) || (this.letra != null && !this.letra.equals(other.letra))) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entities.FacturasPK[ letra=" + letra + ", numero=" + numero + " ]";
    }
    
}
