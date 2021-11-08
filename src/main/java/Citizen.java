import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Citizen {
    private String name;
    private int passportNumber;
    private long inn;
    private int yearBirth;
    private int district;
    private boolean military;
    private boolean quarantine;
    private boolean readyToVote;
    private int consToVote;
    private String consignmentName;
    private int rate;

    public Citizen(String name, int passportNumber, long inn, int yearBirth, int district, boolean military, boolean quarantine, boolean readyToVote, int consToVote, String consignmentName, int rate) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.inn = inn;
        this.yearBirth = yearBirth;
        this.district = district;
        this.military = military;
        this.quarantine = quarantine;
        this.readyToVote = readyToVote;
        this.consToVote = consToVote;
        this.consignmentName = consignmentName;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public long getInn() {
        return inn;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public int getDistrict() {
        return district;
    }

    public boolean isMilitary() {
        return military;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public boolean isReadyToVote() {
        return readyToVote;
    }

    public int getConsToVote() {
        return consToVote;
    }

    public String getConsignmentName() {
        return consignmentName;
    }

    public int getRate() {
        return rate;
    }


    public static List<Citizen> getCitizens() {
        List<Citizen> citizens = new ArrayList<>();
        try
            (BufferedReader reader = new BufferedReader(new FileReader("citizens.txt"))){

                String line = reader.readLine();
                while (reader.ready()) {


                    String[] subStr;
                    subStr = line.split("\\s");

                    citizens.add(new Citizen(subStr[0], Integer.parseInt(subStr[1]), Long.parseLong(subStr[2]), Integer.parseInt(subStr[3]), Integer.parseInt(subStr[4]), Boolean.parseBoolean(subStr[5]), Boolean.parseBoolean(subStr[6]),  Boolean.parseBoolean(subStr[7]), Integer.parseInt(subStr[8]), subStr[9], Integer.parseInt(subStr[10])));

                }
                }catch(IOException e){
            e.printStackTrace();

            }

        return citizens;
    }


    public  static List<Citizen> getVoters(int electionYear) throws Exception {
        List<Citizen> voters = new ArrayList<>();
        for (Citizen citizen: getCitizens()             ) {
            if ((electionYear - citizen.getYearBirth())>= 18){
                voters.add(citizen);
            } else {
                throw new Exception("Возраст меньше 18, нет права голоса");
            }
        }
        return voters;
    }

    public static List<Citizen> getCandidates(int electionYear) throws Exception {
        List<Citizen> candidates = new ArrayList<>();
        for (Citizen citizen:getVoters(electionYear)){
            if (citizen.consignmentName != null){
                candidates.add(citizen);
            }
        }
        return candidates;
    }
}









