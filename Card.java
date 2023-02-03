package unogame;

public class Card {
	private String color; 
	private String type; 
	private String modifier; 
	private String name; 
	public Card (String nameIn, String colorIn, String typeIn, String modifierIn) {
		name = nameIn; 
		color = colorIn;
		type = typeIn;
		modifier = modifierIn;
	}
	
	public String getName() {
		return name; 
	}
	
	public String getColor() {
		return color; 
	}
	
	public String getType() {
		return type; 
	}
	
	public String getModifier() {
		return modifier; 
	}
}
