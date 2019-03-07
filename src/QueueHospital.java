import java.util.Queue;

public class QueueHospital<PatientType> extends Hospital <PatientType>
{

    private Queue<PatientType> waitList;
    
    // constructor to initialize waitList
    public QueueHospital() 
    {
       // waitList = new Queue<PatientType>();
        
    }
    @Override
    public void addPatient(PatientType patient)
    {
        
    }

    @Override
    public PatientType nextPatient()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PatientType treatNextPatient()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int numPatients()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String hospitalType()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String allPatientInfo()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
