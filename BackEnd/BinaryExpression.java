public class BinaryExpression implements Expression {
	Operator operator;
	Expression leftOperand;
	Expression rightOperand;
	
	BinaryExpression(Operator operator, Expression leftOperand, Expression rightOperand) {
		this.operator = operator;
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	public Operator getOperator() {
		return operator;
	}
	public Expression getLeft() {
		return leftOperand;
	}
	public Expression getRight() {
		return rightOperand;
	}

	public int valueOf() { // QS: Why couldn't I add any parameters here???
		int left = leftOperand.valueOf(); // QS: How is this recursive?
		int right = rightOperand.valueOf(); 
		return operator.apply(left, right);
	}

	public String toPrefix() {
		int left = leftOperand.valueOf();
		int right = rightOperand.valueOf();
		String operator1 = operator.toString();
		return operator1 + " " + left + " " + right;
	}

	public String toInfix() {
		int left = leftOperand.valueOf();
		int right = rightOperand.valueOf();
		String operator1 = operator.toString();
		return "(" + " " + left + " " + operator1 + " " + right + " " + ")";
	}

	public String toPostfix() {
		int left = leftOperand.valueOf();
		int right = rightOperand.valueOf();
		String operator1 = operator.toString();
		return left + " " + right + " " + operator1;
	}
	public String toString() {
		return toInfix();
	}
}