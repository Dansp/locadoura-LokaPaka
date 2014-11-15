package br.edu.fatec.util;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.edu.fatec.bean.Cliente;

/**
 * @author Mews
 * 
 */
public class Dispatcher {
 
    private static Dispatcher instance;
    private Set<Listener> listeners;
 
    private Dispatcher() {
        this.listeners = new HashSet<Listener>();
    }
 
    public static Dispatcher getInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }
 
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }
 
    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }
 
    public void dispatcherCliente(Cliente cliente) {
        Iterator<Listener> iterator = listeners.iterator();
 
        while (iterator.hasNext()) {
            Listener listener = (Listener) iterator.next();
            listener.onClienteCadastrado(cliente);
        }
    }
}