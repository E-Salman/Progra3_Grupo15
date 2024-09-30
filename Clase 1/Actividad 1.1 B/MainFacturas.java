import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainFacturas {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1,2000,100));
        facturas.add(new Factura(2,1000,101));
        facturas.add(new Factura(3,1500,102));
        facturas.add(new Factura(4,2600,100));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(100,"Nico"));
        clientes.add(new Cliente(101,"Esteban"));
        clientes.add(new Cliente(102,"Zoe"));
        
        List<SumaFacturas> resultado = sistemaFacturacion(facturas, clientes);
        System.out.println(sistemaFacturacionMaps(facturas, clientes).toString());

        //Este for es para debuggeado, no lo tengo en cuenta en el calculo de complejidad
        for (int i = 0; resultado.size() > i; i++){
            System.out.println("Id cliente: "+ resultado.get(i).IDcliente);
            System.out.println("importe total: " + resultado.get(i).importe);
            System.out.println();
        }
    }

    //n * (n + n + n)
    //Con Maps O(3n^2)
    public static HashMap sistemaFacturacionMaps(List<Factura> facturas, List<Cliente> clientes){
        HashMap<Integer, Integer> facturasClientes = new HashMap<>();
        Factura factura;
        for(int i = 0; i < facturas.size(); i++){
            factura = facturas.get(i);
            if(facturasClientes.containsKey(factura.IDcliente)) facturasClientes.put(factura.IDcliente, facturasClientes.get(factura.IDcliente) + factura.importe);
            else facturasClientes.put(factura.IDcliente, factura.importe);
        }
        return facturasClientes;
    }

    //Sin Maps O(n + 2n^2 + 4n^3)
    public static List sistemaFacturacion(List<Factura> facturas, List<Cliente> clientes){
        List<SumaFacturas> listaRetorno = new ArrayList<>();
        for(int i = 0; i < clientes.size(); i++){ //n
            listaRetorno.add(new SumaFacturas(clientes.get(i).IDcliente, 0)); //n
        }

        for(int i = 0; i < facturas.size();i++){ //n
            for(int j = 0; j < listaRetorno.size(); j++){ //n
                if(facturas.get(i).IDcliente == listaRetorno.get(j).IDcliente){ //2n
                    listaRetorno.get(j).importe += facturas.get(i).importe; //2n
                    break;
                }
            }
        }
        return listaRetorno;
    }
}