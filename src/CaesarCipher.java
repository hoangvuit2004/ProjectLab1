public class CaesarCipher {
    public static String encrypt(String input, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (Character.isLetter(character)) {
                char shiftedChar = (char) (Character.toUpperCase(character) + shift);

                if (shiftedChar > 'Z') {
                    shiftedChar = (char) (shiftedChar - 'Z' + 'A' - 1);
                }

                encryptedText.append(shiftedChar);
            } else {
                // Giữ nguyên số và các ký tự đặc biệt
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String input, int shift) {
        return encrypt(input, -shift);
    }

    public static void main(String[] args) {
        String text = "Hello, World! 123 #$%";
        int shift = 3;

        String encryptedText = encrypt(text, shift);
        System.out.println("Encrypted: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted: " + decryptedText);
    }
}
