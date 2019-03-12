
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
        if (p instanceof SickPerson) {
            int otherSeverity = ((SickPerson) p).severity;
            if (this.severity > otherSeverity)
            {
                return -5;
            } else if (this.severity < otherSeverity)
            {
                return 5;
            } else
            {
                return 0;
            }
        }
        else 
        {
            return 0;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s Severity level %d", super.toString(), severity);
    }

}
