class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        // 1. for i = 0 to n
        //      get current character
        // 2. if curr = open paren, 
        //      push to stack
        //    else
        //      if peek matches curr 
        //        pop()
        //      else
        //        return false
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                if (
                    stack.size() == 0 ||
                    (curr == ')' && stack.peek() != '(') ||
                    (curr == ']' && stack.peek() != '[') ||
                    (curr == '}' && stack.peek() != '{')
                ) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
