package com.example.string;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/15
 */
public class BinaryAdd {
    StringBuffer bufferA;
    StringBuffer bufferB;
    StringBuffer stringBuffer;

    public String addBinary(String a, String b) {
        //解决不同 进位置的相加问题,从反转数组从个位开始计数
        stringBuffer = new StringBuffer();
        bufferA = new StringBuffer(a).reverse();
        bufferB = new StringBuffer(b).reverse();

        int length = a.length() > b.length() ? a.length() : b.length();
        int carryNum = 0;
        for (int i = 0; i < length; i++) {
            int temp1, temp2;
            try {
                temp1 = bufferA.charAt(i) - 48;
            } catch (Exception e) {
                temp1 = 0;
            }
            try {
                temp2 = bufferB.charAt(i) - 48;
            } catch (Exception e) {
                temp2 = 0;
            }
            int temp = temp1 + temp2;
            temp += carryNum;
            carryNum = 0;
            if (temp >= 2) {
                carryNum = (temp) / 2;
                stringBuffer.append(temp % 2);
            } else {
                stringBuffer.append(temp);
            }
        }
        if (carryNum != 0) {
            stringBuffer.append(carryNum);
        }
        return stringBuffer.reverse().toString();
    }


}
