package tests.factory;

import entities.Financing;

public class FinancingFactory {

	// Cenário 1: Você quer um objeto pronto sem se preocupar com valores
    public static Financing createFinancing() {
        return new Financing(100000.0, 2000.0, 80);
    }

    // Cenário 2: Voce quer escolher os valores, mas quer que a Factory centralize o "new"
    public static Financing createCustomFinancing(Double totalAmount, Double income, Integer months) {
        return new Financing(totalAmount, income, months);
    }
}
