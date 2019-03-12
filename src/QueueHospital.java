import java.util.LinkedList;

public class QueueHospital<PatientType> extends Hospital<PatientType>
{

    private LinkedList<PatientType> waitList;

    // constructor to initialize waitList
    public QueueHospital()
    {
        waitList = new LinkedList<PatientType>();

    }

    @Override
    public void addPatient(PatientType patient)
    {
        waitList.add(patient);
    }

    @Override
    public PatientType nextPatient()
    {
        return waitList.peek();
    }

    @Override
    public PatientType treatNextPatient()
    {
        return waitList.poll();
    }

    @Override
    public int numPatients()
    {
        return waitList.size();
    }

    @Override
    public String hospitalType()
    {
        return "QueueHospital";
    }

    @Override
    public String allPatientInfo()
    {
        String result = "";
        for (int i = 0; i < waitList.size(); ++i)
        {
            result += waitList.get(i);
        }
        return result;
    }

}
