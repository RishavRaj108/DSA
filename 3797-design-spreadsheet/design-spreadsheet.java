class Spreadsheet {
    int[][] spreadsheet;
    public Spreadsheet(int rows) {
        spreadsheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        spreadsheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        spreadsheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] spot = formula.split("\\+");
        String s1 = spot[0];
        String s2 = spot[1];
        int val1 = 0;
        int val2 = 0;

        char ch1 = s1.charAt(0);
        if(Character.isLetter(ch1)){
            int col = s1.charAt(0) - 'A';
            int row = Integer.parseInt(s1.substring(1)) - 1;
            val1 = spreadsheet[row][col];
        }else{
            val1 = Integer.parseInt(s1);
        }
        char ch2 = s2.charAt(0);
        if(Character.isLetter(ch2)){
            int col = s2.charAt(0) - 'A';
            int row = Integer.parseInt(s2.substring(1)) - 1;
            val2 = spreadsheet[row][col];
        }else{
            val2 = Integer.parseInt(s2);
        }
        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */