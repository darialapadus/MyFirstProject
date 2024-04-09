package lab6.task1;

public class Student {
    String nume;
    double notaLaborator;
    double notaPartial;
    double notaExamen;

    public Student(String nume, double notaLaborator, double notaPartial, double notaExamen) {
        this.nume = nume;
        this.notaLaborator = notaLaborator;
        this.notaPartial = notaPartial;
        this.notaExamen = notaExamen;
    }

    public double getTotalNota() {
        return notaLaborator + notaPartial + notaExamen;
    }

    public double getMedieNota() {
        return (notaLaborator + notaPartial + notaExamen) / 3;
    }

    @Override
    public String toString() {
        return nume + " " + notaLaborator + " " + notaPartial + " " + notaExamen;
    }

    public double getNotaPartial() {
        return notaPartial;
    }
}

