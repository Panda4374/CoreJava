public class Cryptography {
    /* The characters which the monoalphabetic cipher will use, can be any character set */
    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char[] cipherAlphabet = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G',
                                            'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    /* Easiest form of encryption */
    static String reverseCipher(String message){
        String translated = "";
        int i = message.length() - 1;
        while (i>=0){
            translated += message.charAt(i);
            i--;
        }
        return translated;
    }

    /* Tougher form of encryption */
    static String caesarCipher(String message, int amt){
        String result = "";
        for (int i=0;i<message.length();i++){
            char c = message.charAt(i);
            result += (char)(((int) c+amt-97)%26+97);
        }
        return result;
    }

    /* Just like the Caesar cipher, except 13 positions down */
    static String ROT13(String message){
        String result = "";
        for (int i=0;i<message.length();i++){
            char c = message.charAt(i);
            result += (char)(((int) c+13-97)%26+97);
        }
        return result;
    }

    /* One of the strongest encryption methods */
    static String xORProcess(String message, char key){
        int len = message.length();
        String r = "";
        for (int i=0;i<len;i++){
            message = message.substring(0, i) + (char)(((int)message.charAt(i))^(int) key) + message.substring(i+1);
            r = r+message.charAt(i);
        }
        return r;
    }

    /* The strongest encryption method, only people with the key are able to decrypt the message */
    static String monoalphabeticCipher(String message){
        char[] c = new char[message.length()];
        for (int i=0;i<message.length();i++){
            for (int j=0;j<26;j++){
                if (alphabet[j] == message.charAt(i)){
                    c[i] = cipherAlphabet[j];
                    break;
                }
            }
        }
        return new String(c);
    }

    /* Method for decrypting a message encrypted in monoalphabetic cipher */
    static String decryptMonoalphabeticCipher(String s){
        char[] p1 = new char[s.length()];
        for (int i=0;i<s.length();i++){
            for (int j=0;j<26;j++){
                if (cipherAlphabet[j] == s.charAt(i)){
                    p1[i] = alphabet[j];
                    break;
                }
            }
        }
        return new String(p1);
    }
}
