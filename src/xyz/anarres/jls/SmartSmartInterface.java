package xyz.anarres.jls;
/**
 * @author anarres
 *
 */
public interface SmartSmartInterface {
	default void veryKnowledgeableMethod() {
		System.out.println("Look at me, an interface method implementation! I'm called extension method.");
	}
	
	default String anotherFancyMessage() {
		return "I'm a second default interface method cuz why not.";
	}
	
	static void methodWithNoDefaultKeyword() {
		System.out.println("Static implementation doesn't need \"default\" keyword, y'know.");
	}
	
	public static void main(String[] args) {
		// extension method is an instance method
		SmartSmartInterface something = new SmartSmartInterface() {
				// anonymous class on the fly, there was no abstract method to override
		};
		something.veryKnowledgeableMethod();
		System.out.println(something.anotherFancyMessage());
		SmartSmartInterface.methodWithNoDefaultKeyword();
	}
}
