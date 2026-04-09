package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldCreateObjectWhenDataIsValid() {
		//arrenge (dados que passam na validacao)
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		
		//act (tenta instanciar)
		Financing f = new Financing(totalAmount, income, months);
		
		// assert
		Assertions.assertEquals(totalAmount, f.getTotalAmount());
		Assertions.assertEquals(income, f.getIncome());
		Assertions.assertEquals(months, f.getMonths());
	}
	
	@Test
	public void constructorShouldThrowsExceptionWhenDataIsInvalid() {
		//assert + act (verifica se excecao eh lancada ao tentar criar)
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Double totalAmount = 100000.0;
			Double income = 2000.0;
			Integer months = 20;
			
			new Financing (totalAmount, income, months);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateWhenDataIsValid() {
		//arrenge valor padrao
		Financing f = FinancingFactory.createFinancing();
		Double expectedValue = 99000.0;// manter ou diminuir nao quebra o financiamento
		
		f.setTotalAmount(expectedValue);
		
		Assertions.assertEquals(expectedValue, f.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowsExceptionWhenDataIsInvalid() {
		//arrenge objeto padrao
		Financing f = FinancingFactory.createFinancing();
		
		//act e assert tenta subir o valor e quebra o financiamento
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setTotalAmount(101000.0);
		});
	}
	
	@Test
	public void setIncomeShouldUpdateWhenDataIsValid() {
		
		Financing f = FinancingFactory.createFinancing();
		Double expectedValue = 3000.0;// aumenta a renda melhor ainda
		
		f.setIncome(expectedValue);
		
		Assertions.assertEquals(expectedValue, f.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowsExceptionWhenDataIsInvalid() {
		
		Financing f = FinancingFactory.createFinancing();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setIncome(1900.0);// se diminuir a renda compromete o financiamento
		});
	}
	
	@Test
	public void setMonthsShouldUpdateWhenDataIsValid() {
		
		Financing f = FinancingFactory.createFinancing();
		Integer expectedValue = 90;// mais meses menor a parcela
		
		f.setMonths(expectedValue);
		
		Assertions.assertEquals(expectedValue, f.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowsExceptionWhenDataIsInvalid() {
		
		Financing f = FinancingFactory.createFinancing();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			f.setMonths(78);// diminui meses aumenta a parcela
		});
	}
	
	@Test
	public void entryShouldCalculatorCorrectly() {
		
		Financing f = FinancingFactory.createFinancing();
		Double expectedValue = 20000.0;// 20 por cento de 100k
		
		Double result = f.entry();
		
		Assertions.assertEquals(expectedValue, result, 0.01);
	}
	
	@Test
	public void quotaShouldValculatorCorrectly() {
		
		Financing f = FinancingFactory.createFinancing();
		Double expectedValue = 1000.0;// 100k - 20 por cento / 80 meses
		
		Double result = f.quota();
		
		Assertions.assertEquals(expectedValue, result, 0.01);
	}
}
