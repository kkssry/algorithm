package baekjoon.calendar;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;

public class MessageFormatEx3 {
    public static void main(String[] args) throws ParseException {
        String[] data = {
                "INSERT INTO CUST_INFO VALUES ('이자바','02-123-1234',27,'07-09');",
                "INSERT INTO CUST_INFO VALUES ('김프로','032-333-1234',33,'10-07');",
        };

        String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3})";
        MessageFormat mf = new MessageFormat(pattern);

        for (String data1 : data) {
            Object[] objs = mf.parse(data1);
            System.out.println(Arrays.toString(objs));
        }

    }
}
