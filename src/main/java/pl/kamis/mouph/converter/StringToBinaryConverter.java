package pl.kamis.mouph.converter;

public class StringToBinaryConverter {

    public static boolean[] convertTextToBoolean(String token) {
        boolean[] binary = new boolean[token.length()*Byte.SIZE];
        for (int i = 0; i < Byte.SIZE * token.getBytes().length; i++) {
            binary[i] = (token.getBytes()[i / Byte.SIZE] << i % Byte.SIZE & 0x80) != 0;
        }
        return binary;
    }
}
