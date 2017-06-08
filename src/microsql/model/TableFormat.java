/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsql.model;

/**
 *
 * @author Irwansyah
 */
public class TableFormat {

    private String string;
    private String besaranLexic;
    private int tokenLexic;

    public TableFormat(String string, String besaranLexic, int tokenLexic) {
        this.string = string;
        this.besaranLexic = besaranLexic;
        this.tokenLexic = tokenLexic;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getBesaranLexic() {
        return besaranLexic;
    }

    public void setBesaranLexic(String besaranLexic) {
        this.besaranLexic = besaranLexic;
    }

    public int getTokenLexic() {
        return tokenLexic;
    }

    public void setTokenLexic(int tokenLexic) {
        this.tokenLexic = tokenLexic;
    }

    public void print() {
        System.out.println("");
        if (string.length() < 4) {
            System.out.println("\t\t" + string + "\t|\t\t" + besaranLexic + "\t\t|\t\t" + tokenLexic);
        } else {
            System.out.println("\t" + string + "\t|\t\t" + besaranLexic + "\t\t|\t\t" + tokenLexic);
        }
    }
}
