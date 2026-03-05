public class Calculator {
    public static int calculate(String expression) {
        ArrayStack stack = new ArrayStack();
        String[] symbols = expression.split("\\s+");

        for (String symbol : symbols) {
            if (isOperator(symbol)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Недостаточно для операции");
                }
                int b = stack.remove();
                int a = stack.remove();
                int result = applyOperator(symbol, a, b);
                stack.add(result);
            }
            else{
                stack.add(Integer.valueOf(symbol));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Не могло остаться больше одного элемента");
        }
        return stack.remove();
    }

    private static boolean isOperator(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
    }

    private static int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}