import java.util.*;

class Q6 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();

        // Discovering expression type
        Classifier classifier = new Classifier(expr);
        ExpressionTypes exprType = classifier.getType();

        // Processing for each type
        switch(exprType) {
            case ARITHMETIC: {
                ExprAritmetica exprAritmetica = new ExprAritmetica();
                exprAritmetica.setExpr(expr);
                System.out.println(exprAritmetica);
                System.out.println("ao chamar avaliar: " + exprAritmetica.avaliar(exprAritmetica.getExpr()));
                System.out.println("ao chamar imprimirArvore: " + exprAritmetica.imprimirArvore(exprAritmetica.getExpr()));
                break;
            }
            case LOGIC: {
                ExprLogica exprLogica = new ExprLogica();
                exprLogica.setExpr(expr);
                System.out.println(exprLogica);
                System.out.println("ao chamar avaliar: " + exprLogica.avaliar(exprLogica.getExpr()));
                System.out.println("ao chamar imprimirArvore: " + exprLogica.imprimirArvore(exprLogica.getExpr()));
                break;
            }
            case LOGIC_TERNARY: {
                ExprOpTernario exprOpTernario = new ExprOpTernario();
                exprOpTernario.setExpr(expr);
                System.out.println(exprOpTernario);
                System.out.println("ao chamar avaliar: " + exprOpTernario.avaliar(exprOpTernario.getExpr()));
                System.out.println("ao chamar imprimirArvore: " + exprOpTernario.imprimirArvore(exprOpTernario.getExpr()));
                break;
            }
        }
    }
}

class Classifier {
    protected String expr;
    protected ExpressionTypes type;

    Classifier(String expr) {
        this.expr = expr;
        this.evaluateExpr();
    }

    protected void evaluateExpr() {
        // Set default as ARITHMETIC type
        this.type = ExpressionTypes.ARITHMETIC;

        // If string contains '<' or '>' as substr, is logical
        for(int i = 0; i < this.expr.length(); i++) {
            if(this.expr.charAt(i) == '>' || this.expr.charAt(i) == '<') {
                this.type = ExpressionTypes.LOGIC;
                break;
            }
        }

        // Check if is ternary (contains '?' or ':' as substr)
        for(int i = 0; i < this.expr.length(); i++) {
            if(this.expr.charAt(i) == '?' || this.expr.charAt(i) == ':') {
                this.type = ExpressionTypes.LOGIC_TERNARY;
                break;
            }
        }
    }

    public ExpressionTypes getType() {
        return this.type;
    }
}

enum ExpressionTypes {
    ARITHMETIC,
    LOGIC,
    LOGIC_TERNARY
}

interface Expression  {
    String avaliar(String expr);
    String imprimirArvore(String expr);
}

class ExprAritmetica implements Expression {
    private String expr;

    ExprAritmetica() {
        this.expr = "";
    }

    @Override
    public String avaliar(String expr) {
        int exprLen = expr.length();
        char [] priorities = new char[]{'/', '*', '-', '+'};
        for(int op = priorities.length - 1; op >= 0; op--) {
            for(int i = exprLen - 1; i >= 0; i--) {
                if(expr.charAt(i) == priorities[op]) {
                    String exprLeft = avaliar(expr.substring(0, i));
                    String exprRight = avaliar(expr.substring(i + 1, exprLen));
                    double finalCalc = 0;

                    switch(priorities[op]){
                        case '+':{
                            finalCalc = Double.valueOf(exprLeft) + Double.valueOf(exprRight);
                            break;
                        }
                        case '-':{
                            finalCalc = Double.valueOf(exprLeft) - Double.valueOf(exprRight);
                            break;
                        }
                        case '*':{
                            finalCalc = Double.valueOf(exprLeft) * Double.valueOf(exprRight);
                            break;
                        }
                        case '/':{
                            finalCalc = Double.valueOf(exprLeft) / Double.valueOf(exprRight);
                            break;
                        }
                    }

                    return String.valueOf(finalCalc);
                }
            }
        }

        return expr;
    }

