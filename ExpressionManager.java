//I am Osama Hussein Dawood
import java.util.*;
class ExpressionManager {
   
    public List<Token> infixToPostfix(List<Token> list){
    	ArrayList<Token> postfix = new ArrayList<Token>();
    	Stack<Operator> stack = new Stack<Operator>();
    	while(!list.isEmpty()) {
			boolean flag = false;
    		Token x = list.get(0);
			list.remove(0);
    		if(x.isNumber() == true) {
    			postfix.add(x);
    		}
    		else if(x.isOperator() == true) {
    			Operator token = (Operator) x;
    			String t = x.toString();
    			//Dealing with parenthesis
    			if(t.equals(")")) {
    				throw new ArithmeticException("Mismatched Parentheses"); //Handling errors
    			}
    			if(t.equals("(")) {
    				stack.push(token);
    				while(flag!= true) {
    					try {
    					x = list.get(0);
        				list.remove(0);
    					}
    					catch(IndexOutOfBoundsException e) {
    						throw new ArithmeticException("Your expression is not correct");
    					}
        				if(x.isNumber() == true) {
        	    			postfix.add(x);
        	    		}
        				else if(x.isOperator() == true) {
        					token = (Operator) x;
        	    			t = x.toString();
        	    			if(t.equals("(")) {
        	    				throw new ArithmeticException("Mismatched Parentheses"); // Handling errors
        	    			}
        	    			if(t.equals(")")) {
        	    				String comp = stack.peek().toString();
        	    				while(!comp.equals("(")) {
        	    					postfix.add(stack.pop());
        	    					comp = stack.peek().toString();
        	    				}
        	    				stack.pop();
        	    				flag = true;
        	    			}
        	    			else {
        	    				stack.push(token);
        	    			}
        				}
    				}	
    				continue;
    			}
    			//Check whether there is an element in the stack or not
    			else if(!stack.isEmpty()) {
    				Operator c = stack.peek();
    				if(c.getPriority() >= token.getPriority()) {
        				postfix.add(stack.pop());
        			}
    			}
    			stack.push(token);
    		}
    	}
    	while(!stack.isEmpty()) {
    		postfix.add(stack.pop());
    	}
	    return postfix;
    }
    	
    public Expression buildExpression(List<Token> postfixList){
    	Stack<Expression> stack = new Stack<Expression>();
    	while(!postfixList.isEmpty()) {
    		Token x = postfixList.get(0);
    		postfixList.remove(0);
    		if(x.isNumber()) {
    			Number token = (Number) x;
    			stack.push(token);
    		}
    		try {
    		if(x.isOperator()) {
    			Operator token = (Operator) x;
    			Expression operand2 = stack.pop();
    			Expression operand1 = stack.pop();
    			BinaryExpression e1 = new BinaryExpression(token, operand1, operand2);
    			stack.push(e1);
    		}
    		}
    		catch(EmptyStackException e) {
    			throw new ArithmeticException("Missing operand"); 
    		}
    		catch(Exception e) {
    			throw new ArithmeticException("An exception happened, but we caught it don't worry"); 
    		}
    	}
    	try {
	return stack.pop();
    	}
    	catch(EmptyStackException e) {
			throw new ArithmeticException("Empty Stack"); 
		}
    }
}