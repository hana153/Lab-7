import java.util.Stack;

/**
 * 
 * @author Hana Stevenson
 *
 * @param <PatientType>
 */
public class StackHospital<PatientType> extends Hospital<PatientType>
{

    private Stack<PatientType> waitList;

    public StackHospital()
    {
        waitList = new Stack<PatientType>();
    }

    @Override
    public void addPatient(PatientType patient)
    {
        waitList.push(patient);
    }

    @Override
    public PatientType nextPatient()
    {
        return waitList.peek();
    }

    @Override
    public PatientType treatNextPatient()
    {
        return waitList.pop();
    }

    @Override
    public int numPatients()
    {
        return waitList.size();
    }

    @Override
    public String hospitalType()
    {
        return "StackHospital";
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
