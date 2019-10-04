package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount customer1 = new BankAccount(9999, 00.00, "Robert McBob", "rmcbob@gmail.com", "7342057953");

        customer1.depositFunds(100);
        customer1.depositFunds(50);
        customer1.withdrawFunds(75);
        customer1.withdrawFunds(200);

        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        VipPerson person2 = new VipPerson("Bob McRob", 25000.00d);
        System.out.println(person2.getName());

        VipPerson person3 = new VipPerson("Tim McMothy", 10000.00d, "tim.mcmothy@unknown.com");
        System.out.println(person3.getName());
    }
}
