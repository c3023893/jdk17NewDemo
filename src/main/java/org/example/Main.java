package org.example;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Main {
    private static void oldStyle(Object o) {
        if (o instanceof Fruit furit) {
            System.out.println("This furit is :" + furit);
        }
    }
    public static void main(String[] args) {
        PrintStream out = System.out;
        //文本块
        String text= """
                {
                "username": "zhangsan",
                "password": "123"
                }
                
                """;
        out.println(text);
        //switch表达式
        Fruit apple = Fruit.APPLE;
        switch (apple){
            case PEAR,APPLE ->out.println(1);
            case MANGO,AVOCADO -> out.println(2);
            default -> out.println(3);
        }
        int text2 = switch (apple){
            case PEAR,APPLE -> {
                yield 1;
            }
            case MANGO,AVOCADO ->{
                yield 2;
            }
            default -> {
                yield 3;
            }
        };
        out.println(text2);
        //record关键字
        Record record = new Record("zhansgan", "123");
        out.println(record.password());
        out.println(record.username());
        //sealed classes密封类
        //instanceof模式匹配
        oldStyle(apple);
        //Helpful NullPointerExceptions
        //日期周期格式化
        //精简数字格式化支持
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(100000));
        System.out.println(fmt.format(1000000));
        System.out.println(fmt.format(1000000000));
        //Stream.toList()简化
        String text3="abcd";
        char[] chars = text3.toCharArray();
        List<char[]> chars1 = Stream.of(chars).toList();
    }
}