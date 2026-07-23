class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String op = tokens[i];

            if (op.equals("+")) {
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1 + val2);
            } else if (op.equals("-")) {
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1 - val2);
            } else if (op.equals("*")) {
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1 * val2);
            } else if (op.equals("/")) {
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1 / val2);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
