package negocio.repositories;

import java.util.Date;
import java.util.List;
import negocio.entities.Factura;

public interface I_FacturaRepository {
    List<Factura>getByLetra(Character letra);
    List<Factura>getByMonto(Double monto);
    List<Factura>getByFecha(Date fecha);
}
