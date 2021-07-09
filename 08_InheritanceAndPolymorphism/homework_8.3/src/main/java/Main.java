public class Main {

    public static void main(String[] args) {
        IndividualBusinessman individualBusinessman = new IndividualBusinessman();
        individualBusinessman.put(500.0);
        individualBusinessman.getAmount();
        individualBusinessman.put(1000.0);
        individualBusinessman.getAmount();
        individualBusinessman.take(496.0);
        individualBusinessman.getAmount();

        LegalPerson legalPerson = new LegalPerson();
        legalPerson.put(1.0);
        legalPerson.getAmount();
        legalPerson.take(0.5);
        legalPerson.getAmount();

        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.put(2.0);
        physicalPerson.getAmount();
        physicalPerson.take(1.0);
        physicalPerson.getAmount();

    }

}
