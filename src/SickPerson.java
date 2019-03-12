
public class SickPerson extends Person
{

    private int severity;
    
    public SickPerson(String name, int age, int severity)
    {
        super(name, age);
        this.severity = severity;
    }

    @Override
    protected int compareToImpl(Person p)
    {
        if(p instanceof SickPerson) {
            return (this.getName()).compareTo(p.getName());
        }
        else 
        {
            return 0;
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("%s Severity level %d", getName(), severity);
    }
    

}
