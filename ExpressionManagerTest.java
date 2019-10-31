//I am Osama Hussein Dawood
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
public class ExpressionManagerTest {

	@Test
	public void infixToPostfixTest() {
		ArrayList<Token> list = new ArrayList<Token>(); 
		ExpressionManager expressionManager = new ExpressionManager();
		list.add(new Number(2));
		list.add(new Operator("*"));
		list.add(new Number(3));
		list.add(new Operator("+"));
		list.add(new Number(4));
		list.add(new Operator("*"));
		list.add(new Number(5));
		System.out.println(list); // TESTING
		List<Token> postfix  = expressionManager.infixToPostfix(list);
		Expression e1 = expressionManager.buildExpression(postfix);
		assertEquals("infixToPostfix Test 1", 26, e1.valueOf());
		//TESTING WITH PARENTHESIS
		list.clear();
		list.add(new Number(2));
		list.add(new Operator("*"));
		list.add(new Operator("("));
		list.add(new Number(3));
		list.add(new Operator("+"));
		list.add(new Number(4));
		list.add(new Operator(")"));
		list.add(new Operator("*"));
		list.add(new Number(5));
		List<Token> postfix2  = expressionManager.infixToPostfix(list);
		Expression e2 = expressionManager.buildExpression(postfix2);
		System.out.println(e2.valueOf()); // TESTING
		assertEquals("infixToPostfix Test 1", 70, e2.valueOf());
		
		//Testing for power"^"
		list.clear();
		list.add(new Number(3));
		list.add(new Operator("^"));
		list.add(new Number(3));
		//System.out.println(list); // TESTING
		List<Token> postfix1  = expressionManager.infixToPostfix(list);
		Expression e3 = expressionManager.buildExpression(postfix1);
		assertEquals("infixToPostfix Test 1", 27, e3.valueOf());
	} 
	
	@Test
	public void buildExpressionTest() {
		ExpressionManager expressionManager = new ExpressionManager();
		ArrayList<Token> postfix = new ArrayList<Token>();
		postfix.add(new Number(37));
		Expression e1 = expressionManager.buildExpression(postfix);
		assertEquals("build test 1", 37, e1.valueOf());
		postfix.clear();
		postfix.add(new Number(20));
		postfix.add(new Number(13));
		postfix.add(new Operator("*"));
		Expression e2 = expressionManager.buildExpression(postfix);
		assertEquals("build test 2", 260, e2.valueOf());
		assertEquals("build test 3", "( 20 * 13 )", e2.toString());
		assertEquals("build test 4","* 20 13" , e2.toPrefix());
		assertEquals("build test 5", "20 13 *", e2.toPostfix());
		postfix.clear();
		postfix.add(new Number(10));
		postfix.add(new Number(2));
		postfix.add(new Operator("/"));
		Expression e3 = expressionManager.buildExpression(postfix);
		assertEquals("build test 6", 5, e3.valueOf());
		postfix.add(new Number(2));
		postfix.add(new Number(10));
		postfix.add(new Operator("/"));
		Expression e4 = expressionManager.buildExpression(postfix);
		assertEquals("build test 7", 0, e4.valueOf());
	}
}
