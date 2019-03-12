import org.junit.Assert;
import org.junit.Test;

/**
 * lab 7 test
 * 
 * @author Hana Stevenson
 * @version 2019-03-11
 */
public class PatientTests
{

    // tests of patient classes

    /**
     * test for Animal class
     */
    @Test
    public void AnimalTest()
    {
        Animal animal1 = new Animal("dog", 10);
        Assert.assertEquals("Animal breed incorrect.", "dog", animal1.getBreed());
        Assert.assertEquals("Animal age incorrect.", 10, animal1.getAge());
        Assert.assertEquals("Animal toString incorrect.", "A 10-year old dog.", animal1.toString());

        Animal animal2 = new Animal("cat", 9);
        Assert.assertEquals("Animal age incorrect.", -1, animal1.compareTo(animal2));
        Assert.assertEquals("Animal age incorrect.", 1, animal2.compareTo(animal1));

        Animal animal3 = new Animal("cat", 10);
        Assert.assertEquals("Animal age incorrect.", 0, animal3.compareTo(animal1));
    }

    /**
     * test for HealthyPerson class
     */
    @Test
    public void HealthyPersonTest()
    {
        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        Assert.assertEquals("HealthyPerson name incorrect.", "Caelyn", hPerson1.getName());
        Assert.assertEquals("HealthyPerson age incorrect.", 12, hPerson1.getAge());
        Assert.assertEquals("HealthyPerson toString incorrect.", "Caelyn, a 12-year old. In for check-up",
                hPerson1.toString());

        HealthyPerson hPerson2 = new HealthyPerson("Elyse", 17, "vaccines");
        Assert.assertEquals("HealthyPerson compareTo incorrect.", -2, hPerson1.compareToImpl(hPerson2));
        Assert.assertEquals("HealthyPerson compareTo incorrect.", 2, hPerson2.compareToImpl(hPerson1));

        SickPerson sPerson1 = new SickPerson("Crystal", 20, 4);
        Assert.assertEquals("HealthyPerson age incorrect.", 0, hPerson1.compareToImpl(sPerson1));
    }

    /**
     * test for SickPerson class
     */
    @Test
    public void SickPersonTest()
    {
        SickPerson sPerson1 = new SickPerson("Hannah", 13, 4);
        Assert.assertEquals("SickPerson name incorrect.", "Hannah", sPerson1.getName());
        Assert.assertEquals("SickPerson age incorrect.", 13, sPerson1.getAge());
        Assert.assertEquals("SickPerson toString incorrect.", "Hannah, a 13-year old. Severity level 4",
                sPerson1.toString());

        SickPerson sPerson2 = new SickPerson("Crystal", 20, 7);
        Assert.assertEquals("SickPerson compareTo incorrect.", 5, sPerson1.compareToImpl(sPerson2));
        Assert.assertEquals("SickPerson compareTo incorrect.", -5, sPerson2.compareToImpl(sPerson1));
        Assert.assertEquals("SickPerson compareTo incorrect.", 0, sPerson2.compareToImpl(sPerson2));
      
        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        Assert.assertEquals("SickPerson compareTo incorrect.", 0, sPerson1.compareToImpl(hPerson1));
    }

    /**
     * test for Hospital class
     */
    @Test
    public void StackHospitalTest()
    {
        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        HealthyPerson hPerson2 = new HealthyPerson("Elyse", 17, "vaccines");
        SickPerson sPerson1 = new SickPerson("Hannah", 13, 4);

        StackHospital<Person> stHos = new StackHospital<Person>();
        stHos.addPatient(hPerson1);
        stHos.addPatient(hPerson2);
        stHos.addPatient(sPerson1);

        Assert.assertEquals("StackHospital nextPatient incorrect.", sPerson1, stHos.nextPatient());
        Assert.assertEquals("StackHospital numPatients incorrect.", 3, stHos.numPatients());
        Assert.assertEquals("StackHospital treatNextPatient incorrect.", sPerson1, stHos.treatNextPatient());
        Assert.assertEquals("StackHospital HospitalType incorrect.", "StackHospital", stHos.hospitalType());
        Assert.assertEquals("StackHospital allPatentInfo incorrect.", hPerson1.toString() + hPerson2.toString(),
                stHos.allPatientInfo());
        Assert.assertEquals("StackHospital toString incorrect", "A StackHospital-type hospital with 2 patients.",
                stHos.toString());
    }

    /**
     * test for QueueHospital class
     */
    @Test
    public void QueueHospitlTest()
    {
        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        HealthyPerson hPerson2 = new HealthyPerson("Elyse", 17, "vaccines");
        SickPerson sPerson1 = new SickPerson("Hannah", 13, 4);

        QueueHospital<Person> quHos = new QueueHospital<Person>();
        quHos.addPatient(hPerson1);
        quHos.addPatient(hPerson2);
        quHos.addPatient(sPerson1);

        Assert.assertEquals("QueueHospital nextPatient incorrect.", hPerson1, quHos.nextPatient());
        Assert.assertEquals("QueueHospital numPatients incorrect.", 3, quHos.numPatients());
        Assert.assertEquals("QueueHospital treatNextPatient incorrect.", hPerson1, quHos.treatNextPatient());
        Assert.assertEquals("QueueHospital HospitalType incorrect.", "QueueHospital", quHos.hospitalType());
        Assert.assertEquals("QueueHospital allPatientInfo incorrect.", hPerson2.toString() + sPerson1.toString(),
                quHos.allPatientInfo());
        Assert.assertEquals("QueueHospital toString incorrect", "A QueueHospital-type hospital with 2 patients.",
                quHos.toString());
    }

    /**
     * test for PriorityQueueHospital class
     */
    @Test
    public void PriorityQueueHospitlTest()
    {
        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        SickPerson sPerson1 = new SickPerson("Hannah", 13, 4);
        SickPerson sPerson2 = new SickPerson("Kelsie", 15, 6);

        PriorityQueueHospital<Person> prHos = new PriorityQueueHospital<Person>();
        prHos.addPatient(sPerson1);
        prHos.addPatient(sPerson2);
        prHos.addPatient(hPerson1);

        Assert.assertEquals("PriorityQueueHospital nextPatient incorrect.", sPerson2, prHos.nextPatient());
        Assert.assertEquals("PriorityQueueHospital numPatients incorrect.", 3, prHos.numPatients());
        Assert.assertEquals("PriorityQueueHospital treatNextPatient incorrect.", sPerson2, prHos.treatNextPatient());
        Assert.assertEquals("PriorityQueueHospital HospitalType incorrect.", "PriorityQueueHospital",
                prHos.hospitalType());
        Assert.assertEquals("PriorityQueueHospital allPatientInfo incorrect.",
                hPerson1.toString() + sPerson1.toString(), prHos.allPatientInfo());
        Assert.assertEquals("PriorityQueueHospital toString incorrect",
                "A PriorityQueueHospital-type hospital with 2 patients.", prHos.toString());
    }
}
