package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        TempInDou(0.001,0.991,1.998);
        long end = System.currentTimeMillis();

        System.out.println("------------------------------------------------------------------------------------------------------------");
        start = System.currentTimeMillis();
        TempInBig(new BigDecimal(0.001) ,new BigDecimal(0.991) , new BigDecimal(1.998) );
        end = System.currentTimeMillis();

    }



    private static void TempInDou(Double insu,Double at,Double ot) {
        System.out.println(insu);
        System.out.println(at);
        System.out.println(ot);
        Double  st = at + 1;
        System.out.println(st);
        Double diff = 1.0 ;
        System.out.println(diff);
        while(diff > 0.5) {
            System.out.println("HI");
            Double mt = (st + ot)/2;
            System.out.println(mt);
            Double Airt = st - at;
            System.out.println(Airt);
            Double Ei = (0.000006 * (Math.pow(Airt,2)) + 0.0036 * Airt + 1.89 );
            System.out.println(Ei);
            Double Rai = 1 / Ei;
            System.out.println(Rai);
            Double Ki = 0.2761 * 0.0012 * mt;
            System.out.println(Ki);
            Double Ri = insu / Ki;
            System.out.println(Ri);
            Double Cwatts = (ot - at) / (Ri + Rai);
            System.out.println(Cwatts);
            Double CSurface = Cwatts * Rai + at;
            System.out.println(CSurface);
            diff = Math.abs(CSurface - st);
            System.out.println(diff);
            st = CSurface;
            System.out.println(st);
        }
        System.out.println("Value of ST for Double"+ st);

    }

    private static void TempInBig(BigDecimal insu, BigDecimal at, BigDecimal ot) {
        System.out.println(insu);
        System.out.println(at);
        System.out.println(ot);
        BigDecimal st = at.add(new BigDecimal(1));
        System.out.println(st);
        BigDecimal diff = new BigDecimal(1.0);
        System.out.println(diff);
        while(diff.compareTo(new BigDecimal(0.5)) == 1 ) {
            System.out.println("BTYE");

            BigDecimal mt = (st.add(ot)).divide(new BigDecimal(2), RoundingMode.HALF_DOWN);
            System.out.println(mt);
            BigDecimal Airt = st.subtract(at);
            System.out.println(Airt);
            BigDecimal Ei = (new BigDecimal(0.000006).multiply(Airt.pow(2)).add(new BigDecimal(0.0036)).multiply(Airt).add(new BigDecimal( 1.89)));
            System.out.println(Ei);
            BigDecimal Rai = new BigDecimal(1).divide(Ei, RoundingMode.HALF_UP);
            System.out.println(Rai);
            BigDecimal Ki = new BigDecimal(0.2761).multiply(new BigDecimal(0.0012) ).multiply( mt);
            System.out.println(Ki);
            BigDecimal Ri = insu.divide( Ki, RoundingMode.HALF_UP);
            System.out.println(Ri);
            BigDecimal Cwatts = (ot.subtract(at)).divide(Ri.add(Rai), RoundingMode.HALF_UP);
            System.out.println(Cwatts);
            BigDecimal CSurface = Cwatts.multiply(Rai).add(at);
            System.out.println(CSurface);
            diff = (CSurface.subtract(st));
            diff = diff.abs();
            System.out.println(diff);
            st = CSurface;
            System.out.println(st);
        }
        System.out.println("Value of ST for Big Decimal "+ st);

    }
}
