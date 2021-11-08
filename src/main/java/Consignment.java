import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consignment {
    private String consName;
    private String fraction;
    private int dateOfFoundation;
    private List<Citizen> candidates;

    public Consignment(String consName, String fraction, int dateOfFoundation, List<Citizen> candidates) {
        this.consName = consName;
        this.fraction = fraction;
        this.dateOfFoundation = dateOfFoundation;
        this.candidates = candidates;
    }

    public Consignment(String consName, String fraction, int dateOfFoundation) {
    }

    public String getConsName() {
        return consName;
    }

    public String getFraction() {
        return fraction;
    }

    public int getDateOfFoundation() {
        return dateOfFoundation;
    }

    public List<Citizen> getCandidates() {
        return candidates;
    }

    public static List<Consignment> getConsignments() {
        List<Consignment> consignments = new ArrayList<>();
        try
                (BufferedReader reader = new BufferedReader(new FileReader("consignments.txt"))){

            String line = reader.readLine();
            while (reader.ready()) {


                String[] subStr;
                subStr = line.split("\\s");

                consignments.add(new Consignment(subStr[0], subStr[1], Integer.parseInt(subStr[2])));

            }
        }catch(IOException e){
            e.printStackTrace();

        }
        for(Consignment consignment:getConsignments()){
            for(Citizen citizen:Citizen.getCitizens()){
                if (citizen.getConsignmentName().equals(consignment.getConsName())){
                    consignment.getCandidates().add(citizen);
                }
            }
        }

        return consignments;
    }


}
