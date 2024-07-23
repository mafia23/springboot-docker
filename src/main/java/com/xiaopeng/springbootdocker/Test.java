package com.xiaopeng.springbootdocker;

/**
 * Test
 *
 * @author yangzhipeng7
 * @version 1.0
 * 2024/7/11 14:43
 **/
public class Test {
    public static void main(String[] args) {
        byte[] binaryNumbers = {
                (byte) 0b10101010, // 第1回路的二进制数
                (byte) 0b01010101, // 第2回路的二进制数
                (byte) 0b11110000, // 第3回路的二进制数
                // 可以继续添加更多的二进制数，每个二进制数占一个字节（8位）
        };

        // 遍历每个二进制数
        for (int circuit = 0; circuit < binaryNumbers.length; circuit++) {
            byte binaryNumber = binaryNumbers[circuit];

            System.out.println("回路 " + (circuit + 1) + " 的二进制数: " + Integer.toBinaryString(binaryNumber & 0xFF));

            // 遍历每一位，判断是否启用
            for (int timeSlot = 0; timeSlot < 8; timeSlot++) {
                int mask = 1 << timeSlot; // 创建掩码，用来检查每一位
                int bit = (binaryNumber & mask) != 0 ? 1 : 0; // 检查当前位是否为1

                // 输出结果
                if (bit == 1) {
                    int timeSlotNumber = timeSlot + 1; // 启用时段号（从1开始）
                    System.out.println("回路 " + (circuit + 1) + " 对应的启用时段号是 " + timeSlotNumber);
                }
            }

            System.out.println(); // 输出空行，用于分隔每个回路的输出
        }
    }
    }

    class Test2{

        public static void main(String[] args) {
            int decimal = 55; // 要转换的十进制数
            int decimal2 = decimal;
            int decimal3 = decimal;
            // 使用位运算符手动将十进制数转换为二进制数
            StringBuilder binary = new StringBuilder();
            while (decimal > 0) {
                int bit = decimal % 2;
                binary.insert(0, bit);
                decimal >>= 1; // 右移一位，相当于除以2
            }

            System.out.println("十进制数 "+decimal2+" 的二进制表示为: " + binary);
            byte byteValue = (byte) (decimal3 & 0xFF);

            System.out.println("十进制数 "+decimal3+" 的二进制表示为: " +  Integer.toBinaryString(byteValue& 0xFF));


        }

    }

