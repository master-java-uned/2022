package basico;

import coleccion.Kwic;
import java.util.Locale;
import java.util.StringTokenizer;

public class TituloKwic {

    private String tk;

    public TituloKwic(String str){
        this.tk = str.toUpperCase();
    }

    /**
     *
     * @param o
     * @return el objeto TituloKwic
     */
    public boolean equals(Object o){
        if (o instanceof TituloKwic){
            TituloKwic tk = (TituloKwic) o;
            return this.tk.equals(tk.toString());
        } else {
            throw new KwicException("No es un TituloKwic");
        }
    }

    public int hasCode(){
        return this.tk.hashCode();
    }

    public String reemplaza(String frase){
        StringTokenizer strk = new StringTokenizer(frase, " ,");
        String resultado = "";
        while (strk.hasMoreTokens()){
            String palabraAComparar = strk.nextToken();
            TituloKwic tk = new TituloKwic(palabraAComparar);
            if(this.tk.equals(tk.toString())){
                resultado += "... ";
            } else {
                resultado += palabraAComparar + " ";
            }
        }
        return resultado;


    }
}
