import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<factura> facturas = new ArrayList<>();
        facturas.add(new factura(1,2000,100));
        facturas.add(new factura(2,1000,101));
        facturas.add(new factura(3,1500,102));
        facturas.add(new factura(4,2600,100));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(100,"Nico"));
        clientes.add(new Cliente(101,"Esteban"));
        clientes.add(new Cliente(102,"Zoe"));

        List<SumaFacturas> resultado = sistemaFacturacion(facturas, clientes);

        for (int i = 0; resultado.size() > i; i++){
            System.out.println("Id cliente: "+ resultado.get(i).IDcliente);
            System.out.println("nombre: " + resultado.get(i).nombre);
            System.out.println("importe total: " + resultado.get(i).importe);
            System.out.println();
        }
    }

    public static List sistemaFacturacion(List<factura> facturas, List<Cliente> clientes){
        List<SumaFacturas> listaRetorno = new ArrayList<>();
        for(int i =0; i < clientes.size(); i++){
            listaRetorno.add(new SumaFacturas(clientes.get(i).IDcliente,clientes.get(i).nombre,0));
        }
        for(int i = 0; i < facturas.size();i++){
            for(int j = 0; j < listaRetorno.size(); j++){
                if(facturas.get(i).IDcliente == listaRetorno.get(j).IDcliente){
                    listaRetorno.get(j).importe += facturas.get(i).importe;
                    break;
                }
            }
        }
        return listaRetorno;
    }
}