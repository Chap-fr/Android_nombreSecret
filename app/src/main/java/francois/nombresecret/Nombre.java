package francois.nombresecret;

/**
 * Created by François on 01/02/2018.
 */

public class Nombre {

    private int nombre;

    public Nombre(){
        this.nombre = 0;
    }

    public Nombre(int nb){
        this.nombre = nb;
    }

    public void generer (int lim1, int lim2){
        this.nombre  = (int)(Math.random() *(lim2 - lim1) + lim1);
    }

    public boolean comparer (int nb){

        return (nb == this.nombre); // ? true : false;
    }

    public String message (int nb){

        if (nb>this.nombre) return "nombre user > secret";
        else if (this.comparer(nb))
            return "Bravo !";
        else return "nombre user < secret";
    }


    // GETTER

    public int getNombre() {
        return nombre;
    }

    // SETTER

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
