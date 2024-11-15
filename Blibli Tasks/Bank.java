
class Bank {
    protected double transactionCharges; 

    public Bank() {
        this.transactionCharges = 10.0; 
    }

    public double getTransactionCharges() {
        return this.transactionCharges;
    }

    public void displayTransactionCharges() {
        System.out.println("Transaction charges (Base Bank): " + this.transactionCharges);
    }
}

class ICICI extends Bank {
    
    public ICICI() {
        this.transactionCharges = this.transactionCharges + (this.transactionCharges * 0.15);
    }

    @Override
    public void displayTransactionCharges() {
        System.out.println("Transaction charges (ICICI): " + this.transactionCharges);
    }
}

class HDFC extends Bank {
    
    public HDFC() {
        this.transactionCharges = this.transactionCharges + (this.transactionCharges * 0.10);
    }

    @Override
    public void displayTransactionCharges() {
        System.out.println("Transaction charges (HDFC): " + this.transactionCharges);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.displayTransactionCharges(); 

        ICICI icici = new ICICI();
        icici.displayTransactionCharges(); 

        HDFC hdfc = new HDFC();
        hdfc.displayTransactionCharges(); 
    }
}
