package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bill implements Serializable {
	
	
	private Integer id;
	private String date_bill;
	private User user_id;
	private Integer value;
	private Integer type;
	private String observation;
	
	
	public Bill(String date_bill, User user_id, Integer value, Integer type, String observation) {
		super();
		this.date_bill = date_bill;
		this.user_id = user_id;
		this.value = value;
		this.type = type;
		this.observation = observation;
	}

	
	
	
	
}
