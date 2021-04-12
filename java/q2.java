class Q2
{
    public static void main(String[] args) {
        // Creating Texto
        Texto texto = new Texto("Ola humanos humanos seus inuteis, inuteis, inuteis.");

        // Cast and print qtPalavras output
        System.out.println("Qt palavras: " + texto.getQtPalavras());

        // Check 'inuteis' word frequency
        System.out.println("Freq 'inuteis': " + texto.getFreqSubStr("inuteis"));
        
        // Replace 'inuteis' for 'uteis'
        texto.replaceSubStr("inuteis", "uteis");
        
        // Check 'uteis' word frequency
        System.out.println("Freq 'uteis': " + texto.getFreqSubStr("uteis"));
        
        // Replace 'humanos' for 'animais'
        texto.replaceSubStr("humanos", "animais");

        // Cast printTexto
        texto.printTexto();
    }
}

class Texto {
    protected String texto;

    protected Texto(String texto) {
        this.texto = texto;
    }

    protected String preProcess(String string) {
        // Only maintain letters / nums and only one whitespace between words
        return string.replaceAll("[^A-Za-z0-9]", " ").trim().replaceAll(" +", " ");
    }

    public void printTexto() {
        System.out.println(this.texto);
    }

    public int getQtPalavras() {
        // Cast preProcess to correctly parse the words
        String textoAux = preProcess(this.texto);
        
        int qt = 0;
        for(String palavra: textoAux.split(" ")) {
            qt++;
        }

        return qt;
    }

    public int getFreqSubStr(String subStr) {
        // Cast preProcess to correctly parse the words
        String textoAux = preProcess(this.texto);
        
        int qt = 0;
        for(String palavra: textoAux.split(" ")) {
            if(palavra.equals(subStr)) {
                qt++;
            }
        }

        return qt;
    }

    public void replaceSubStr(String subStr, String replaceStr) {
        this.texto = this.texto.replaceAll(subStr, replaceStr);
    }

}