    @Override
    public String imprimirArvore(String expr) {
        int exprLen = expr.length();
        char [] priorities = new char[]{'/', '*', '-', '+'};
        for(int op = priorities.length - 1; op >= 0; op--) {
            for(int i = exprLen - 1; i >= 0; i--) {
                if(expr.charAt(i) == priorities[op]) {
                    return "(" + imprimirArvore(expr.substring(0, i)) + expr.charAt(i) + imprimirArvore(expr.substring(i+1, exprLen)) + ")";
                }
            }
        }
        return "(" + expr + ")";
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
              + Integer.toHexString(hashCode()) + " expr:'" + this.expr + "'";
    }

    // Setters
    public void setExpr(String expr) {
        this.expr = expr;
    }

    // Getters
    public String getExpr() {
        return this.expr;
    }
}

class ExprLogica implements Expression {
    private String expr;

    ExprLogica() {
        this.expr = "";
    }

    @Override
    public String avaliar(String expr) {
        String [] operations = new String[]{">=", "<=", "!=", "==", ">", "<"};
        for(int i = 0; i < operations.length; i++) {
            int indexOfOp = expr.indexOf(operations[i]);
            if(indexOfOp != -1) {
                // Set left expression
                ExprAritmetica exprLeft = new ExprAritmetica();
                exprLeft.setExpr(expr.substring(0, indexOfOp));

                // Set right expression
                ExprAritmetica exprRight = new ExprAritmetica();
                exprRight.setExpr(expr.substring(indexOfOp + ((i > 3) ? 1 : 2), expr.length()));

                // Take expr evaluations
                String evalExprLeft = exprLeft.avaliar(exprLeft.getExpr());
                String evalExprRight = exprRight.avaliar(exprRight.getExpr());
                boolean totalExprEval = true;

                switch(operations[i]) {
                    case ">":{
                        totalExprEval = (Double.valueOf(evalExprLeft) > Double.valueOf(evalExprRight));
                        break;
                    }
                    case ">=":{
                        totalExprEval = (Double.valueOf(evalExprLeft) >= Double.valueOf(evalExprRight));
                        break;
                    }
                    case "<":{
                        totalExprEval = (Double.valueOf(evalExprLeft) < Double.valueOf(evalExprRight));
                        break;
                    }
                    case "<=":{
                        totalExprEval = (Double.valueOf(evalExprLeft) <= Double.valueOf(evalExprRight));
                        break;
                    }
                    case "==":{
                        totalExprEval = (Double.valueOf(evalExprLeft) == Double.valueOf(evalExprRight));
                        break;
                    }
                    case "!=":{
                        totalExprEval = (Double.valueOf(evalExprLeft) != Double.valueOf(evalExprRight));
                        break;
                    }
                }

                return String.valueOf(totalExprEval);
            }
        }

        return expr;
    }

    @Override
    public String imprimirArvore(String expr) {
        String [] operations = new String[]{">=", "<=", "!=", "==", ">", "<"};
        for(int i = 0; i < operations.length; i++) {
            int indexOfOp = expr.indexOf(operations[i]);
            if(indexOfOp != -1) {
                // Set left expression
                ExprAritmetica exprLeft = new ExprAritmetica();
                exprLeft.setExpr(expr.substring(0, indexOfOp));

                // Set right expression
                ExprAritmetica exprRight = new ExprAritmetica();
                exprRight.setExpr(expr.substring(indexOfOp + ((i > 3) ? 1 : 2), expr.length()));

                return "(" + exprLeft.imprimirArvore(exprLeft.getExpr()) + operations[i] + exprRight.imprimirArvore(exprRight.getExpr()) + ")";
            }
        }

        return expr;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
              + Integer.toHexString(hashCode()) + " expr:'" + this.expr + "'";
    }

    // Setters
    public void setExpr(String expr) {
        this.expr = expr;
    }

    // Getters
    public String getExpr() {
        return this.expr;
    }
}

class ExprOpTernario implements Expression {
    private String expr;

    ExprOpTernario() {
        this.expr = "";
    }

