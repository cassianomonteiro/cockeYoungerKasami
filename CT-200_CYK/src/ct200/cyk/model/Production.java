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
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
