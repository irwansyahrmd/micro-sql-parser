package microsql.model;

import java.util.ArrayList;

/**
 *
 * @author Irwansyah
 */
public class ParseModel {

    private String query;
    private String word = "";
    private ArrayList<TableFormat> listTableFormat = new ArrayList<TableFormat>();

    public ParseModel() {
    }

    public ParseModel(String query) {
        this.listTableFormat = new ArrayList<TableFormat>();
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<TableFormat> getListTableFormat() {
        return listTableFormat;
    }

    public void setListTableFormat(ArrayList<TableFormat> listTableFormat) {
        this.listTableFormat = listTableFormat;
    }

    public void startParsing() {
        
        for (String queryPerLine : query.split("\\n")) {
            boolean isString = false;
            queryPerLine = queryPerLine.toLowerCase() + "  ";
            int currentState = 0;
            char currentChar = queryPerLine.charAt(0);
            int i = 0;

            while (i < queryPerLine.length() - 1) {
                if (currentChar == '*' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 39;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == '(' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 37;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == ')' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 38;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == ';' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 41;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == '.' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 40;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == '=' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 44;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == '<' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 42;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                } else if (currentChar == '>' && !isString) {
                    finalState(currentState);
                    word += currentChar;
                    currentState = 45;
                    finalState(currentState);
                    currentState = 0;
                    currentChar = queryPerLine.charAt(++i);
                    continue;
                }

                if (currentState == 0) {
                    if (currentChar == ' ') {
                        currentState = 0;
                    } else if (currentChar == 'a') {
                        currentState = 1;
                    } else if (currentChar == 'f') {
                        currentState = 4;
                    } else if (currentChar == 'j') {
                        currentState = 8;
                    } else if (currentChar == 'l') {
                        currentState = 12;
                    } else if (currentChar == 'n') {
                        currentState = 16;
                    } else if (currentChar == 'o') {
                        currentState = 19;
                    } else if (currentChar == 's') {
                        currentState = 21;
                    } else if (currentChar == 'u') {
                        currentState = 27;
                    } else if (currentChar == 'w') {
                        currentState = 32;
                    } else if (currentChar == '"') {
                        currentState = 50;
                        isString = true;
                    } else if (currentChar == '(') {
                        currentState = 37;
                    } else if (currentChar == ')') {
                        currentState = 38;
                    } else if (currentChar == '*') {
                        currentState = 39;
                    } else if (currentChar == '.') {
                        currentState = 40;
                    } else if (currentChar == ';') {
                        currentState = 41;
                    } else if (currentChar == '<') {
                        currentState = 42;
                    } else if (currentChar == '=') {
                        currentState = 44;
                    } else if (currentChar == '>') {
                        currentState = 45;
                    } else if (Character.isDigit(currentChar)) {
                        currentState = 47;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_') {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 1) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'n') {
                        currentState = 2;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 2) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'd') {
                        currentState = 3;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 3) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 4) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'r') {
                        currentState = 5;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 5) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'o') {
                        currentState = 6;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 6) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'm') {
                        currentState = 7;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 7) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 8) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'o') {
                        currentState = 9;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 9) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'i') {
                        currentState = 10;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 10) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'n') {
                        currentState = 11;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 11) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 12) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'i') {
                        currentState = 13;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 13) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'k') {
                        currentState = 14;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 14) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'e') {
                        currentState = 15;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 15) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 16) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'o') {
                        currentState = 17;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 17) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 't') {
                        currentState = 18;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 18) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 19) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'r') {
                        currentState = 20;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 20) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 21) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'e') {
                        currentState = 22;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 22) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'l') {
                        currentState = 23;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 23) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'e') {
                        currentState = 24;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 24) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'c') {
                        currentState = 25;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 25) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 't') {
                        currentState = 26;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 26) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 27) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'n') {
                        currentState = 28;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 28) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'i') {
                        currentState = 29;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 29) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'o') {
                        currentState = 30;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 30) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'n') {
                        currentState = 31;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 31) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 32) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'h') {
                        currentState = 33;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 33) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'e') {
                        currentState = 34;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 34) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'r') {
                        currentState = 35;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 35) {
                    if (currentChar == ' ') {
                        currentState = 99;
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == 'e') {
                        currentState = 36;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 36) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 37) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 38) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 39) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 40) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 41) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 42) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == '=') {
                        currentState = 43;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 43) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 44) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 45) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (currentChar == '=') {
                        currentState = 46;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 46) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 47) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isDigit(currentChar)) {
                        currentState = 47;
                    } else if (currentChar == ',' || currentChar == '.') {
                        currentState = 48;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 48) {
                    if (Character.isDigit(currentChar)) {
                        currentState = 49;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 49) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isDigit(currentChar)) {
                        currentState = 49;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 50) {
                    if (currentChar == '"') {
                        currentState = 51;
                        isString = false;
                    } else {
                        currentState = 50;
                    }
                } else if (currentState == 51) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else {
                        currentState = 999;
                    }
                } else if (currentState == 99) {
                    if (currentChar == ' ') {
                        finalState(currentState);
                        currentState = 0;
                    } else if (Character.isAlphabetic(currentChar) || currentChar == '_' || Character.isDigit(currentChar)) {
                        currentState = 99;
                    } else {
                        currentState = 999;
                    }
                } else {
                    System.out.println("SYNTAX ERROR");
                    break;
                }
                if (currentChar != ' ' || isString) {
                    word += currentChar;
                }
                currentChar = queryPerLine.charAt(++i);
            }
        }
    }

    private void finalState(int currentState) {
        //System.out.println(word);
        switch (currentState) {
            case 3:
                // AND
                listTableFormat.add(new TableFormat(word, "KEYWORD", 8));
                break;
            case 7:
                // FROM
                listTableFormat.add(new TableFormat(word, "KEYWORD", 9));
                break;
            case 11:
                // JOIN
                listTableFormat.add(new TableFormat(word, "KEYWORD", 10));
                break;
            case 15:
                // LIKE
                listTableFormat.add(new TableFormat(word, "KEYWORD", 11));
                break;
            case 18:
                // NOT
                listTableFormat.add(new TableFormat(word, "KEYWORD", 12));
                break;
            case 20:
                // OR
                listTableFormat.add(new TableFormat(word, "KEYWORD", 13));
                break;
            case 26:
                // SELECT
                listTableFormat.add(new TableFormat(word, "KEYWORD", 14));
                break;
            case 31:
                // UNION
                listTableFormat.add(new TableFormat(word, "KEYWORD", 15));
                break;
            case 36:
                // WHERE
                listTableFormat.add(new TableFormat(word, "KEYWORD", 16));
                break;
            case 37:
                // (
                listTableFormat.add(new TableFormat(word, "KEYWORD", 0));
                break;
            case 38:
                // )
                listTableFormat.add(new TableFormat(word, "KEYWORD", 1));
                break;
            case 39:
                // *
                listTableFormat.add(new TableFormat(word, "KEYWORD", 2));
                break;
            case 40:
                // .
                listTableFormat.add(new TableFormat(word, "KEYWORD", 3));
                break;
            case 41:
                // *
                listTableFormat.add(new TableFormat(word, "KEYWORD", 4));
                break;
            case 42:
                // <
                listTableFormat.add(new TableFormat(word, "KEYWORD", 5));
                break;
            case 43:
                // <=
                listTableFormat.add(new TableFormat(word, "KEYWORD", 5));
                break;
            case 44:
                // =
                listTableFormat.add(new TableFormat(word, "KEYWORD", 6));
                break;
            case 45:
                // >
                listTableFormat.add(new TableFormat(word, "KEYWORD", 7));
                break;
            case 46:
                // >=
                listTableFormat.add(new TableFormat(word, "KEYWORD", 7));
                break;
            case 47:
                // INTEGER
                listTableFormat.add(new TableFormat(word, "CONSTANT", 17));
                break;
            case 49:
                // REAL
                listTableFormat.add(new TableFormat(word, "CONSTANT", 17));
                break;
            case 51:
                // STRING
                listTableFormat.add(new TableFormat(word, "CONSTANT", 18));
                break;
            case 0:
                break;
            case 99:
                // VARIABLE
                listTableFormat.add(new TableFormat(word, "VARIABLE", 19));
                break;
        }
        word = "";
    }
}
