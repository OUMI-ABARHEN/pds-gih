package ma.uiass.eia.pds.backend.Entite;


import java.util.Random;

public class GenerateCode {
    public static String generateCodeLit() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "LI" + codeNumber;
        return code;
    }
    public static String generateCodeEspace() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "Es" + codeNumber;
        return code;
    }
    public static String generateCodeService() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "S" + codeNumber;
        return code;
    }
    public static String generateCodeJob() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "J" + codeNumber;
        return code;
    }
    public static String generateCodeSejour() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "SJ" + codeNumber;
        return code;
    }
    public static String generateCodeDemande() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "D" + codeNumber;
        return code;
    }
    public static String generateCodeDetail() {
        Random random = new Random();
        int codeNumber = random.nextInt(900) + 100; // Generate a random 3-digit number between 100 and 999
        String code = "DD" + codeNumber;
        return code;
    }
}

