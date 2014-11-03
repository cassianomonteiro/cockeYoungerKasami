package ct200.cyk.model;

/**
 * Classe que representa uma produção unitária do tipo head -> body.
 * Múltiplas produções devem ser representadas em diferente objetos, de forma
 * que cada objeto represente somente uma produção.
 * @author cassiano
 *
 */
public class Production {
	
	private String head;
	private String body;
	
	/**
	 * @return the head
	 */
	public String getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(String head) {
		this.head = head;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	public Production() {
		super();
	}
	
	public Production(String head, String body) {
		this.head = head;
		this.body = body;
	}

}
