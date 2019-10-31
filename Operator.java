//I am Osama Hussein Dawood
public class Operator implements Token, Expression {

   static final String operators = "+-/*^()";
   
   String operation;
   
   public Operator(String operation){
      this.operation = operation;
   }

   // Apply the operator to two integer operands
   public int apply(int left, int right){
      switch(operation.charAt(0)){
         case '+': return left+right;
         case '-': return left-right;
         case '*': return left*right;
         case '/': return left/right;
         case '^': return (int) Math.pow(left,right);
         default: return 0;
      }
   }
   
   public int getPriority(){
      switch(operation.charAt(0)){
         case '+':
         case '-': return 2;
         case '*':
         case '/': return 3;
         case '^': return 4; // enter the incoming priority of EXPON here
         default: return 0;
      }
   }
      
   public boolean isOperator(){
      return true;
   }
   
   public boolean isNumber(){
      return false;
   }
   
   public String toString(){
      return operation;
   }
   
   public boolean equals(Object obj){
      if(obj instanceof String)
         return obj.equals(toString());
      else
         return obj==this;
   }

@Override
public int valueOf() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String toPrefix() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String toInfix() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String toPostfix() {
	// TODO Auto-generated method stub
	return null;
}
}

