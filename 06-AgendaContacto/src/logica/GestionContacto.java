package logica;

import beans.Contacto;

import java.util.Collection;
import java.util.HashMap;

public class GestionContacto {

    HashMap<String, Contacto> agenda;

    public GestionContacto() {
        agenda = new HashMap<>();
    }

    public boolean agregar(String nombre, int edad, String email) {
        if (!agenda.containsKey(email)) {
            Contacto c = new Contacto(nombre, email, edad);
            agenda.put(email, c);
            return true;
        } else {
            return false;
        }
    }

    public Contacto buscar(String email) {
        Contacto c = null;
        if (agenda.containsKey(email)) {
            c = agenda.get(email);
        }

        return c;
    }

    public boolean eliminar(String email) {
        if (agenda.containsKey(email)) {
            agenda.remove(email);
            return true;
        } else {
            return false;
        }
    }

    public Contacto[] recuperarContactos() {
        Contacto[] existentes = new Contacto[agenda.size()];
        int i = 0;
        Collection<Contacto> valores = agenda.values();
        for (Contacto contacto : valores) {
            existentes[i++] = contacto;
        }

        return existentes;
    }
}