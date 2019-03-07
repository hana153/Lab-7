import java.util.PriorityQueue;

public class PriorityQueueHospital<PatientType> extends Hospital<PatientType>
{

    private PriorityQueue<PatientType> waitList;
    
    public PriorityQueueHospital()
    {
        waitList = new PriorityQueue<PatientType>();
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
        return "PriorityQueueHospital";
    }

    @Override
    public String allPatientInfo()
    {
        Object[] res = waitList.toArray();
        String result = "";
        for (int i = 0; i < res.length; ++i)
        {
            result += res[i];
        }
        return result;
    }

}
