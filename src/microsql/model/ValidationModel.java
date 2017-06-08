/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsql.model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Irwansyah
 */
public class ValidationModel {

    private ArrayList<String> token;

    private boolean isValid = false;

    private ArrayList<TableFormat> listTableFormat = new ArrayList<TableFormat>();

    public ValidationModel() {

    }

    public void setListTableFormat(ArrayList<TableFormat> listTableFormat) {
        this.listTableFormat = listTableFormat;
    }

    private ArrayList<String> getStringToken() {
        token = new ArrayList<>();
        for (TableFormat tableFormat : listTableFormat) {
            token.add(tableFormat.getTokenLexic() + "");
        }
        token.add("END");
        return token;
    }

    public String isValid() {
        if (isValid) {
            return "VALID";
        } else {
            return "TIDAK VALID";
        }
    }

    public void validation() {
        getStringToken();
        isValid = false;
        Stack stack = new Stack();
        int cc = 0;

        String state = "i";

        stack.push("#");
        state = "p";
        stack.push("S");
        state = "q";

        loop:
        while (!stack.peek().equals("#")) {
            switch (stack.peek().toString()) {
                case "S":
                    if (token.get(cc).equals("14")) {
                        stack.pop();
                        stack.push("E");
                        stack.push("D");
                        stack.push("B");
                        stack.push("A");
                        stack.push("14");
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "D":
                    stack.pop();
                    break;
                case "E":
                    if (token.get(cc).equals("15")) {
                        stack.pop();
                        stack.push("S");
                        stack.push("15");
                    } else {
                        stack.pop();
                    }
                    break;
                case "14":
                    if (token.get(cc).equals("14")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "15":
                    if (token.get(cc).equals("15")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "A":
                    if (token.get(cc).equals("2")) {
                        stack.pop();
                        stack.push("F");
                        stack.push("2");
                    } else if (token.get(cc).equals("19")) {
                        stack.pop();
                        stack.push("F");
                        stack.push("19");
                    } else if (token.get(cc).equals("19") && token.get(cc + 1).equals("3")
                            && token.get(cc + 2).equals("19")) {
                        stack.pop();
                        stack.push("F");
                        stack.push("19");
                        stack.push("3");
                        stack.push("19");
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "F":
                    if (token.get(cc).equals("20")) {
                        stack.pop();
                        stack.push("A");
                        stack.push("20");
                    } else {
                        stack.pop();
                    }
                    break;
                case "2":
                    if (token.get(cc).equals("2")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "19":
                    if (token.get(cc).equals("19")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "3":
                    if (token.get(cc).equals("3")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "20":
                    if (token.get(cc).equals("20")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "B":
                    if (token.get(cc).equals("9")) {
                        stack.pop();
                        stack.push("G");
                        stack.push("9");
                    }
                    break;
                case "G":
                    if (token.get(cc).equals("19")) {
                        stack.pop();
                        stack.push("H");
                        stack.push("19");
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                case "H":
                    if (token.get(cc).equals("20")) {
                        stack.pop();
                        stack.push("G");
                        stack.push("20");
                    } else {
                        stack.pop();
                    }
                    break;
                case "9":
                    if (token.get(cc).equals("9")) {
                        stack.pop();
                        cc++;
                    } else {
                        stack.push("ERROR");
                    }
                    break;
                default:
                    break loop;
            }
        }

        if (stack.peek().equals("#")) {
            if (token.get(token.size() - 2).equals("4") || (token.size()-1 == cc)) {
                stack.pop();
                state = "f";
                isValid = true;
            }
        }
    }
}
