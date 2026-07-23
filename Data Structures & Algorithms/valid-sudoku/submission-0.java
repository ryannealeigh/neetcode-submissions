class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 3 lists of hashsets, rows, cols, boxes
        // iterate over the whole matrix
        // add existing vals to hashsets
        // check if later vals are in a corresponding hashset
        // if any are return false
        // default return true

        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<List<HashSet<Character>>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            boxes.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                boxes.get(i).add(new HashSet<>());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }
                if (rows.get(i).contains(val) || cols.get(j).contains(val) || 
                    boxes.get(i / 3).get(j / 3).contains(val)
                ) {
                    return false;
                }
                rows.get(i).add(val);
                cols.get(j).add(val);
                boxes.get(i / 3).get(j / 3).add(val);
            }
        }

        return true;
    }
}
