package labSession3;
import java.util.Scanner;
import java.util.Stack;
public class BalancingBrackets {
 
	static boolean CheckingBarcketsForBalancing(String bracketExpression)
	{
		Stack <Character> stack = new Stack<Character>();
for (int i=0; i<bracketExpression.length(); i++)
		{
			char character = bracketExpression.charAt(i);
			if (character == '('|| character =='['|| character == '{')
			{
				stack.push(character);
				continue;
			}
			if(stack.isEmpty())
			return false;
			
			char c ;
			switch (character) {
			
			case '}':
				c= stack.pop();
				if(c=='('|| c=='[')
					return false;
				break;
				
			case ')':
				c= stack.pop();
				if(c=='{'|| c=='[')
					return false;
				break;
				
			case ']':
				c= stack.pop();
				if(c=='('|| c=='{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}
public static void main (String[] args) {
	String bracketExpression;
	Scanner sc= new Scanner (System.in);
	System.out.println("Please Enter Braket Expression to Find Balanace ");
	bracketExpression = sc.nextLine();
	Boolean result;
	result = CheckingBarcketsForBalancing(bracketExpression);
	if(result)
		System.out.println(" The entered baracket expression  has balanced Brackets");
	else
	
		System.out.println(" The entered baracket expression   NOT  balanced");
       sc.close();
}

}
