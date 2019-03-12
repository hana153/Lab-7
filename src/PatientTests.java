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
        Assert.assertEquals("HealthyPerson toString incorrect.", "Caelyn In for check-up", hPerson1.toString());

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
        Assert.assertEquals("SickPerson toString incorrect.", "Hannah Severity level 4", sPerson1.toString());

        SickPerson sPerson2 = new SickPerson("Crystal", 20, 4);
        Assert.assertEquals("SickPerson compareTo incorrect.", 5, sPerson1.compareToImpl(sPerson2));
        Assert.assertEquals("SickPerson compareTo incorrect.", -5, sPerson2.compareToImpl(sPerson1));

        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        Assert.assertEquals("SickPerson compareTo incorrect.", 0, hPerson1.compareToImpl(sPerson1));
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

    }

    /**
     * test for PriorityQueueHospital class
     */
    @Test
    public void PriorityQueueHospitlTest()
    {
        HealthyPerson hPerson1 = new HealthyPerson("Caelyn", 12, "check-up");
        HealthyPerson hPerson2 = new HealthyPerson("Elyse", 17, "vaccines");
        SickPerson sPerson1 = new SickPerson("Hannah", 13, 4);

        PriorityQueueHospital<Person> prHos = new PriorityQueueHospital<Person>();
        prHos.addPatient(hPerson1);
        prHos.addPatient(hPerson2);
        prHos.addPatient(sPerson1);

        Assert.assertEquals("PriorityQueueHospital nextPatient incorrect.", hPerson1, prHos.nextPatient());
        Assert.assertEquals("PriorityQueueHospital numPatients incorrect.", 3, prHos.numPatients());
        Assert.assertEquals("PriorityQueueHospital treatNextPatient incorrect.", hPerson1, prHos.treatNextPatient());
        Assert.assertEquals("PriorityQueueHospital HospitalType incorrect.", "PriorityQueueHospital",
                prHos.hospitalType());
        Assert.assertEquals("PriorityQueueHospital allPatientInfo incorrect.",
                sPerson1.toString() + hPerson2.toString(), prHos.allPatientInfo());
    }
}
