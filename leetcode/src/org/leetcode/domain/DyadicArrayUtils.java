//package org.leetcode.domain;
//
///**
// * @Author: Zuo Yichen
// * @Date: 2018/12/25 19:52
// */
//public class DyadicArrayUtils {
//    public static int[] stringToIntegerArray(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return new int[0];
//        }
//
//        String[] parts = input.split(",");
//        int[] output = new int[parts.length];
//        for(int index = 0; index < parts.length; index++) {
//            String part = parts[index].trim();
//            output[index] = Integer.parseInt(part);
//        }
//        return output;
//    }
//
//    public static int[][] stringToInt2dArray(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new int[0][0];
//        }
//
//        int[][] arr = new int[jsonArray.size()][];
//        for (int i = 0; i < arr.length; i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            arr[i] = stringToIntegerArray(cols.toString());
//        }
//        return arr;
//    }
//
//    public static String int2dArrayToString(int[][] array) {
//        if (array == null) {
//            return "null";
//        }
//        if (array.length == 0) {
//            return "[]";
//        }
//
//        StringBuilder sb = new StringBuilder("[");
//        for (int[] item : array) {
//            sb.append(Integer.toString(item));
//            sb.append(",");
//        }
//
//        sb.setCharAt(sb.length() - 1, ']');
//        return sb.toString();
//    }
//}
