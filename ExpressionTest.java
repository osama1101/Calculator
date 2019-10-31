//I am Osama Hussein Dawood
import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void test() {
		Expression e1 = new Number(46);
		assertEquals("46", 46, e1.valueOf());
		Expression e2 = new BinaryExpression(new Operator("/"), new Number(120), new Number(7));
		assertEquals("e2", 17, e2.valueOf());
		Expression e3 = new BinaryExpression(new Operator("-"), new Number(50), new Number(15));
		assertEquals("e3", 35, e3.valueOf());
		Expression e4 = new BinaryExpression(new Operator("*"), e2, e3);
		assertEquals("e4", 595, e4.valueOf());
		Expression e5 = new BinaryExpression(new Operator("+"), e1, e2);
		assertEquals("e5", 63, e5.valueOf());
		Expression e6 = new BinaryExpression(new Operator("+"), new Number(16), new Number(20));
		assertEquals("e6", "+ 16 20", e6.toPrefix());
		Expression e7 = new BinaryExpression(new Operator("*"), new Number(2), new Number(3));
		assertEquals("e7", "2 3 *", e7.toPostfix());
		Expression e8 = new BinaryExpression(new Operator("*"), new Number(2), new Number(3));
		assertEquals("e8", "( 2 * 3 )", e8.toInfix());
		Expression e9 = new BinaryExpression(new Operator("*"), new Number(2), new Number(3));
		assertEquals("e9", "( 2 * 3 )", e9.toString());
	}

}
