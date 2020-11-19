package ru.stk.hw03.stack;

public class StringOps {
    private final String str;

    public StringOps (String str){
        this.str = str;
    }

    public String revert (){
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new StackImpl<>(str.length());
        for (int index = 0; index < str.length(); index++) {
            stack.push(str.charAt(index));
        }
        if (stack.isEmpty()) {
            return null;
        }

        for (int i = 0; i < str.length(); i++) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
