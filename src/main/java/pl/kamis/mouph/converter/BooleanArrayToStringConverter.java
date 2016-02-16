package pl.kamis.mouph.converter;

public class BooleanArrayToStringConverter {

    public static String convertBooleanArrayToString(boolean[] message) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<message.length; i++) {
            if(message[i]) {
                builder.append("1");
            } else {
                builder.append("0");
            }
            if(i == 127) {
                break;
            }
        }
        return builder.toString();
    }
}
