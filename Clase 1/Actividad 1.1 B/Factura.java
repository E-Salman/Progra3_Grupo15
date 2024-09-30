public class Factura {
    int IDfactura;
    int importe;
    int IDcliente;

    public Factura(int IDfactura, int importe, int IDcliente){
        this.IDcliente = IDcliente;
        this.IDfactura = IDfactura;
        this.importe = importe;
    }
}
