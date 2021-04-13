class Q2 {
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

    public void printTexto() {
        System.out.println(this.texto);
    }

    public int getQtPalavras() {
        int len = this.texto.length(), qt = 0;
        
        boolean found = false;
        for(int i = 0; i < len; i++) {
            char c = this.texto.charAt(i);
            boolean isAlphaNumeric = (Character.isLetter(c) || Character.isDigit(c));
            
            // If is alphanumeric, mark as found
            if(isAlphaNumeric) {
                found = true;
            }
            // If not is alphanumeric and found an earlier substr, inc qt and reset boolean
            else if (!isAlphaNumeric && found){
                qt++;
                found = false;
            }
            
            // Case to avoid errors with last word
            if(i == len - 1 && found) {
                qt++;
                found = false;
            }
        }

        return qt;
    }

    public int getFreqSubStr(String subStr) {
        int len = this.texto.length(), subLen = subStr.length(), qt = 0;
        
        for (int i = 0; i < len; i++) {
            // Avoid string index exception
            if(i+subLen > len) {
                break;
            }
            
            // If first char is eq, cast an loop
            if(this.texto.charAt(i) == subStr.charAt(0)) {
                boolean found = true;
                for(int j = 0; j < subLen; j++) {
                    if(this.texto.charAt(i + j) != subStr.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if(found) {
                    qt++;
                }
            }
        }

        return qt;
    }

    public void replaceSubStr(String subStr, String replaceStr) {
        this.texto = this.texto.replaceAll(subStr, replaceStr);
    }

}
