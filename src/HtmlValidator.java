import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		
		Stack<HtmlTag> matches = new Stack<HtmlTag>();
		
		while(!tags.isEmpty()) {
			HtmlTag thisTag = tags.remove();
			if (thisTag.isSelfClosing()) {
				// do nothing
			} else if (thisTag.isOpenTag()) {
				// add to stack
				matches.push(thisTag);
			} else {
				// closing tag
				// check for match
				if (matches.isEmpty())
					return null;
				HtmlTag matchTag = matches.peek();
				if (thisTag.matches(matchTag)) {
					// remove matching tag from stack
					matches.pop();
				} else {
					// tags do not match
					// return stack
					return matches;
				}
			}
		}
		
		return matches;

	}
	

}

