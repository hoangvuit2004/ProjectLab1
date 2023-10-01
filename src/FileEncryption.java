import java.io.*;

public class FileEncryption {
    public void encrypt(String srcFile, String desFile, int shift) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(srcFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(desFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encryptLine(line, shift);
                writer.write(encryptedLine);
                writer.newLine(); // Add a newline character to separate lines
            }
        }
    }

    private String encryptLine(String line, int shift) {
        StringBuilder encryptedLine = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);

            if (Character.isLetter(character)) {
                char shiftedChar = (char) (Character.toUpperCase(character) + shift);

                if (shiftedChar > 'Z') {
                    shiftedChar = (char) (shiftedChar - 'Z' + 'A' - 1);
                }

                encryptedLine.append(shiftedChar);
            } else {
                // Keep non-letter characters unchanged
                encryptedLine.append(character);
            }
        }

        return encryptedLine.toString();
    }

    public static void main(String[] args) {
        FileEncryption fileEncryption = new FileEncryption();
        int shift = 3; // Set your desired shift value

        try {
            fileEncryption.encrypt("", "encrypted.txt", shift);
            System.out.println("Encryption completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
