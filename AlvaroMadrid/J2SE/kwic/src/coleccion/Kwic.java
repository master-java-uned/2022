package coleccion;

import basico.TituloKwic;

import java.util.*;

public class Kwic {

    private Set<TituloKwic> noclaves;
    private Map<TituloKwic,Set<String>> kwic;

    public Kwic(){
        this.noclaves = new TreeSet();
        this.kwic = new TreeMap();
    }

    public void computaNoClaves(String noclaves){
        StringTokenizer strk = new StringTokenizer(noclaves, " ,");

        while (strk.hasMoreTokens()){
            this.noclaves.add(new TituloKwic(strk.nextToken()));
        }
    }

    private void computaIndice(TituloKwic palabra, String frase){
        Set<String> frases = new TreeSet();
        if(this.kwic.containsKey(palabra)){
            frases = this.kwic.get(palabra);
        }
        frases.add(palabra.reemplaza(frase));
        this.kwic.put(palabra, frases);
    }

    public void computaIndice(String frase){
        StringTokenizer strk = new StringTokenizer(frase, " ,");

        while(strk.hasMoreTokens()){
            TituloKwic palabra = new TituloKwic(strk.nextToken());
            if(!(this.noclaves.contains(palabra))){
                this.computaIndice(palabra, frase);
            }
        }
    }

    private String escribeNoClaves() {
        String str = "Palabras no claves: ";
        Iterator<TituloKwic> it = this.noclaves.iterator();
        while (it.hasNext()) {
            str += it.next().toString() + ", ";
        }
        return str;
    }

    private String escribeKwic(Set<String> s) {
        String str = "";
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            str += "\t" + it.next() + "\n";
        }
        return str;
    }

    private String escribeKwic(){
        String str = "-- INDICE --\n";
        Iterator<Map.Entry<TituloKwic, Set<String>>> it = this.kwic.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<TituloKwic, Set<String>> mp = it.next();
            str += mp.getKey()+"\n";
            str += escribeKwic(mp.getValue());
        }
        return str;
    }

    public String toString(){
        String str = "";
        str += this.escribeNoClaves();
        str += this.escribeKwic();
        return str;
    }

}
