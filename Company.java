import java.util.Date;

// Making Person as abstract class
abstract class Person {
    protected String name;
    protected Date dateOfBirth;

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}

class Candidate extends Person{
    private int[] hscMarks;
    private int pcmAverage;
    private int pcbAverage;
    private double ugCGPA;
    private double pgCGPA;
    private int numOfProjects;
    private boolean isFullTime;
    private int interviewMarks;
    private boolean isIndian;
    private boolean isEligible;
    public Candidate(String name, Date dateOfBirth, int[] hscMarks,
                      double ugCGPA, double pgCGPA, int numOfProjects,
                      boolean isFullTime, int interviewMarks, boolean isIndian) {
        super(name, dateOfBirth);
        this.hscMarks = hscMarks;
        this.ugCGPA = ugCGPA;
        this.pgCGPA = pgCGPA;
        this.numOfProjects = numOfProjects;
        this.isFullTime = isFullTime;
        this.interviewMarks = interviewMarks;
        this.isIndian = isIndian;
        this.isEligible = checkEligibility();
    }
    private void calculatePCMaverage() {
        pcmAverage = (hscMarks[0] + hscMarks[1] + hscMarks[2]) / 3;
    }

    private void calculatePCBaverage() {
        pcbAverage = (hscMarks[0] + hscMarks[1] + hscMarks[3]) / 3;
    }

    private boolean checkEligibility() {
        calculatePCMaverage();
        calculatePCBaverage();
        if (getDateOfBirth().compareTo(new Date(99,6,1)) >= 0
                && pcmAverage >= 60 || pcbAverage >= 60
                && ((pcbAverage+pcmAverage/2) >= 50)
                && ugCGPA >= 8
                && pgCGPA >= 8
                && numOfProjects >= 2
                && isFullTime == true
                && interviewMarks >= 35
                && isIndian == true) {
            return true;
        }
        return false;
    }

    public int getInterviewMarks() {
        return interviewMarks;
    }

    public boolean isEligible() {
        return isEligible;
    }
    // public void displayResult() {
    //     System.out.println("Name: " + getName());
    //     System.out.println("Date of birth: " + getDateOfBirth());
    //     System.out.println("Interview marks: " + interviewMarks);
    //     if (isEligible) {
    //         System.out.println("Congratulations! You are eligible for the job.");
    //     } else {
    //         System.out.println("Sorry! You are not eligible for the job.");
    //     }
    // }
}

class RecruitingTeam{
    public void showResult(Candidate candidate){
        if(candidate.isEligible()){
            System.out.println(candidate.getName()+" Selected");
        }else{
            System.out.println(candidate.getName()+" not selected");
        }
    }
}

public class Company {
    public static void main(String[] args) {
        System.out.println("Welcome to Worldline");
        Candidate c1 = new Candidate("Shreyash",new Date(10,5,2000),
        new int[]{70, 80, 90, 85},9.2,8.5,3,true,15,true);
        Candidate c2 = new Candidate("Kunal", new Date(1999, 8, 20),
        new int[]{50, 60, 70, 65}, 7.5, 8.0, 1, false, 35, true);
        Candidate c3 = new Candidate("Bob", new Date(1998, 4, 5),
        new int[]{80, 90, 95, 90}, 8.8, 9.3, 2, true, 45, false);

        RecruitingTeam rt = new RecruitingTeam();
        rt.showResult(c1);
        rt.showResult(c2);
        rt.showResult(c3);
    }
}
