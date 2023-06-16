package com.gmail.renanfr1047.math;

public class TelevisionInstallments {

	int rawInterest;

	public static void main(String[] args) {
		new TelevisionInstallments().run();
	}

	public void run() {

		int inCashPrice = 1350;
		int installments = 12;
		int installmentValue = 138;
		int priceWithInterest = installments * installmentValue;
		rawInterest = priceWithInterest - inCashPrice;
		log("Interest charged was: " + rawInterest);

	}

	public void log(String message) {
		System.out.println(message);
	}

}
