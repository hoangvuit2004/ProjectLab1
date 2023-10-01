public class MyCaesar {
    public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private int n;// shift steps (right shift)
    public MyCaesar(int shiftSteps) {

        this.n = shiftSteps;
    }
    public char encryptChar(char c) {
        int stepChar = 0;
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            int step = (int) c - (int) base;
            stepChar = (step + this.n) % 26;
            if (stepChar < 0) {
                stepChar += 26;
            }
            char encryptedChar = (char) (base + stepChar);
            return encryptedChar;

        }else{
            return c;
        }
    }
    public static void main(String[] args) {
        MyCaesar cs = new MyCaesar(3);
        System.out.println(cs.encryptChar('A'));
        System.out.println(cs.encrypt("Hello, World!"));
        System.out.println(cs.decryptChar('K'));
        System.out.println(cs.decrypt("Khoor, Zruog!"));
    }
    public String encrypt(String input) {

        char arrayChar[] = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                arrayChar[i] = encryptChar(currentChar);
            } else {
                arrayChar[i] = currentChar;
            }
        }
        System.out.println((int)'K');
        String temp = "";
        for (char a:
                arrayChar) {
            temp+=a;
        }
        return temp;
    }
    public char decryptChar(char c) {
        if(Character.isLetter(c)){
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            int ap = 26;
            int step = (int)c - (int)base;
            int stepChar = (step - n)%26;
            char returnChar = (char)(base +stepChar);
            return returnChar;
        }else{
            return c;
        }
    }
    public String decrypt(String input) {
        char arrayChar[] = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                arrayChar[i] = decryptChar(currentChar);
            } else {
                arrayChar[i] = currentChar;
            }
        }
        String temp = "";
        for (char a:
                arrayChar) {
            temp+=a;
        }
        return temp;
    }
}
