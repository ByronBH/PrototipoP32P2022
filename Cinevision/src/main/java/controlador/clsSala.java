
package controlador;

/**
 *
 * @author Byron
 */
public class clsSala {
    private int id_clientes;
    private String Nombre;
    private String Nit;
    
   public clsSala() {
    }
    public clsSala(int cid) {
        this.id_clientes = cid; 
   }
   
        public clsSala(String Nombre, String Nit) {
        this.Nombre = Nombre;
        this.Nit = Nit;
    }
         public clsSala(int Cid, String Nombre, String Nit) {
         this.id_clientes = Cid; 
        this.Nombre = Nombre;
        this.Nit = Nit;
         }
         
         
 public int getId_clientes() {
        return id_clientes;
    }
  public void setId_clientes(int cid) {
        this.id_clientes=cid;
    }
   public String getnombre() {
        return Nombre;
    }
      public void setnombre(String Nombre) {
        this.Nombre=Nombre;
    }
   public String getnit() {
        return Nit;
    }
  public void setnit(String Nit) {
        this.Nit=Nit;
    }
     @Override
    public String toString() {
        return "clientes{" + "idclientes=" + id_clientes + ", Nombre=" + Nombre + ", Nit=" + Nit + '}';
    }
    
  
  
}
  