    @Override
    public String avaliar(String expr) {
        // Search for '?'
        int exprIndex = expr.indexOf("?");

        // Take and evaluate logic expression
        String logicExpression = expr.substring(0, exprIndex);
        ExprLogica exprLogica = new ExprLogica();
        exprLogica.setExpr(logicExpression);
        String logicEval = exprLogica.avaliar(exprLogica.getExpr());

        // Take expr to eval
        String exprToEval = "";
        int partIndex = expr.indexOf(":");

        // If logicEval is true, take first expr
        if(Boolean.parseBoolean(logicEval) == true) {
            exprToEval = expr.substring(exprIndex + 1, partIndex);
        }
        else {
            exprToEval = expr.substring(partIndex + 1, expr.length());
        }
        
        // Create an classifier to check what type it is
        Classifier classifier = new Classifier(exprToEval);
        ExpressionTypes exprType = classifier.getType();
        
        // Switch between types and cast their 'avaliar' method
        switch(classifier.getType()) {
            case ARITHMETIC:{
                ExprAritmetica exprArit = new ExprAritmetica();
                exprArit.setExpr(exprToEval);

                return String.valueOf(exprArit.avaliar(exprArit.getExpr()));
            }
            case LOGIC:{
                ExprLogica exprLogic = new ExprLogica();
                exprLogic.setExpr(exprToEval);

                return String.valueOf(exprLogic.avaliar(exprLogic.getExpr()));
            }
            case LOGIC_TERNARY:{
                ExprOpTernario exprOpTern = new ExprOpTernario();
                exprOpTern.setExpr(exprToEval);

                return String.valueOf(exprOpTern.avaliar(exprOpTern.getExpr()));
            }
        }

        return expr;
    }

    @Override
    public String imprimirArvore(String expr) {
        String output = "";

        // Search for '?'
        int exprIndex = expr.indexOf("?");

        // Take logic expression
        String logicExpression = expr.substring(0, exprIndex);
        ExprLogica exprLogica = new ExprLogica();
        exprLogica.setExpr(logicExpression);
        output += exprLogica.imprimirArvore(exprLogica.getExpr()) + "?";

        // Find ':' to separate expressions
        int partIndex = expr.indexOf(":");

        // Take and process left expression
        String leftExpression = expr.substring(exprIndex + 1, partIndex);

        // Create an classifier to check what type it is
        Classifier classifier2 = new Classifier(leftExpression);
        ExpressionTypes exprType2 = classifier2.getType();
        
        // Switch between types and cast their 'avaliar' method
        switch(exprType2) {
            case ARITHMETIC:{
                ExprAritmetica exprArit = new ExprAritmetica();
                exprArit.setExpr(leftExpression);
                output += exprArit.imprimirArvore(exprArit.getExpr()) + ":";
                
                break;
            }
            case LOGIC:{
                ExprLogica exprLogic = new ExprLogica();
                exprLogic.setExpr(leftExpression);
                output += exprLogic.imprimirArvore(exprLogic.getExpr()) + ":";

                break;
            }
            case LOGIC_TERNARY:{
                ExprOpTernario exprOpTern = new ExprOpTernario();
                exprOpTern.setExpr(leftExpression);
                output += exprOpTern.imprimirArvore(exprOpTern.getExpr()) + ":";

                break;
            }
        }

        // Take and process right expression
        String rightExpression = expr.substring(partIndex + 1, expr.length());
        
        // Create an classifier to check what type it is
        Classifier classifier = new Classifier(rightExpression);
        ExpressionTypes exprType = classifier.getType();
        
        // Switch between types and cast their 'avaliar' method
        switch(classifier.getType()) {
            case ARITHMETIC:{
                ExprAritmetica exprArit = new ExprAritmetica();
                exprArit.setExpr(rightExpression);
                output += exprArit.imprimirArvore(exprArit.getExpr());
                
                break;
            }
            case LOGIC:{
                ExprLogica exprLogic = new ExprLogica();
                exprLogic.setExpr(rightExpression);
                output += exprLogic.imprimirArvore(exprLogic.getExpr());

                break;
            }
            case LOGIC_TERNARY:{
                ExprOpTernario exprOpTern = new ExprOpTernario();
                exprOpTern.setExpr(rightExpression);
                output += exprOpTern.imprimirArvore(exprOpTern.getExpr());

                break;
            }
        }

        return output;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
              + Integer.toHexString(hashCode()) + " expr:'" + this.expr + "'";
    }
    
    // Setters
    public void setExpr(String expr) {
        this.expr = expr;
    }

    // Getters
    public String getExpr() {
        return this.expr;
    }
}
