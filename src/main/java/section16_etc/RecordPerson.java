package section16_etc;

public record RecordPerson(String name, String dob) {

//    public RecordPerson(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace('-', '/');
//    }

    public RecordPerson(Person p) {
        this(p.getName(), p.getDob());
    }

    public RecordPerson {
        if (dob == null) throw new IllegalArgumentException("Bad data");
        dob = dob.replace('-', '/');
    }
}
