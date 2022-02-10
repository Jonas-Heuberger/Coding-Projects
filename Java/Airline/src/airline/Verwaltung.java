package airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Verwaltung implements Serializable {

private List<Passagier> passagierList = new ArrayList<>();
private List<CrewMember> crewMemberList = new ArrayList<>();


    private static int abfrageINT(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    private static String abfrageString(){
        Scanner scanner = new Scanner(System.in);
        String  txt = scanner.next();
        return txt;
    }

    private static double abfrageDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        return num;
    }

}
